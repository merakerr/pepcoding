//minimum increment decrement to make array element equal -->>geeksforgeeks

//leetcode 462.

/*
Given an array of integers where 1 \leq A[i] \leq 10^{18} . In one operation
 you can either Increment/Decrement any element by 1. The task is to find the
  minimum operations needed
 to be performed on the array elements to make all array elements equal.
Input : A[] = { 1, 5, 7, 10 }
Output : 11
Increment 1 by 4, 5 by 0.
Decrement 7 by 2, 10 by 5.
New array A = { 5, 5, 5, 5 } with 
cost of operations = 4 + 0 + 2 + 5 = 11.

Input : A = { 10, 2, 20 }
Output : 18

*/


import java.util.*;
public class minimumMovesToEqual{

//user area
public static int incrementDecrement(int[] arr){
Arrays.sort(arr);
int start = 0;
int end = arr.length;
int median = (start + end) / 2;
int res = 0;
for(int i = 0; i < end; i++){
    res = Math.abs(arr[median] - arr[i])+res;
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

    int res = incrementDecrement(arr);
    System.out.println(res);
}
}