/*
1. You are given an array that contains only 0s and 1s.
2. You have to find the count of subarrays with equal number of 0s and 1s.


Sample Input
6
0 1 1 0 1 1
Sample Output
4
*/
    
    import java.util.*;

    public class countSubArrayWithEqualNumofZeorOne {
    
        public static int solution(int[] arr) {
          int freq  = 0;
          int sum = 0;
          int count = 0;
          HashMap<Integer, Integer> map = new HashMap<>();
          map.put(sum, 1);  //sum(0) with 1 freq
          
          for(int i = 0; i < arr.length; i++){
              if(arr[i] == 0){
                  sum += -1;
              }else if(arr[i] == 1){
                  sum += 1;
              }
              
              if(map.containsKey(sum)){
                  count += map.get(sum);
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
    
