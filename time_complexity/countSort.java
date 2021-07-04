
    
    import java.io.*;
    import java.util.*;
    
    public class countSort {
    
      public static void countSorts(int[] arr, int min, int max) {
        int[] fmap = new int[max - min + 1];
        // 1. fill frequency map
        for(int i = 0; i < arr.length; i++) {
            int indx = arr[i] - min;
            fmap[indx]++;
        }
        // 2. fill array
        int indx = 0;
        for(int i = 0; i < fmap.length; i++) {
            int fq = fmap[i];
            int val = i + min;
            for(int j = 0; j < fq; j++) {
                arr[indx] = val;
                indx++;
            }
        }
       
      }
    
      public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.println(arr[i]);
        }
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
          max = Math.max(max, arr[i]);
          min = Math.min(min, arr[i]);
        }
        countSorts(arr,min,max);
        print(arr);
      }
    
    }
