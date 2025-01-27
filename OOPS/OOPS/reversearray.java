package OOPS;
import java.util.*;
public class reversearray {
    static void reverse(int[] ar, int n)
    {
        int l=0;
        int r=n-1;
        while(l<r)
        {
            int temp=ar[l];
            ar[l]=ar[r];
            ar[r]=temp;
            l++;
            r--;
        }
        for(int i=0;i<n;i++)
        {
            System.err.print(ar[i]);
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        {
        System.out.println("enter number of element");
        int n=sc.nextInt();

        int[] ar=new int[n];
        for(int i=0;i<n;i++)
        {
        ar[i]=sc.nextInt();
        }
        reverse(ar,n);
        }

    }
    
}
