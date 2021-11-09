/*
1. You are given an array(arr) of integers and a number K.
2. You have to find if the given array can be divided into pairs such that the sum of every pair is divisible by k.

Sample Input
4
9 7 5 3
6
Sample Output
true
*/

    import java.util.*;

    public class checkIfArrayCanBeDivided {
        
        public static void solution(int[] arr, int k){

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < arr.length; i++) {
                int rem = arr[i] % k;
                int fq = map.getOrDefault(rem, 0);
                map.put(rem, fq + 1);
            }
    
            boolean res = true;
            for(int fx : map.keySet()) {
                if(fx == 0 || (k % 2 == 0 && fx == k / 2)) {
                    if(map.get(fx) % 2 != 0) {
                        res = false;
                        break;
                    }
                } else {
                    if(map.containsKey(k - fx) == false || map.get(fx) != map.get(k - fx)) {
                        res = false;
                        break;
                    }
                }
            }
            System.out.println(res);
    
        }
    
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n; i++){
                arr[i] = scn.nextInt();
            }
            int k = scn.nextInt();
            solution(arr,k);
        }
    
    }
    
