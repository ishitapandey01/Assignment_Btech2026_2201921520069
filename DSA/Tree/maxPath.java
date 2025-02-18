package DSA.Tree;

public class maxPath {
    int max=Integer.MIN_VALUE;
    int pathmax(TreeNode root)
    {
        findmaxPath(root);
        return max;
    }
    int findmaxPath(TreeNode root)
    {
        if(root==null)
        return 0;

        int leftmax=Math.max(0,findmaxPath(root.left));
        int rightmax=Math.max(0,findmaxPath(root.right));
        max=Math.max(max,leftmax+rightmax+root.data);
        return Math.max(leftmax,rightmax)+root.data;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        // Creating an instance of the Solution class
        maxPath solution = new maxPath();

        // Finding and printing the maximum path sum
        int maxPathSum = solution.pathmax(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
    
}
