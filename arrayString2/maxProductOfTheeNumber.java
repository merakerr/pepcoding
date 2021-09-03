
    
//leetcode 628

/*
Given an integer array nums, find three numbers whose product is maximum and
 return the maximum product.

 Example 1:
Input: nums = [1,2,3]
Output: 6

Example 2:
Input: nums = [1,2,3,4]
Output: 24

Example 3:
Input: nums = [-1,-2,-3]
Output: -6
*/

/*

either max1*max2*max2 --->max product of 3 nums
or min1*min2*max1    ---> max product of 3 nums
*/
//3, 2, -12, 6,-11,-9,1,7,10,4

import java.util.*;

public class maxProductOfTheeNumber {

    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int maximumProduct(int[] arr) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
    
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int max3 = Integer.MIN_VALUE;
             

            /*

            max1 = 6
            max2 = 4
            max3 = 2
           if 8 then   
           max2 = 6   max2 = max1
           max3 = 4   max3 = max2
           max1 = 8   max1 = val
             */
            for(int val : arr) {
                if(val > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = val;
                } else if(val > max2) {
                    max3 = max2;
                    max2 = val;
                } else if(val > max3) {
                    max3 = val;
                }
                if(val < min1) {
                    min2 = min1;
                    min1 = val;
                } else if(val < min2) {
                    min2 = val;
                }
            }
            return Math.max(max1 * min1 * min2, max1 * max2 * max3);
        }
    

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int prod = maximumProduct(arr);
        System.out.println(prod);
    }
}
