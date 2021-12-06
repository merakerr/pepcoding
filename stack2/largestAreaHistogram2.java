/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

Challenge. Could u solve it in one iteration.
Note. This question is same as Largest Area Histogram just the constrains are higher.
*/
    
    import java.io.*;
    import java.util.*;
    
    public class largestAreaHistogram2 {
        public static int largestRectangleArea(int[] heights) {
            int[] nsr = nsr_r(heights);
            int[] nsl = nsl_l(heights);
            int res = 0;
            for(int i = 0; i < heights.length; i++){
                int weight = nsr[i] - nsl[i] - 1;
                int area = weight * heights[i];
                res = Math.max(res, area);
            }
            return res;
        }

        public static int[] nsr_r(int[] arr){
          Stack<Integer> st = new Stack<>();
          int[] res = new int[arr.length];

          for(int i = 0; i < arr.length; i++){
              while(st.size() > 0 && arr[st.peek()] > arr[i]){
                  res[st.pop()] = i;
              }
              st.push(i);
          }

          while(st.size() > 0){
              res[st.pop()] = arr.length;
          }
          return res;
        }
        public static int[] nsl_l(int[] arr){
           Stack<Integer> st = new Stack<>();
           int[] res = new int[arr.length];
           for(int i = arr.length -1; i >= 0 ; i--){
               while(st.size() > 0 && arr[st.peek()] > arr[i]){
                   res[st.pop()] = i;
               }
               st.push(i);
           }
           while(st.size() > 0){
               res[st.pop()] = -1;
           }
           return res;
        }
    
        public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
            int n = Integer.parseInt(read.readLine());
            int heights[] = new int[n];
            for(int i=0;i<n;i++)heights[i] = Integer.parseInt(read.readLine());
    
            System.out.println(largestRectangleArea(heights));
            
        }
    }
    
