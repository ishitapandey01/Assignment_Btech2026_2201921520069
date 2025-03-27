class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class IdenticalTrees {
    static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // Both trees are empty
        if (p == null || q == null || p.val != q.val) return false; // One is empty or values don't match

        // Recursively check left and right subtrees
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = build();
        TreeNode root2 = build();

        System.out.println("Are the trees identical? " + isSame(root1, root2)); // Expected: true
    }

    static TreeNode build() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }
}
