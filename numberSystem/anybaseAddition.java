import java.util.*;
  
  public class anybaseAddition{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int base, int num1, int num2){
    int res = 0;

    int carry = 0;
    int power = 1; // 10 ^ 0
    while(num1 != 0 || num2 != 0 || carry != 0) {
        int val1 = num1 % 10;
        num1 /= 10;
        int val2 = num2 % 10;
        num2 /= 10;
        int sum = val1 + val2 + carry;

        int val = sum % base;
        carry = sum / base;
        res += val * power;
        power *= 10;
    }
    return res;
   }
  }