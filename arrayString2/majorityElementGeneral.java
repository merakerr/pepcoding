 /*
1. Given an array of size 'N' and an element K.
2. Task is to find all elements that appears more than N/K times in array.
3. Return these elements in an ArrayList in sorted order.

input;
8
3 1 2 2 1 2 3 3
4

output:
[2,3]
 */
    
    import java.util.*;

    public class majorityElementGeneral {
        
        //~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
        public static ArrayList<Integer> majorityElement(int[] arr, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = arr.length;

            for(int i = 0; i < n; i++){
                if(map.containsKey(arr[i]) == true){
                    map.put(arr[i], map.get(arr[i])+1);
                }else{
                    map.put(arr[i], 1);
                }
            }

            ArrayList<Integer> res = new ArrayList<>();
            //travel in hashmap and fill the res
            for(int key : map.keySet()){
                if(map.get(key) > n/k){
                    res.add(key);
                }
            }
            
          //sort the result
          Collections.sort(res);
          return res;

        }
        
        //~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            int k = scn.nextInt();
            ArrayList<Integer> res = majorityElement(arr, k);
            System.out.println(res);
        }
    }
