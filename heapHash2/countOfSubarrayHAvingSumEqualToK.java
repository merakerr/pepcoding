/*
1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum equals k.

Sample Input
3
1 1 1
2
Sample Output
2

*/
    
    import java.util.*;

    public class countOfSubarrayHAvingSumEqualToK {
    
        public static int solution(int[] arr, int k){
          int sum = 0;
          int count = 0;
          int frequency = 1;
          HashMap<Integer, Integer> map = new HashMap<>();
          map.put(sum, frequency);
          
          for(int i = 0; i < arr.length; i++){
              sum += arr[i];
              int val = sum - k;
              if(map.containsKey(val) == true){
                  count += map.get(val);
                  
              }
              
                  map.put(sum, map.getOrDefault(sum, 0)+1);
              
          }
          
            return count;
        }
        
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n; i++){
                arr[i] = scn.nextInt();
            }
            int target = scn.nextInt();
            System.out.println(solution(arr,target));
        }
    
    }
    
