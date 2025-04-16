package DSA.Array;
import java.util.*;
public class subsetsum {
    public static void main(String[] args) {
        
        int[] ar={1,2,5,3,4};
        
        ArrayList<Integer> ls=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        helper(ar,ls,ans,0,9);
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
    
    static void helper(int[] ar, ArrayList<Integer> ls, ArrayList<ArrayList<Integer>> ans,int ind,int target)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(ind==ar.length || target<0) return;
        ls.add(ar[ind]);
        helper(ar,ls,ans,ind+1,target-ar[ind]);
        ls.remove(ls.size()-1);
        //helper(ar,ls,ans,ind+1,target);
        
            
        }
    }

