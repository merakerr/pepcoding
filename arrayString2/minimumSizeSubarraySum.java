
/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
*/
import java.util.*;
public class minimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
         int res = Integer.MAX_VALUE;
         
         for(int i = 0; i < nums.length; i++){
             if(nums[i] >= target){
                 return 1;
             }
             
             sum += nums[i];
             while(sum >= target){
                 res = Math.min(res, i - left +1);
                 sum -=nums[left];
                 left++;
             }
         }
         return res == Integer.MAX_VALUE ? 0 :res;
     }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int res = minSubArrayLen(target, arr);
        System.out.println(res);
    }
}
