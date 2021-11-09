
/*
1. You are given an array(arr) of integers and a number K.
2. You have to find the count of distinct numbers in all windows of size k.

Sample Input
7
1 2 1 3 4 2 3        
4
Sample Output
3 4 4 3 
*/


    
    import java.util.*;

    public class countDistinctElementOFsizeK {
    
        public static ArrayList<Integer> solution(int[] arr, int k) {
            
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = -1;

         while(i < k - 1){  //till k-1 element
             map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
             i++;
         }

         i--;   //decreasing last increment value
         
         
         while(i < arr.length -1){   //after k element we add on res
             i++;
             map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
             res.add(map.size());

             j++;
             int f = map.get(arr[j]);
             if(f == 1){
                 map.remove(arr[j]);
             }else{
                 map.put(arr[j], f - 1);
             }
         }
            return res;
        }
        
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int[] arr = new int[scn.nextInt()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scn.nextInt();
            }
            int k = scn.nextInt();
            ArrayList<Integer> ans = solution(arr,k);
            for(int a : ans){
                System.out.print(a + " ");
            }
        }
    
    
    }
    
