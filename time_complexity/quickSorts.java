
/**
 * in this problem we will divide the array in the basis of pivot element-->>
 * pivot is the element in which the left side of its contents are less and right 
 * side of its content are big
 * 
 * 
 * then we will simply reversively call the quick sort fun from 0-(pivot-1)
 * and pivot+1  to high
 * 
 */
    import java.io.*;
    import java.util.*;
    
    public class quickSorts {
    public static int pivotIndex(int[] arr, int low, int high, int pivot){
        int i = 0;
        int j = 0;
        while(i<arr.length){
            if(arr[i]<=pivot){
                swap(arr, i, j);
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j-1;
    }
      public static void quickSort(int[] arr, int lo, int hi) {
       if(lo>hi){
           return;
       }
       int pivot = arr[hi];
       int pi = pivotIndex(arr, lo, hi, pivot);
       quickSort(arr, lo, pi-1);
       quickSort(arr,pi+1, hi);

        
      }
    
      public static int partition(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        while (i <= hi) {
          if (arr[i] <= pivot) {
            swap(arr, i, j);
            i++;
            j++;
          } else {
            i++;
          }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
      }
    
      // used for swapping ith and jth elements of array
      public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    
      public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        print(arr);
      }
    
    }
