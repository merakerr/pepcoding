/*
1. You are given an array that contains only 0s and 1s.
2. You have to find length of the longest subarray with equal number of 0s and 1s.

Sample Input
6
0 1 1 0 1 1
Sample Output
4

*/
    
    import java.util.*;

    public class longestSubarrayWithEqNumOfZero {
    
        public static int solution(int[] arr) {
            //same as longest subarray find
            //just change the 0 value as -1
            
            int sum = 0;
            int index = -1;
            int max = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int max_value = 0;
            map.put(sum, index);
            for(int i = 0; i < arr.length; i++){
              if(arr[i] == 0){
                  sum += -1;
              }else if(arr[i] == 1){
                  sum += 1;
              }
            // int val = arr[i];
            // if(val == 0){
            //     sum += -1;
            // }else{
            //     sum += 1;
            // }
               
               if(map.containsKey(sum)){
                   int diff = i - map.get(sum);
                   max_value = Math.max(diff, max_value);
               }else{
                   map.put(sum, i);
               }
            }
    
            return max_value;
        }
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            System.out.println(solution(arr));
        }
    
    }
    
