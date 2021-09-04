// leetcode 324

/*
Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
You may assume the input array always has a valid answer.

Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.

*/

import java.util.*;

public class wiggleSort2 {

  // ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~
  public static void wiggleSort(int[] nums) {
    int n = nums.length;
    int[] arr = new int[n];

    for(int i = 0; i < n; i++){
        arr[i] = nums[i];
    }
    Arrays.sort(arr);
    
    int j = n - 1;
    int i = 1;

    //fill odd index
    while(i < n){
        nums[i] = arr[j];
        j--;
        i +=2;
    }

    //fill even index

    i = 0;
    while(i < n){
        nums[i] = arr[j];
        j--;
        i += 2;
        
    }

  }

  // ~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    wiggleSort(arr);
    /*
    -if index is even then smaller than next,
    -if index is odd then greater than next element,
    -to check any correct order, we will not print array, we will check inequality
    -if print false, that means wrong answer, if true than correct answer.
    */
    for (int i = 0; i < n - 1; i++) {
      if (i % 2 == 0 && arr[i] >= arr[i + 1]) {
        System.out.println(false);
        return;
      } else if (i % 2 == 1 && arr[i] <= arr[i + 1]) {
        System.out.println(false);
        return;
      }
    }
    System.out.println(true);
  }
}