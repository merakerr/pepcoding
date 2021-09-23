//leetcode 643
/*
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
*/

import java.util.*;
public class maxAverageSubarray {
    public static double findMaxAverage(int[] nums, int k) {
        //find sum of first k-1 element
         int sum = 0;
        for(int i = 0; i < k - 1; i++){
            sum += nums[i];
        }
        
        //k-1 element to n
        double res = Integer.MIN_VALUE * 1.0;
        for(int i = k - 1; i < nums.length; i++){
            sum += nums[i];
            double avg = sum * 1.0 / k;
            res = Math.max(avg, res);
            sum -= nums[i - k + 1];
        }
        return res;
        
    }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();

       int[] arr = new int[n];

       for(int i = 0; i < n; i++){
           arr[i] = sc.nextInt();
       }

       int k = sc.nextInt();
       boolean res = findMaxAverage(arr, k);
       System.out.println(res);
   } 
}
