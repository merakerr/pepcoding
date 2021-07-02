/*
question
*****************************
let assume one arry with and another with given below
1) -2, 5, 9, 11
2) 4,6,8
merged arr will be-->> -2,4,5,8,9,11
*/
    
    import java.io.*;
    import java.util.*;
    
    public class mergeSorttedArray {
    
      public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){
      int s1 = arr1.length;
      int s2 = arr2.length;
      int []newArr = new int[s1+s2];
      int i = 0;
      int j = 0;
      int k = 0;
      while(i<s1 || j<s2){
          int ival = i<s1?arr1[i]:Integer.MAX_VALUE;
          int jval = j<s2?arr2[j]:Integer.MAX_VALUE;

          if(ival>jval){
              newArr[k]=jval;
              j++;
          }else{
              newArr[k] = ival;
              i++;
          }
          k++;

      }

         return newArr;
      }
    
      public static void print(int[] arr){
          System.out.println("####################");
        for(int i = 0 ; i < arr.length; i++){
          System.out.println(arr[i]);
        }
      }
      public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
          a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for(int i = 0 ; i < m; i++){
          b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a,b);
        print(mergedArray);
      }
    
    }

 
