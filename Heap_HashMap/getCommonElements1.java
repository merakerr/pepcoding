/*
statements:
You are given two arrays.. you need to find the common element present in 
both the array

arr-1 = 1 1 2 2 3 4 3 5
arr-2 = 1 1 1 2 3 3 4 6 7

here
 1 is present in both
 2 is present in both
 3 is present in both
 4 is present in both

Note:- Order of the answer -->> acc to second array
*/
    
    import java.io.*;
    import java.util.*;
    
    public class getCommonElements1 {
    

        public static void printCommonElement1(int[] arr1, int[] arr2){
            HashMap<Integer, Integer> map = new HashMap<>();

            //find out the presence of elements in arr1
            for(int key : arr1){
                map.put(key, 1);   //just for the sake of presence, count doesnt matter

                // if(map.containsKey(key) == true){
                //     map.put(key, map.get(key)+1);
                // }
            }

            //travel in arr2 to find out similar items in arr1 or not
          for(int key : arr2){
              if(map.containsKey(key) == true){
                  System.out.println(key);
                  map.remove(key);
              }
          }

        }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i<n1;i++){
             arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i<n2;i++){
             arr2[i] = sc.nextInt();
        }

        printCommonElement1(arr1,arr2);
     }
    
    }
