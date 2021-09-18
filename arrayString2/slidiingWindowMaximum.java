//leetcode 239

/*

You are given an array of integers nums, there is a sliding window of 
size k which is moving from the very left of the array to the very right.
 You can only see the k numbers in the window. Each time the
 sliding window moves right by one position.
Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]

*/


import java.util.*;
public class slidiingWindowMaximum {
    
    private static int[] rightGreaterIndex(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        st.push(0);

        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[st.peek()] < arr[i]){
                res[st.pop()] = i;
            }
            st.push(i);
        }

        while(st.size() > 0){
            res[st.pop()] = arr.length;
        }
        return res;
    }
    public static int[] maxSlidingWindow(int[] arr, int k) {
        int[] res = new int[arr.length - ( k - 1)];
        int indx = 0;
        int[] rgi = rightGreaterIndex(arr);
        int j = 0;
        for(int i = 0; i <= arr.length - k; i++){
            j = i;
            while(rgi[j] < i + k){
                j = rgi[j]; //increasing j index till window size
            }
            //add to the max item in res array
            //res[indx] = rgi[j]-1;
            res[indx] = arr[j];
            indx++;
        }
        return res;
    }

    //print
    public static void printFunc(int[] arr){
        for(int i: arr){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           int n = sc.nextInt();
           int[] arr = new int[n];
           for(int i = 0;i<n;i++){
               arr[i] = sc.nextInt();
           }
           int k = sc.nextInt();
       
            
          int[] res =  maxSlidingWindow(arr, k);
           printFunc(res);
    }
}
