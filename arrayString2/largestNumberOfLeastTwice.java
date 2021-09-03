import java.util.Scanner;

//Largest Number At Least Twice of Others

//leetcode 747

/*
You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much
 as every other number in the array. If it is, return the index of the largest
  element, or return -1 otherwise.

Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.
*/

import java.util.*;
public class largestNumberOfLeastTwice{

  public static int dominantIndex(int[] nums) {
    if(nums.length == 1) return 0;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int indx = 0;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] > max1) {
            max2 = max1;
            max1 = nums[i];
            indx = i;
        } else if(nums[i] > max2) {
            max2 = nums[i];
        }
    }
    return max1 >= 2 * max2 ? indx : -1;  
  }
public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();

  int[] arr = new int[n];
  for (int i = 0; i < n; i++){
    arr[i] = sc.nextInt();
  }
  int res = dominantIndex(arr);
  System.out.println(res);
}
}