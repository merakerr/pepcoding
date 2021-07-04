
import java.util.*;
class anybasetoabybase{
        //this function convert every number into decimal  (num)10
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

            // int ans = 0;
            // int pow = 1;
            // while(num != 0){
            //     int rem = num%10;
            //     num = num/10;
            //      ans = ans + rem*pow;
            //      pow = pow*d;
            // }
            // return ans;

       }
     
       //this function convert the decimal to any other number (binary, octal)
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

    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
          int sourceBase = scn.nextInt();
          int  destBase= scn.nextInt();
          int res = anyToany(n, sourceBase, destBase);
          System.out.println(res);
    }
}