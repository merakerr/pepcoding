/*
1, 9, 2, 20, 10, 3, 11, 22, 4, 5, 21

consecutive sequences are:-
-------------------------
1-2-3-4-5   -->>5
9-10-11    --->3
20-21-22   --->3

longest consecutive sequence = 1-2-3-4-5

steps
hashmap<integer,Boolean> map
values    intial        if found prev
1         true        true   --> 0 is not present
9         true        true   --> 8 is not present
2         true        false  --> 1 is present
20        true        true   --> 19 is not present
10        true        false  --> 9 is present
3         true        false  --> 2 is present
11        true        false  --> 10 is present
22        true        false  --> 21 is present
4         true        false  --> 3 is present
5         true        false  --> 4 is present
21        true        true   --> 20 is not present

here we get the starting point of the values
1,9, and 20

*/
    
    import java.io.*;
    import java.util.*;
    
    public class longestConsecutiveSequence {
       public static void printLongestConsecutiveSequence(int[] arr){
          //make a hashmap of presence
          HashMap<Integer, Boolean> map = new HashMap<>();
          for(int key : arr){
              map.put(key, true);
          }

          //make starting point
          for(int key : arr){
               if(map.containsKey(key-1) == true){
                   map.put(key, false);
               }
          }

          //get length and starting point of sequence
          int maxLength = 0;
          int starting = 0;

          for(int key : map.keySet()){
              if(map.get(key) == true){
                  //key is starting point
                  int len = 1;
                  int st = key;

                  while(map.containsKey(key+1) == true){
                      len++;
                      key++;
                  }

                  if(maxLength < len){
                      maxLength = len;
                      starting = st;
                  }
              }
          }
          //print the result

          for(int i = 0; i < maxLength; i++){
              System.out.println(starting);
              starting++;
          }
       }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        printLongestConsecutiveSequence(arr);
     }
    
    }
