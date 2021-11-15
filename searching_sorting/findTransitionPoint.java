/*
1. Given a sorted array containing only 0s and 1s, find the transition point.
2. Transition Point is defined as 1's starting point.
3. If there is no transition point, return -1.

Sample Input
6
0 0 0 0 1 1
Sample Output
4
*/
 
    import java.util.*;
    import java.io.*;
    
    public class findTransitionPoint {
    
        //code written here 
      public static int findTransition(int[]arr) {
        int res = -1;
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == 1){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
      }
    
      public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];
    
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
    
        System.out.println(findTransition(arr));
      }
    }
