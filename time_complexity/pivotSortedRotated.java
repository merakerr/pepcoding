
    
    import java.io.*;
    import java.util.*;
    
    public class pivotSortedRotated {
    
        public static int pivotInSortedRotated(int[] arr, int lo, int hi) {
            if(lo == hi) {
                return arr[lo];
            }
            int mid = lo + (hi - lo) / 2;
            int res = 0;
            if(arr[mid] < arr[hi]) {
                // left side -> including mid
                res = pivotInSortedRotated(arr, lo, mid);
            } else {
                // right side
                res = pivotInSortedRotated(arr, mid + 1, hi);
            }
            return res;
        }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        int hi = arr.length-1;
        int pivot =pivotInSortedRotated(arr, 0, hi);
        System.out.println(pivot);
      }
    
    }

  
    /*
    //non recursive
     public static int pivotInSortedRotated(int[] arr) {
           int low = 0;
           int high = arr.length-1;

           while(low < high){

             int mid = low+high/2;
             if(arr[mid]<arr[high]){
                 high = mid;
             }
            else{
                low = mid+1;
            }
           }
           return arr[high];
        }
    
    */