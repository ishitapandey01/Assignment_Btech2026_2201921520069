package DSA.Tree;
import java.util.*;



class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data=data;
        left=null;
        right=null;
    } 
}

public class buildtree {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        TreeNode root=buildtree();
    }
     static TreeNode buildtree()
     {
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        if(data==-1)
        return null;
        TreeNode root=new TreeNode(data);
        System.out.println("enter left data for "+data);
        root.left=buildtree();
        System.out.println("enter left data for "+data);
        root.right=buildtree();

        return root;

     }
}
