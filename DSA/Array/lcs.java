package DSA.Array;

import java.util.*;

public class lcs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter two string");
        String s1=sc.next();
        String s2=sc.next();
        int n=lcs(s1,s2);
        System.out.println(n);
        sc.close();
    }
    static int lcs(String s1, String s2)
    {
        int m=s1.length();
        int n=s2.length();
        int[][]dp=new int[m+1][n+1];
      
       for(int i=1;i<=m;i++)
       {
        for(int j=1;j<=n;j++)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                dp[i][j]=dp[i-1][j-1]+1;

            }
            else{
            dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);

            }
        }

       }
       return dp[m][n];
    }
}
