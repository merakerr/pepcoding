/*
1. Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
2. An integer a is closer to x than an integer b if:
        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b


Sample Input
6
10 20 30 40 50 60
3 
45
Sample Output
30 40 50
*/


    
    import java.util.*;
    import java.io.*;
    
    public class findKClosestElement {
    
        /*find 'k' closest element to 'x' and return answer list*/
        /*elements in answer list should be in ascending order*/

        public static class pair implements Comparable<pair> {
            int val;
            int dist;
    
            public pair(int val, int dist) {
                this.val = val;
                this.dist = dist;
            }
    


            //if distance is same for two data then , pq will be based upon 
            //val else it will be based upon distace
            public int compareTo(pair o) {
                if(this.dist == o.dist) {
                    return this.val - o.val;
                } else {
                    return this.dist - o.dist;
                }
            }
        }

        //code written here 
        public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
            ArrayList<Integer> res = new ArrayList<>();
            PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0; i < arr.length; i++) {
                if(i < k) {
                    pq.add(new pair(arr[i], Math.abs(arr[i] - x)));
                } else {
                    if(pq.peek().dist > Math.abs(arr[i] - x)) {
                        pq.remove();
                        pq.add(new pair(arr[i], Math.abs(x - arr[i])));
                    }
                }
            }
    
            while(pq.size() > 0) {
                res.add(pq.remove().val);
            }
            Collections.sort(res);
            return res;
        
        }
    
        public static void main(String[]args) {
    
            //input work
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
    
            int[]arr = new int[n];
    
            for(int i=0; i < n;i++) {
                arr[i] = scn.nextInt();
            }
    
            int k = scn.nextInt();
            int x = scn.nextInt();
    
            ArrayList<Integer>ans = findClosest(arr,k,x);
    
            for(int val : ans) {
                System.out.print(val + " ");
            }
    
        }
    }
