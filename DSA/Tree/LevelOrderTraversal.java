package DSA.Tree;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LevelOrderTraversal {
    ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        if (root == null)
            return ar;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {  // Fixed condition
            int s = q.size();
            ArrayList<Integer> ar2 = new ArrayList<>();

            for (int i = 0; i < s; i++) {
                TreeNode cur = q.poll();
                ar2.add(cur.data);  // Fixed: Add integer, not TreeNode

                if (cur.left != null)
                    q.add(cur.left);  // Fixed: Use `add`, not `poll`

                if (cur.right != null)
                    q.add(cur.right);  // Fixed: Use `add`, not `poll`
            }
            ar.add(ar2);
        }
        return ar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = buildTree(sc);
        
        LevelOrderTraversal lot = new LevelOrderTraversal();
        ArrayList<ArrayList<Integer>> result = lot.levelOrder(root);
        
        System.out.println("Level Order Traversal:");
        for (ArrayList<Integer> level : result) {
            System.out.println(level);
        }
        
        sc.close();
    }

    static TreeNode buildTree(Scanner sc) {
        System.out.println("Enter data (-1 for null):");
        int data = sc.nextInt();
        if (data == -1)
            return null;

        TreeNode root = new TreeNode(data);
        System.out.println("Enter left data for " + data);
        root.left = buildTree(sc);
        System.out.println("Enter right data for " + data);
        root.right = buildTree(sc);

        return root;
    }
}
