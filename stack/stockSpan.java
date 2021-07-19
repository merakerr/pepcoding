/*
In this problem , basically finding the stock price by how 
many days its price is higher than the current price in the array
M    given arr-->>[2 5 9 3 1 12 6 8 7]     //M denotes the market before open
     solution---->[1,2,3,1,1,6,1,2,1]

     for the 2-->> stock price might be greater than before the market, 
     similary for 5,9, & 12 the price might be higher before the market open
     as all the prices to the left are smaller than them..

     similarly for 6, it is 1 day before ie price is 12, and for 7 it is 8,


     /here we concluded that the following solution will be
     //next greater element on left-->>
*/

import java.util.*;
public class stockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] arr = new int[n];
       for(int i = 0;i<n;i++){
           arr[i] = sc.nextInt();
       }

       //int result send to print function
       int[] res = stockspan(arr);
       printFunc(res);


    }
    
    public static void printFunc(int[] arr){
        for(int i: arr){
            System.out.println(i);
        }
    }
    //main stock span function
    public static int[] stockspan(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
      
           st.push(arr.length-1);
           for(int i = arr.length-2;i>=0;i--){
               while(st.size()>0 &&  arr[st.peek()]<arr[i]){
                   res[st.pop()] = i;
               }
               st.push(i);
           }
           while(st.size()>0){
               res[st.pop()] = -1;
           }

           for(int i = 0; i < res.length; i++) {
            res[i] = i - res[i];
        }
      
      return res;
       
    }
}
