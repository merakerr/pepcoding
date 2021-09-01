
    //leetcode 977

    /*Given an integer array nums sorted in non-decreasing order, return an 
    array of the squares of each number sorted in non-decreasing order.
   
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

*/
    
    import java.util.*;

    public class sqareOfSortedArray {
    
        // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    
        public static int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];

            int i = 0;
            int j = nums.length - 1;
            
            for(int k = nums.length - 1; k >= 0; k--) {
                int val1 = nums[i] * nums[i];
                int val2 = nums[j] * nums[j];
                if(val1 > val2) {
                    res[k] = val1;
                    i++;
                } else {
                    res[k] = val2;
                    j--;
                }
            }
            return res;
        }
    
        // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] nums = new int[n];
            
            for(int i = 0; i < n; i++) 
                nums[i] = scn.nextInt();
            
            int[] res = sortedSquares(nums);
    
            for(int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }