package DSA.Tree;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;
    
    TreeNode(int val) {
        data = val;
        left = right = null;
    }
}

class Pair<K, V> {
    K key;
    V value;
    
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    K getKey() {
        return key;
    }
    
    V getValue() {
        return value;
    }
}

 class VerticalOrderTraversal {

    public ArrayList<List<Integer>> verticalOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Pair<TreeNode, int[]>> q = new LinkedList<>(); // root, col, row
        TreeMap<Integer, List<int[]>> mp = new TreeMap<>(); // col, row, node value

        q.offer(new Pair<>(root, new int[]{0, 0})); // Starting with root at column 0, row 0

        while (!q.isEmpty()) {
            Pair<TreeNode, int[]> cur = q.poll();
            TreeNode node = cur.getKey();
            int col = cur.getValue()[0];
            int row = cur.getValue()[1];

            // Add current node to the appropriate column in TreeMap
            mp.putIfAbsent(col, new ArrayList<>());
            mp.get(col).add(new int[]{row, node.data});

            // Add left child to queue
            if (node.left != null) {
                q.offer(new Pair<>(node.left, new int[]{col - 1, row + 1})); // col-1 for left child
            }

            // Add right child to queue
            if (node.right != null) {
                q.offer(new Pair<>(node.right, new int[]{col + 1, row + 1})); // col+1 for right child
            }
        }

        // Sorting and adding the result to the final list
        for (List<int[]> entry : mp.values()) {
            // Sort by row first, then by value
            Collections.sort(entry, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            // Add only the node values to the result list
            List<Integer> colList = new ArrayList<>();
            for (int[] nodeData : entry) {
                colList.add(nodeData[1]);
            }
            res.add(colList);
        }

        return res;
    }

    public static void main(String[] args) {
        VerticalOrderTraversal obj = new VerticalOrderTraversal();

        // Example binary tree:
        //       1
        //     /   \
        //    2     3
        //   / \   / 
        //  4   5 6 
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        ArrayList<List<Integer>> result = obj.verticalOrder(root);

        // Printing the vertical order traversal
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
