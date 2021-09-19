/*
Given an array A[] of size N and a positive integer K, find the first negative
 integer for each and every window(contiguous subarray) of size K.

Example 1:
Input : 
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output : 
-8 0 -6 -6
Explanation :
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6
 
Example 2:
Input : 
N = 8
A[] = {12, -1, -7, 8, -15, 30, 16, 28}
K = 3
Output :
-1 -1 -7 -15 -15 0 

*/
import java.util.*;
public class firstNegativeIntegerKsizeWindow {
    public static long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        int index = n;
        long[] res = new long[n-(k-1)];
        //marking last window
        for(int i = n-1; i >= n - k; i--){
            if(arr[i] < 0){
                index = i;
            }
        }
        //it means if 5th, 6th and 7 index is found then it set the index
        
        
        //from n-k index to 0 th index checking
        //means from 5th index to 0
        for(int i = n-k; i >= 0; i--){
            if(arr[i] < 0){
                index = i;
            }
            
            if(index < i + k){
                //it means index found within a window
                res[i] = arr[index];
            }
            else{
                res[i] = 0;
                //not found
            }
        }
       return res; 
    }


    public static void printFunc(long[] arr){
        for(long i : arr){
          System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextLong();
        }
        //int N = sc.nextInt();
        int K = sc.nextInt();
        long[] res = printFirstNegativeInteger(arr, n, K);
        printFunc(res);
    }
}
