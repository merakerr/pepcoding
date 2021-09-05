//leetcode 537..
    
 /*
 A complex number can be represented as a string on the form "real+imaginaryi" where:
real is the real part and is an integer in the range [-100, 100].
imaginary is the imaginary part and is an integer in the range [-100, 100].
i2 == -1.
Given two complex numbers num1 and num2 as strings, return a string of the complex
 number that represents their multiplications.


Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need 
convert it to the form of 0+2i.
 
 */

    import java.util.*;

    public class complexNumberMultiplication {
    
      // ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~
      public static String complexNumberMultiply(String num1, String num2) {
        int a1 = Integer.parseInt(num1.substring(0, num1.indexOf("+")));
        int b1 = Integer.parseInt(num1.substring(num1.indexOf("+")+1, num1.length()-1));

        int a2 = Integer.parseInt(num2.substring(0, num2.indexOf("+")));
        int b2 = Integer.parseInt(num2.substring(num2.indexOf("+")+1, num2.length()-1));

        int a = a1 * a2 - b1 * b2;
        int b = a1 * b2 + a2 * b1;
        return a + "+"+ b+ "i";
      }
    
      // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num1 = scn.nextLine();
        String num2 = scn.nextLine();
        String res = complexNumberMultiply(num1, num2);
        System.out.println(res);
      }
    }
