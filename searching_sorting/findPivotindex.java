/*
1. Given an array of integers nums, calculate the pivot index of this array.
2. The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
3. If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
4. Return the leftmost pivot index. If no such index exists, return -1.

Sample Input
6
1 7 3 6 5 6
Sample Output
3
*/

    import java.util.*;
    import java.io.*;
    
    public class findPivotindex {
    
        //code written here 

        public static int pivot_index(int[]arr) {
            int total_sum = 0;
            int left_sum = 0;
            for(int i = 0; i < arr.length; i++){
                total_sum += arr[i];
            }
            
            for(int i = 0; i < arr.length; i++){
                total_sum -= arr[i];

                if(total_sum == left_sum){
                    return i;
                }
                left_sum += arr[i];
            }
            return -1;
        }

        // public static int pivot_index(int[]arr) {
        //     int total_sum = 0;
        //     int left_sum = 0;
        //     for(int i = 0; i < arr.length; i++){
        //         total_sum += arr[i];
        //     }
            
        //     total_sum = total_sum - arr[0];  //first sum decrease
        //     for(int i = 1; i < arr.length; i++){
               
        //         if(left_sum == total_sum){
        //             return i-1;
        //         }
        //          left_sum += arr[i-1];
        //          total_sum -= arr[i];
        //     }
        //     return -1;
        // }
    
        public static void main(String[]args) {
            //input work
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
    
            int[]arr = new int[n];
    
            for(int i=0; i < arr.length;i++) {
                arr[i] = scn.nextInt();
            }
    
            int pi = pivot_index(arr);
            System.out.println(pi);
        }
    }
