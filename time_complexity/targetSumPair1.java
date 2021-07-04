/**
 * 12 ---- elements
{9 ,-48,100,43,84,74,86,34,-37,60,-29,44}
 target = 160

o/o:-
60, 100
74, 86
 */
 

    import java.io.*;
    import java.util.*;
    
    public class targetSumPair1 {
    
      public static void targetSumPair(int[] arr, int target){
        //-48 -37 -29 9 34 43 44 60 74 84 86 100
       Arrays.sort(arr);
       int left = 0;
       int right = arr.length-1;

       while(left<right){
        int sum = arr[left] + arr[right];
        if(sum == target){
          System.out.println(arr[left]+", "+arr[right]);
          left++;
          right--;
        }
        else if(sum>target){
          right--;
        }
        else{
          left++;
        }




       }
        

        
    
      }
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
          arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr,target);
      }
    
    }

