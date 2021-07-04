


import java.util.*;
  
public class anyToAny {
  
   public static int convertToDecimal(int num, int d){
            int ans = 0;
            int pow = 0;
            while(num != 0){
                int rem = num%10;
                num = num/10;
                 ans = ans + rem*(int)Math.pow(d, pow);
                 pow++;
            }
            return ans;
       }
       public static int decimalToany(int num, int d){
        int ans = 0;
        int pow = 1;
        while(num != 0){
            int rem = num % d;
            num = num/d;
            
           ans+=rem*pow;
           pow = pow*10;
        }
        return ans;

       }


    public static int anyToany(int num, int source, int dest){

       int decimal =  convertToDecimal(num, source);
       int res  = decimalToany(decimal, dest);
        return res;
    }
  
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     int re = anyToany(n, sourceBase, destBase);
     System.out.println(re);
   }   
  }