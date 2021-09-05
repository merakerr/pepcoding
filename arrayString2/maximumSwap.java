
    /*
You are given an integer num. You can swap two digits at most once to get the 
maximum valued number.
Return the maximum valued number you can get.

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Input: num = 9973
Output: 9973
Explanation: No swap.
    
    */
    import java.util.*;

    public class maximumSwap {
    
      // ~~~~~~~~~~User Section~~~~~~~~~~~
      public static String maximumSwaps(String n) {
        String num = n+"";

        //converting into string form
        char[] arr = num.toCharArray();
 
        int[] lastIndexOfDigit = new int[10];

        //travel to fill last index of digits
        for(int i = 0; i < arr.length; i++){
            lastIndexOfDigit[arr[i] - '0'] = i;

        }

        //travel and find swapping point
        for(int i = 0; i < arr.length; i++){
            int digit = arr[i] -'0';
            int index = i;
            
            for(int j = 9; j > digit; j--){
                if(lastIndexOfDigit[j] > i){
                    index = lastIndexOfDigit[j];
                    break;
                }
            }
            if(index != i){
                swap(arr, i, index);
                break;
            }
        }
        String res = String.valueOf(arr);
        return res;
      }
    
      private static void swap(char[] arr, int i, int j){
          char temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
      }
      // ~~~~~~~~Input Management~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String ans = maximumSwaps(str);
        System.out.println(ans);
      }
    }
