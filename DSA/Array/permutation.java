package DSA.Array;

import java.util.ArrayList;

public class permutation {
    static ArrayList<ArrayList<Integer>>findperm(int[] nums)
    {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> ar=new ArrayList<>();
        helper(nums,res,ar,0);
        return res;
    }

   static  void helper(int[]nums, ArrayList<ArrayList<Integer>> res,  ArrayList<Integer> ar, int ind)
    {
        if(ind>=nums.length)
        return;

        if(ar.size()==nums.length)
        {
            res.add(new ArrayList<>(ar));
            return;
        }
        ar.add(nums[ind]);
        helper(nums,res,ar,ind+1);
        ar.remove(ar.size()-1);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        ArrayList<ArrayList<Integer>> aList=findperm(nums);
        for (int i = 0; i < aList.size(); i++) { 
            for (int j = 0; j < aList.get(i).size(); j++) { 
                System.out.print(aList.get(i).get(j) + " "); 
            } 
            System.out.println(); 
        } 
    }
}
