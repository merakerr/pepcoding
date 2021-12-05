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
            return 0;
        }
    
        public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
            int n = Integer.parseInt(read.readLine());
            int heights[] = new int[n];
            for(int i=0;i<n;i++)heights[i] = Integer.parseInt(read.readLine());
    
            System.out.println(largestRectangleArea(heights));
            
        }
    }
    
