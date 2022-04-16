/*
1. You are given an array of size 'n' and n elements of the same array.
2. You are required to find and print all the subarrays of the given array. 
3. Each subarray should be space seperated and on a seperate lines. Refer to sample input and output.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
[Tab separated elements of subarray]
..
All subarrays
*/

import java.io.*;
import java.util.*;

public class subarrayProblem  {

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];

    for(int i = 0;i<n;i++){
        arr[i] = sc.nextInt();
    }


    //
    printSubArray(arr);
 }
public static void printSubArray(int []arr){
    
    for(int sp = 0; sp < arr.length; sp++){
        for(int ep = sp; ep < arr.length; ep++){
            for(int i = sp; i <= ep; i++){
                System.out.print(arr[i] + "	");

            }
            System.out.println();
        }
    }
}
}

