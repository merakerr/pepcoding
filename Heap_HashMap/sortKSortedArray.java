/*
arr = 30 , 10,  40, 20, 50, 70 , 80, 60, 90
k = 3

We can see every element is reallocated with +- k position from its actual position

*/
    
    import java.io.*;
    import java.util.*;
    
    public class sortKSortedArray {
    

        ///code written here ****************************

         public static void printKSorted(int[] arr, int k){

            PriorityQueue<Integer> pq = new PriorityQueue<>();
             //1 add k elements
             for(int i = 0; i < k; i++){
                 pq.add(arr[i]);
                
             }

             //manage remaining elements
             for(int i = k; i < arr.length;i++){
                 //add items
                 pq.add(arr[i]);
                 //remove
                 System.out.println(pq.remove());
             }
             while(pq.size() > 0){
                 System.out.println(pq.remove());
             }
         }

       public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(br.readLine());
          int[] arr = new int[n];
    
          for (int i = 0; i < n; i++) {
             arr[i] = Integer.parseInt(br.readLine());
          }
    
          int k = Integer.parseInt(br.readLine());
          printKSorted(arr, k);
       }
    
    }
