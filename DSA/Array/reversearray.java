package DSA.Array;
import java.util.Scanner;

public class reversearray {
   public reversearray() {
   }

   static void reverse(int[] var0, int var1) {
      int var2 = 0;

      int var4;
      for(int var3 = var1 - 1; var2 < var3; --var3) {
         var4 = var0[var2];
         var0[var2] = var0[var3];
         var0[var3] = var4;
         ++var2;
      }

      for(var4 = 0; var4 < var1; ++var4) {
         System.err.print(var0[var4]);
      }

   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("enter number of element");
      int var2 = var1.nextInt();
      int[] var3 = new int[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = var1.nextInt();
      }

      reverse(var3, var2);
   }
}


