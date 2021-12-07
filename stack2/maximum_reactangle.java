/*

leetcode 85
1. Given a rows x cols binary matrix filled with 0's and 1's.
2. Find the largest rectangle containing only 1's and return its area.
*/
    
    import java.io.*;
    import java.util.*;
    
    public class maximum_reactangle {
    

        //code written here 
        public static int maximalRectangle(int[][] matrix) {           
            int[] ht = new int[matrix[0].length];
            int res = 0;
            for(int i = 0; i < matrix.length; i++) {
                
                for(int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == 0) {
                        ht[j] = 0;
                    } else {
                        ht[j] += 1;
                    }
                }
                res = Math.max(res, largestRectangleArea(ht));
            }
            return res;
        }
      

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
    
            int row = Integer.parseInt(read.readLine());
            int col = Integer.parseInt(read.readLine());
            
            int bmat[][] = new int[row][col];
    
            for(int i=0;i<row;i++){
                String s = read.readLine();
                for(int j=0;j<col;j++){
                    bmat[i][j] = s.charAt(j)-'0';
                }
            }
    
            int result = maximalRectangle(bmat);
            System.out.println(result);
            
        }
    }
    
