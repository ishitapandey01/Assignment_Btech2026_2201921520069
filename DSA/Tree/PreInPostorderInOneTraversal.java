package DSA.Tree;
import java.util.*;

class Pair<k,v>
{
    k key;
    v value;
    
    Pair(k key, v value)
    {
        this.key=key;
        this.value=value;
    }
    k getKey()
    {
        return key;
    }
    v getValue()
    {
        return value;
    }
    void setValue(v value)
    {
        this.value=value;
    }

}

public class PreInPostorderInOneTraversal {
    public static List<List<Integer>> Traversals(TreeNode root)
    {
       
        ArrayList<Integer> pre=new ArrayList<>();
        ArrayList<Integer> in=new ArrayList<>();
        ArrayList<Integer> post=new ArrayList<>();
        Stack<Pair<TreeNode,Integer>> st=new Stack<>();
        if (root == null) return Arrays.asList(pre, in, post);
        st.push(new Pair<>(root,1));

        while(!st.isEmpty())
        {
            Pair<TreeNode,Integer> cur=st.pop();
            
            if(cur.getValue()==1)
            {
                pre.add(cur.getKey().data);
                cur.setValue(2);
                st.push(cur);
                if(cur.getKey().left!=null)
                {
                    st.push(new Pair<>(cur.getKey().left,1));
                }
            }

            else if(cur.getValue()==2)
            {
                in.add(cur.getKey().data);
                cur.setValue(3);
                st.push(cur);

                if(cur.getKey().right!=null)
                {
                    st.push(new Pair<>(cur.getKey().right,1));
                }

            }
            else
            {
                post.add(cur.getKey().data);
                
            }
        }
       return  Arrays.asList(pre,in,post);
    }

     public static void printList(List<Integer> list) {
        // Iterate through the list
        // and print each element
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Getting the pre-order, in-order,
        // and post-order traversals
        List<Integer> pre, in, post;
        List<List<Integer>> traversals = Traversals(root);

        // Extracting the traversals
        // from the result
        pre = traversals.get(0);
        in = traversals.get(1);
        post = traversals.get(2);

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        printList(pre);

        System.out.print("Inorder traversal: ");
        printList(in);

        System.out.print("Postorder traversal: ");
        printList(post);
    }
}
