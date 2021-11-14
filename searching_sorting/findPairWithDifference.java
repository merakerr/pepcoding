/*
1. Given an array arr of size n, you need to write a program to find if there exists a pair of elements in the array whose difference is equals to target.
2. If there exists such a pair print it, otherwise print -1.

Sample Input
6
5 2 3 80 5 20
78
Sample Output
2 80
*/


    
    import java.util.*;
    import java.io.*;
    
    public class findPairWithDifference {
    

        //2 3 5 5 20 80---->17(arrays.sort)
        public static void findPair(int[]arr,int target) {
           int low = 0;
           int high = 1;
           Arrays.sort(arr);
           while(high < arr.length && low < high){
           int diff = arr[high] - arr[low];

           if(diff == target){
               System.out.println(arr[low] + " " + arr[high]);
               return;
           }
           else if(diff > target){
               low++;
           }
           else{
               high++;
           }
           }
         System.out.println(-1);
        }
    
        public static void main(String[]args) {
    
            //input work
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
    
            int[]arr = new int[n];
    
            for(int i=0; i < n;i++) {
                arr[i] = scn.nextInt();
            }
    
            int target = scn.nextInt();
            findPair(arr,target);
        }
    }
