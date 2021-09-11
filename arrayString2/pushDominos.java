//leetcode 838

/*
There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.



Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."

*/

import java.util.*;

public class pushDominos {

  // ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~
  public static String pushDominoes(String dominoes) {
    int l = dominoes.length();
        char[] arr = new char[l + 2];
        arr[0] = 'L';
        arr[l + 1] = 'R';
        for(int i = 1; i <= l; i++) {
            arr[i] = dominoes.charAt(i - 1);
        }

        int i = 0;
        int j = 1;
        while(j < arr.length) {
            while(arr[j] == '.')
                j++;

            if(j - i > 1) {
                solveConfig(arr, i, j);
            }
            i = j;
            j++;
        }

        String res = "";
        for(int k = 1; k <= l; k++) {
            res += arr[k];
        }
        return res;
  }

  private static  void solveConfig(char[] arr, int i, int j) {
    if(arr[i] == 'L' && arr[j] == 'L') {
        for(int k = i + 1; k < j; k++)
            arr[k] = 'L';

    } else if(arr[i] == 'R' && arr[j] == 'R') {
        for(int k = i + 1; k < j; k++)
            arr[k] = 'R';
            
    } else if(arr[i] == 'L' && arr[j] == 'R') {
        // do nothing
    } else {
        // arr[i] == 'R' && arr[j] == 'L'
        while(i < j) {
            arr[i] = 'R';
            arr[j] = 'L';
            i++;
            j--;
        }
    }
}

  // ~~~~~~~~~~~Input Management~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    String res = pushDominoes(str);
    System.out.println(res);
  }
}

