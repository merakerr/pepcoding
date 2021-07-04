
//
import java.io.*;
import java.util.*;

public class spanOfArray {
    public static int maxFunc(int []arr){
         int max = Integer.MIN_VALUE;
         for(int i = 0;i<arr.length;i++){
             if(arr[i]>max){
                 max = arr[i];
             }
         }
         return max;
    }
     public static int minFunc(int []arr){
        int min = Integer.MAX_VALUE;
         for(int i = 0;i<arr.length;i++){
             if(arr[i]<min){
                 min = arr[i];
             }
         }
         return min;
    }
    
   public static int spanArray(int []arr){
      int res = 0;
      int  max = maxFunc(arr);
      int  min = minFunc(arr);
      res = max-min;
      return res;
   }
public static void main(String[] args) throws Exception {
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   int []arr = new int[n];
   for(int i = 0;i<n;i++){
       arr[i] = sc.nextInt();
   }
   int res = spanArray(arr);
   System.out.println(res);
 }

}
