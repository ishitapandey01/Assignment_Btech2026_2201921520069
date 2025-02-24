package DSA.Array;

public class MooreVotingAlgorithm {
    public static int majorityElement(int nums[])
    {
        int count=0, candidate=-1;
        for (int i = 0; i < nums.length; i++) {
            if(count==0)
            {
                candidate=nums[i];

            }
            if(candidate==nums[i])
            count++;
            else
            count--;
        }

        for(int num:nums)
        {
            if(num==candidate)
            count++;
        }
      if(count>=(nums.length/2))
      return candidate;
      
      return -1;
    } 
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int majority = majorityElement(nums);
        if (majority != -1) {
            System.out.println("Majority Element: " + majority);
        } else {
            System.out.println("No Majority Element found");
        }
    }
}
