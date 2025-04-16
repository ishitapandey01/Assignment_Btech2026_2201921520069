package DSA.Array;

public class shift {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        int n = arr.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            shift(arr, i, j);
            i += 2; // Move to the next alternate position
            j-=1; 
        }
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.print(arr[idx]);
        }
    }
    public static void shift(int[] arr, int i, int j)
    {
        
        int temp=arr[j];
        for(int k=j;k>i;k--)
        {
            arr[k]=arr[k-1];
        }
        arr[i]=temp;
    }
}
