/*
1. You are given an array(arr) which contains only 0's and 1's and a number K.
2. You have to find the maximum number of consecutive 1's in the given array if you can flip at most K zeroes.

Sample Input
6
1 1 0 0 1 1
1
Sample Output
3
*/
    
    import java.util.*;

    public class maximumConsecutiveone2 {
    
        public static int solution(int[] arr, int k){
            int res = 0;
            int j = -1;
            int count = 0;
            for(int i = 0; i < arr.length; i++){
              if(arr[i] == 0){
                  count++;
              }


              while(count > k){
                  j++;
                  if(arr[j] == 0){
                      count--;
                  }
              }
              int len = i - j;
              if(len > res){
                  res = len;
              }
            }
    
            return res;
        }
        
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i  < n; i++){
                arr[i] = scn.nextInt();
            }
            int k = scn.nextInt();
            System.out.println(solution(arr,k));
        }
    
    }
    
