import java.util.Scanner;

/*
Given a positive integer N, find the smallest number S such that the product of all the digits of S is equal to the number N. If there's no such number, Print "-1".

 

Example 1:

Input:
N = 100
Output:
455
Explanation:
4*5*5 = 100. There are no numbers
less than 455 with the product of
it's digit as 100.
*/

public class digitMultiplier {

    
 public static String getSmallest(Long num) {
        if(num == 1){
         return "1";
        }
        String res = "";
        for(int i = 9; i >= 2; i--){
            while(num % i == 0){
                res = i + res;
                num /= i;
            }
        }
        return num != 1 ? "-1": res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = getSmallest(str);
        System.out.println(res);
    }
}
