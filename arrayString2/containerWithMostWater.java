
//leetcode 11
/*
Given n non-negative integers a1, a2, ..., an , where each represents a point
 at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
  of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
 the x-axis forms a container, such that the container contains the most water.

 Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.
*/


import java.util.*;

public class containerWithMostWater {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int mostWater(int[] height) {
        int maxWater = 0;
        int i = 0;
        int j = height.length - 1;

        while(i < j){
            int l = j-i;
            int h = Math.min(height[i], height[j]);
            int water = l*h;
            maxWater = Math.max(maxWater, water);

            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
      return maxWater;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        // Write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }

        int res = mostWater(heights);
        System.out.println(res);
    }
}