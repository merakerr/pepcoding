/*
1. Given an ascending sorted rotated array arr of distinct integers of size N. 
2. The array is right rotated K times. 
3. Your task is to find the value of K.

Sample Input
6
5 6 1 2 3 4
Sample Output
2

need to return the minimum number index from a sorted and
rotated array
*/


    
    import java.util.*;
    public class findRotationCount {
    
        public static int findRotationCount(int[] arr) {
          int low = 0;
          int high = arr.length - 1;

          //in case no rotation
          if(arr[low] <= arr[high]){

          }
        }
    
        public static void main(String[]args) {
            //input work
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
    
            int[]arr = new int[n];
            for(int i = 0 ; i < n; i++) {
                arr[i] = scn.nextInt();
            }
    
            int ans = findRotationCount(arr);
            System.out.println(ans);
        }
    }
