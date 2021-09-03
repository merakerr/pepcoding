//leetcode 556
/*
Given a positive integer n, find the smallest integer which has exactly
 the same digits existing in the integer n and is greater in
 value than n. If no such positive integer exists, return -1.

 Example 1:
Input: n = 12
Output: 21

Example 2:
Input: n = 21
Output: -1


132-->>213

123, 132, 213, 231, 312, 321 ---> 213 is next greater element
*/


/*
process
1) find point from which we can swap digit 
2) swap pointed digit from its ceil from right side
3) reverse from pointed digit to last 
4) convert it into string again
*/
    import java.util.*;

    public class nextGreaterElement3 {
        
        //~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
        public static String nextGreaterElement(String str) {
            if(str.length() == 1){
                return "-1";
            }
            char[] arr = str.toCharArray();
            int dipIndx = dipIndex(arr);
            if(dipIndx == -1){
                return "-1";
            }

            int ceilindx = ceilIndex(arr, dipIndx);
            swap(arr, dipIndx, ceilindx);
            reverse(arr, dipIndx+1);
            return String.valueOf(arr);

        }

        public static int dipIndex(char[] arr){
            int indx = arr.length - 2;
            while(indx >= 0 && (arr[indx] >= arr[indx+1])){
                indx--;
            }
            return indx;
        }

        public static int ceilIndex(char[] arr, int indx){
        for(int i = arr.length -1; i >= 0; i--){
            if(arr[i] > arr[indx]){
                return i;
            }
        }
        return -1;
        }
        private static void swap(char[] arr, int left, int right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        private static void reverse(char[] arr, int indx) {
            int left = indx;
            int right = arr.length - 1;
            while(left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    
        //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String num = scn.next();
            String res = nextGreaterElement(num);
    
            System.out.println(res);
        }
    }





    /*
    in leetcode ---->>
    class Solution {
    
    public int nextGreaterElement(int n) {
        String str = n+"";
        String res_ =  nextGreaterElement_(str);
         long res = Long.parseLong(res_);
         if(res <= Integer.MAX_VALUE) {
            return (int)res;
        } else {
            return -1;
        }   
    }
    
    */