/*
we are given the list of numbers 
we need to find the k largest elements

suppose  = 4,
we need to find 4 largest element present in the array

arr = 10,20,30,40,50,60
k = 4

k largest = {30, 40, 50, 60}

space allowed = O(k)
time complexity = O(nlogk)



*/
    
    import java.io.*;
    import java.util.*;
    
    public class kLargestElement {
    public static void printKLargest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //add k elements in priority queue
        for(int i = 0; i < k; i++){
            pq.add(arr[i]);
        }

        //process remaining items
        for(int i = k; i < arr.length; i++){
            if(arr[i] > pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }

        //print k elements from priority queue

       for(int i = 0; i < k; i++){
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
          printKLargest(arr, k);
        }
    
    }
