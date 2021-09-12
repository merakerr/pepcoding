//leetcode 754

/*
You are standing at position 0 on an infinite number line. There is a destination at position target.

You can make some number of moves numMoves so that:

On each move, you can either go left or right.
During the ith move (starting from i == 1 to i == numMoves), you take i steps in the chosen direction.
Given the integer target, return the minimum number of moves required (i.e., the minimum numMoves) to reach the destination.

 

Example 1:

Input: target = 2
Output: 3
Explanation:
On the 1st move, we step from 0 to 1 (1 step).
On the 2nd move, we step from 1 to -1 (2 steps).
On the 3rd move, we step from -1 to 2 (3 steps).
*/
import java.util.*;
public class reachNumber {
    public static  int reachNumbers(int target) {
        target = Math.abs(target);

        int jump = 0;
        int s = 0;

        while(s < target) {
            jump++;
            s += jump;
        }

        if(s == target) {
            return jump;
        } else if((s - target) % 2 == 0) {
            return jump;
        } else if((s + jump + 1 - target) % 2 == 0) {
            return jump + 1;
        } else {
            return jump + 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = reachNumbers(n);
        System.out.println(res);
    }
}
