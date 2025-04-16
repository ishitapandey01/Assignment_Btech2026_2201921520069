package DSA.DP;

public class equalpartitionsubset {
    public static void main(String[] args) {
        int[] nums={2,2,4};
        System.out.println(findequal(nums));;
    }
    public static boolean findequal(int[] nums)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        if(sum%2!=0) return false;

        int target=sum/2;
        int n=nums.length;
     
        return helper(nums,target,n);
    }

    public static boolean helper(int[] nums, int target, int n)
    {
      boolean[][] dp=new boolean[n+1][target+1];
      for(int i=0;i<n+1;i++)
      {
        dp[i][0]=true;
      }
      for(int i=1;i<target+1;i++)
      {
        dp[0][i]=false;
      }
      for(int i=1;i<n+1;i++)
      {
        for(int j=1;j<target+1;j++)
        {
            if(nums[i-1]<=j)
            {
                dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
            }
            else
            {
                dp[i][j]=dp[i-1][j];
            }
        }
      }
      return dp[n][target];
    }
}
