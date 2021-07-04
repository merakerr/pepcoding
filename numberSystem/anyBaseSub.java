

import java.util.*;
  
public class anyBaseSub {
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
       // write your code here
      // public static int anybaseSubtraction(int n1, int n2, int b) {
        // solve n2 - n1
        int carry = 0;
        int res = 0;
        int power = 1; // 10 ^ 0

        while(n2 != 0) {
            int val2 = n2 % 10;
            n2 /= 10;
            int val1 = n1 % 10;
            n1 /= 10;

            int val = (val2 + carry) - val1;
            if(val < 0) {
                val += b;
                carry = -1;
            } else {
                // reset carry
                carry = 0;
            }

            res += val * power;
            power *= 10;
        }

        return res;
    }
   }