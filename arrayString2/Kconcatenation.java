/*
1. You are given an array(arr1) of integers and an integer k.
2. Another array(arr2) is formed by concatenating K copies of arr1.
   For example, if arr1 = {1,2} and k = 3, then arr2 = {1,2,1,2,1,2}.
3. You have to find the maximum subarray sum in arr2.
Input Format
A number N
a1
a2.. N integers
A number K

input:
3 1 2 3 3

output:
18
*/
    
    import java.io.*;
    import java.util.*;
    
    public class Kconcatenation {
    
       public static long maxSubArray(int[] nums) {
            long csum = 0;
            long osum = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++) {
                if(csum < 0) {
                    csum = nums[i];
                } else {
                    csum += nums[i];
                }
                if(csum > osum) {
                    osum = csum;
                }
            }
            return osum;
        }
     //if sum is less than sum..
     //kadane can be within one array or intersaction of two
     //-10, 2, 3 || -10, 2, 3  --->>kadane =5 in same array
     //3 -2, -3, -1, 2 || 3 -2, -3, -1, 2 >> kadane = 5 intersection of two array
     //so merge 1 and 2 and find kadane
        private static long kadanes1_2(int[] arr) {
            int n = arr.length;
            int[] narr = new int[2 * n];
    
            for(int i = 0; i < n; i++) {
                narr[i] = arr[i];
                narr[n + i] = arr[i];
            }
            return maxSubArray(narr);
        }
    
        public static long solution(int[] arr, int k, long sum) {
            if(k == 1) {
                return maxSubArray(arr);
            }
            long kadane12 = kadanes1_2(arr);
            if(sum < 0) {
                return kadane12;
            } else {
                return kadane12 + (sum * (k - 2));
            }
        }
    
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
          arr[i] = scn.nextInt();
          sum += arr[i];
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k, sum));
      }
    
    }
