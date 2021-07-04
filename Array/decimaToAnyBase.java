

import java.util.*;
  
public class decimaToAnyBase {
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
       // write code here
     //  public static int DecimalToAnybase(int num, int b) {
        int res = 0;
        int power = 1; // 10 ^ 0

        while(n != 0) {
            int rem = n % b;
            n /= b;
            res += rem * power;
            power *= 10;
        }

        return res;
    }

   }
