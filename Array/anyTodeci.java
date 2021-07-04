
    

import java.util.*;
  
public class anyTodeci {
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
       
      // write your code here
     //  public static int AnybaseToDecimal(int num, int b) {
        int power = 1; // base ^ 0
        int res = 0;
        
        while(n != 0) {
            int digit = n % 10;
            n /= 10;
            res += digit * power;
            power *= b;
        }

        return res;
    }
   }