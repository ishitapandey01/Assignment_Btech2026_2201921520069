
package DSA.Array;
import java.util.*;

public class powerset {
    public static void main(String[] args) {
        int[] ar={1,2,3};
        ArrayList<Integer> ls=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        helper(ar,ls,ans,0);
        for(ArrayList<Integer> i:ans)
        {
            System.out.print("[");
            for(int j:i)
            {
                System.out.print("[" +j+ "]");
            }
            System.out.println("]");
        }
    }

    static void helper(int[] ar, ArrayList<Integer> ls, ArrayList<ArrayList<Integer>> ans,int ind )
    {
        
            ans.add(new ArrayList<>(ls));
           
        

        for(int i=ind;i<ar.length;i++)
        {
            ls.add(ar[i]);
            helper(ar,ls,ans,i+1);
            ls.remove(ls.size()-1);
        }
    }
    
}
