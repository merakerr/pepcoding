// leetcode 41

/*
Given an unsorted integer array nums, return the smallest
 missing positive integer.
You must implement an algorithm that runs in O(n) time and
 uses constant extra space.

Example 1:
Input: nums = [1,2,0]
Output: 3

Example 2:
Input: nums = [3,4,-1,1]
Output: 2

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
 */

    
    import java.util.*;

    public class firstMissingPostive {
    
    
      //~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
      public static int firstMissingpositive(int[] nums) {
        int n = nums.length;
        //  find the  occurence of one and mark out of range element
        boolean one = false;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) one = true;

            if(nums[i] < 1 || n < nums[i]) {
                nums[i] = 1;
            }
        }
        if(one == false){
            return 1;
        }
        // mark element in array
        for(int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            int indx = val - 1;
            nums[indx] = -Math.abs(nums[indx]);
        }

        //  check first missing positive
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
      }
    
      //~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
    
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
    
        int res = firstMissingpositive(arr);
        System.out.println(res);
      }
    }

