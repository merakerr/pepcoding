// leetcode 905
    
/*
Given an integer array nums, move all the even integers at the
 beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would 
also be accepted.

Example 2:
Input: nums = [0]
Output: [0]

*/

    import java.util.*;

    public class sortArrayByParity {
    
        // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
        
        public static void sortArrayByParity(int[] nums) {
            int i = 0; // first unsolved
            int j = 0; // first odd
    
            while(i < nums.length) {
                if(nums[i] % 2 == 0) {
                    // even
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
    
                    i++;
                    j++;
                } else {
                    // odd
                    i++;
                }
            }
            
        }
    
        //// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
    
            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
    
            sortArrayByParity(arr);
    
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
