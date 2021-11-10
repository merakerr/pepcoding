/*
1. You are given an array(arr) of integers.
2. You have to find the length of the largest subarray with sum 0

Sample Input
8
15 -2 2 -8 1 7 10 23
Sample Output
5
*/


    
    import java.util.*;

    public class largestSubArrayWithZeroSum {
        
        public static int solution(int[] arr) {

            //      sum & index
            HashMap<Integer, Integer> map = new HashMap<>();
            int max_len = 0;
            int i = -1;
            int sum = 0;
           
             map.put(sum, i);

             while(i < arr.length - 1){
                 i++;
                 sum += arr[i];

                 if(map.containsKey(sum) == false){
                    //previously sum is not present---> add the sum
                    map.put(sum, i);
                 }else{
                     //get the index length
                     int len = i - map.get(sum);
                     if(len > max_len){
                         max_len = len;
                     }

                 }
             }
    
            return max_len;
        }
    
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int[] arr = new int[scn.nextInt()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scn.nextInt();
            }
            System.out.println(solution(arr));
        }
    
    }
    
