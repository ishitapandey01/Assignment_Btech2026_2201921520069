package DSA.Array;

public class kadanesAlgo {
    public static long maxsubarray(int[] nums)
    {
        long max=Long.MIN_VALUE;
        long sum=0;
        for(int num:nums)
        {
          sum=sum+num;
          max=Math.max(max,sum);
          if(sum<0)
          sum=0;
        }
        return max;
    }
    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        long maxSum = maxsubarray(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}
