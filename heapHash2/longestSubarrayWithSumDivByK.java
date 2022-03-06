/*
1. You are given an array of integers(arr) and a number K.
2. You have to find length of the longest subarray whose sum is divisible by K.

Sample Input
6
2 7 6 1 4 5
3
Sample Output
4
*/
    
    import java.util.*;

    public class longestSubarrayWithSumDivByK {
    
        public static int solution(int[] arr, int k) {
            //need to store (remainder, index)
            int remainder = 0;
            int index = -1;
            int sum = 0;
            int max_subarray = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(remainder, index);
            for(int i = 0; i < arr.length; i++){
                sum += arr[i];
                remainder = sum % k;
                if(remainder < 0){
                    remainder += k;
                }
                if(map.containsKey(remainder)){
                    int val = i - map.get(remainder);
                    
                    max_subarray = Math.max(max_subarray, val);
                }
                else{
                    map.put(remainder, i);
                }
            }
    
            return max_subarray;
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
    
