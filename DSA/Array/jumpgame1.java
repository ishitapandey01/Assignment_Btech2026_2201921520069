package DSA.Array;

public class jumpgame1 {
    public static  boolean  jump(int[] nums)
    {
        int maxjump=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(i>maxjump)
            return false;

            maxjump=Math.max(maxjump, nums[i]+i);
        }
       return true;
    } 
    public static void main(String[] args) {
        int[] nums = {4, 3, 7, 1, 2};

        System.out.print("Array representing maximum jump from each index: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        boolean ans = jump(nums);

        if (ans) {
            System.out.println("It is possible to reach the last index.");
        } else {
            System.out.println("It is not possible to reach the last index.");
        }
    }
}
