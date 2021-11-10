//how many subarray possible with 0 sum 

/*
1. You are given an array(arr) of integers.
2. You have to find the count of all subarrays with sum 0.

Sample Input
8
15 -2 2 -8 1 7 10 23
Sample Output
3
*/

    import java.util.*;

    public class countOfAllSubarrayWithZeroSum {
    
        public static int solution(int[] arr) {
           
           HashMap<Integer, Integer> map = new HashMap<>(); // <sum, freq>

           int count = 0;
           int i = -1;
           int sum = 0;
           map.put(sum, 1);

           while(i < arr.length - 1){
               i++;
               sum += arr[i];
               if(map.containsKey(sum)){
                   count += map.get(sum); //get the frequency of count
                   map.put(sum, map.get(sum) + 1);
               }else{
                   map.put(sum, 1);
               }
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
            System.out.println(solution(arr));
    
        }
    
    }
    
