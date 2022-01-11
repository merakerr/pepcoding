/*
1. You are given an array that contains only 0s, 1s, and 2s.
2. You have to find the count of subarrays with equal number of 0s, 1s, and 2s.

Sample Input
7
0 1 0 2 0 1 0
Sample Output
2
*/


import java.util.*;

public class countOfSubarray012 {

    public static int solution(int[] arr) {
       int res = 0;
       int c0 = 0;
       int c1 = 0;
       int c2 = 0;
       String key = (c1 - c0) + "#" + (c2 - c1);
       HashMap<String, Integer> map = new HashMap<>();
       int freq = 1;
       map.put(key, freq);
       
       for(int val : arr){
           if(val == 0){
               c0++;
           }else if(val == 1){
               c1++;
           }else{
               c2++;
           }
           key = (c1 - c0) + "#" + (c2 - c1);
           if(map.containsKey(key) == true){
               res += map.get(key);
               map.put(key, map.get(key) + 1);
           }
           //if first time
           else{
            map.put(key, 1);
           }
          
       }

       return res;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}

