//leetcode 56

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all
 overlapping intervals, and return an array of the non-overlapping intervals
  that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

*/
    
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Scanner;
    
    
    public class mergeInterval {
        public static int[][] mergeIntervals(int Intervals[][]){
           Arrays.sort(Intervals,(val1, val2)->Integer.compare(val1[0], val2[0]));

           ArrayList<int[]> list = new ArrayList<>();
           int lsp = Intervals[0][0];  //last interval starting pt
           int lep = Intervals[0][1];  //last interval ending pt

            for(int i = 1; i < Intervals.length; i++){
                int st_pt = Intervals[i][0];
                int end_pt = Intervals[i][1];
                if(lep < st_pt){
                    //new interval is found
                    int[] sublist = {lsp, lep};
                    // lep = end_pt;
                     list.add(sublist);
                     lsp = st_pt;
                     lep = end_pt;
                } else if (lep < end_pt){
                   //partially overlapping
                   lep = end_pt;
                }else{
                    //fully overlapping , nothing to do
                }
            }
            int[] sublist = {lsp, lep};
            list.add(sublist);
            return list.toArray(new int[list.size()][]);

        }
        public static void main(String args[]){
            Scanner scn = new Scanner(System.in);
    
            // Input Format
            int n = scn.nextInt();
            int input[][] = new int[n][2];
    
            for(int i = 0 ; i <  n ; i++){
                int sp = scn.nextInt();
                int ep = scn.nextInt();
    
                input[i][0] = sp;
                input[i][1] = ep;
            }
    
            // Output Format
            int [][]output = mergeIntervals(input);
    
            System.out.print("[");
            for(int arr[] : output){
                System.out.print(Arrays.toString(arr));
            }
            System.out.println("]");
        }
    }
