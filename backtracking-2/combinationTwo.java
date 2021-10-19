/*
1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain 
                   empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without 
                   changing signature. The judge can't force you but intends you to teach a concept.
*/

    import java.io.*;
    import java.util.*;
    
    public class combinationTwo {
    
        public static void combinations(int[] boxes, int ci, int ti, int lb) {
            if (ci > ti) {
                for (int i = 0; i < boxes.length; i++) {
                    if (boxes[i] == 0) {
                        System.out.print("-");
                    } else {
                        System.out.print("i");
                    }
                }
                System.out.println();
                return;
            }
    
            for (int b = lb + 1; b < boxes.length; b++) {
                boxes[b] = ci;
                combinations(boxes, ci + 1, ti, b);
                boxes[b] = 0;
            }
        }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(new int[nboxes], 1, ritems, -1);
      }
    
    }