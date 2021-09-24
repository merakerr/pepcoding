//leetcode 442
/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.
Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:
Input: nums = [1,1,2]
Output: [1]
Example 3:
Input: nums = [1]
Output: []

*/
import java.util.*;
public class findAllDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int indx = Math.abs(nums[i]) - 1;
            int val = nums[indx];

            if(val < 0) {
                // indx + 1 is repitited
                res.add(indx + 1);
            } else {
                // mark it
                nums[indx] *= -1;
            }
        }
        return res;
    } 

    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int[] arr = new int[n];
     for(int i = 0; i < arr.length; i++){
         arr[i] = sc.nextInt();
     }
     List<Integer> res = findDuplicates(arr);
     System.out.println(res);
    }
}
