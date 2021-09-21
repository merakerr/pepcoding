/*
leetcode 986

You are given two lists of closed intervals, firstList and secondList, where 
firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list
 of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
A closed interval [a, b] (with a <= b) denotes the set of real numbers x with
 a <= x <= b.
The intersection of two closed intervals is a set of real numbers that are
 either empty or represented as a closed interval. For example, the
intersection of [1, 3] and [2, 4] is [2, 3].

Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList =
 [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

*/


    
    import java.util.*;
    public class IntervalListIntersection {
        public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            ArrayList<int[]> list = new ArrayList<>();
            int i = 0;
            int j = 0;
            while(i < firstList.length && j < secondList.length) {
                int st = Math.max(firstList[i][0], secondList[j][0]);
                int end = Math.min(firstList[i][1], secondList[j][1]);
                if(st <= end) {
                    // it is valid interval
                    int[] sublist = {st, end};
                    list.add(sublist);
                }
                if(firstList[i][1] < secondList[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
            return list.toArray(new int[list.size()][]);
        }
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Input format
        int n = scn.nextInt();
        int list1[][] = new int[n][2];
        for (int i = 0 ; i < n ; i++) {
          list1[i][0] = scn.nextInt();
          list1[i][1] = scn.nextInt();
        }
    
        int m = scn.nextInt();
        int list2[][] = new int[m][2];
        for (int i = 0 ; i < m ; i++) {
          list2[i][0] = scn.nextInt();
          list2[i][1] = scn.nextInt();
        }
    
        // output
        int ans[][] = intervalIntersection(list1, list2);
        System.out.print("[");
        for (int interval[] : ans) {
          System.out.print(Arrays.toString(interval));
        }
        System.out.println("]");
      }
    }
    
