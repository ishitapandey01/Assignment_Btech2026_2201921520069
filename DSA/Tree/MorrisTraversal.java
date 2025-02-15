package DSA.Tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    ArrayList<Integer> MorrisInorderTraversal(TreeNode root)
    {
        ArrayList<Integer> inorder=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null)
        {
            if(cur.left==null)
            {
                inorder.add(cur.data);
                cur=cur.right;
            }
            else 
            {
             if(cur.left!=null)
             {
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur)
                {
                   prev=prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=cur;
                    cur=cur.left;
                }
                else
                {
                    prev.right=null;
                    inorder.add(cur.data);
                    cur=cur.right;
                }
             }
            }
        }
        return inorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        MorrisTraversal sol=new MorrisTraversal();
        List<Integer> inorder = sol.MorrisInorderTraversal(root);

        System.out.print("Binary Tree Morris Inorder Traversal: ");
        for (int i = 0; i < inorder.size(); i++) {
            System.out.print(inorder.get(i) + " ");
        }
        System.out.println();
    }
    
}
