package DSA.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class maxwidth {
    public static int findmaxwidth(TreeNode root)
    {
        if(root==null)
        return 0;
        int maxwidth=0;
        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty())
        {
            int size=q.size();
            int min=q.peek().getValue();
            int first=0,last=0;
            for(int i=0;i<size;i++)
            {
                Pair<TreeNode, Integer> p=q.poll();
                TreeNode node=p.getKey();
                int index=p.getValue();
                if(i==0)
                first=index;
                if(i==size-1)
                last=index;
                 
                if(node.left!=null)
                q.offer(new Pair<>(node.left,2*(index-min)+1));
                if(node.right!=null)
                q.offer(new Pair<>(node.right,2*(index-min)+2));
            }
            maxwidth=Math.max(maxwidth,last-first+1);
        }
            return maxwidth;
            
    }
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(findmaxwidth(root));
    }

 }
    

