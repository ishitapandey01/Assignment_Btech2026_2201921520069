package DSA.Tree;
import java.util.*;
public class height_diameter {
    int diameter=0;
    int heightoftree(TreeNode root)
    {
        if(root==null)
        return 0;

        int left=heightoftree(root.left);
        int right=heightoftree(root.right);

        return 1+Math.max(left,right);

    }
    int diameteroftree(TreeNode root)
    {
        if(root==null)
        return 0;

        int left=heightoftree(root.left);
        int right=heightoftree(root.right);
         diameter=Math.max(diameter, left+right);

        return 1+Math.max(left,right);
        
    }
    int diam(TreeNode root)
    {
        diameteroftree(root);
        return diameter;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = buildTree(sc);

        height_diameter obj = new height_diameter();
        
        int height = obj.heightoftree(root);
        int diameter = obj.diam(root);

        System.out.println("Height of tree: " + height);
        System.out.println("Diameter of tree: " + diameter);

        sc.close();
    }

    // Function to build a tree using user input
    static TreeNode buildTree(Scanner sc) {
        System.out.println("Enter data (-1 for null):");
        int data = sc.nextInt();
        if (data == -1)
            return null;

        TreeNode root = new TreeNode(data);
        System.out.println("Enter left child of " + data);
        root.left = buildTree(sc);
        System.out.println("Enter right child of " + data);
        root.right = buildTree(sc);

        return root;
    }
}


    

