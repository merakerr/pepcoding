/*
1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum is divisible by K.

Sample Input
6
2 7 6 1 4 5
3
Sample Output
5
*/
    
    import java.util.*;

    public class countOfSubArrayWithDivK {
    
        public static int solution(int[] arr, int k) {
           int remainder = 0;
           int frequency  = 1;
           int sum = 0;
           int count = 0;
           HashMap<Integer, Integer> map = new HashMap<>();
           map.put(remainder, frequency);
           
           for(int i = 0; i < arr.length; i++){
               sum += arr[i];
               remainder = sum % k;
               if(remainder < 0){
                   remainder += k;
               }
               
               if(map.containsKey(remainder)){
                   count += map.get(remainder);
               }
               map.put(remainder, map.getOrDefault(remainder, 0) + 1);
           }
    
            return count;
        }
        
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            int k = scn.nextInt();
            System.out.println(solution(arr, k));
        }
    
    }
    
