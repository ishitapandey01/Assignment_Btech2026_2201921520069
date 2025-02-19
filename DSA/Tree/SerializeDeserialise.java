package DSA.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialise {
    StringBuilder sb=new StringBuilder();
    public String Serialize(TreeNode root)
    {
     preorder(root);
      return sb.toString();
       
    }
    void preorder(TreeNode root)
    {
        if(root==null)
        {
            sb.append("null");
            sb.append(" ");
            return;
        }

        sb.append(root.data).append(" ");
        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode Deserialize(String data)
    {
        if(data.isEmpty())
        return null;

        Queue<String> q=new LinkedList<>(Arrays.asList(data.split(" ")));
        return helper(q);
    }
    public TreeNode helper(Queue<String> q)
    {
      if(q.isEmpty())
      return null;
      
      String val=q.poll();
      if(val.equals("null"))
      return null;

      TreeNode root=new TreeNode(Integer.parseInt(val));
      root.left=helper(q);
      root.right=helper(q);
      return root;
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        SerializeDeserialise codec = new SerializeDeserialise();

        // Serialize the tree
        String serializedData = codec.Serialize(root);
        System.out.println("Serialized Tree: " + serializedData);

        // Deserialize the string back into a tree
        TreeNode newRoot = codec.Deserialize(serializedData);
        System.out.println("Tree Deserialized Successfully!");

    }


    
}

