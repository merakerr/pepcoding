//leetcode 768
    
/*
We split arr into some number of chunks (i.e., partitions), and individually sort
 each chunk. After concatenating them, the result should equal the sorted array.
Return the largest number of chunks we can make to sort the array.

Input: arr = [5,4,3,2,1]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.

*/

    import java.util.*;

    public class maximumChunkToMakeSorted2 {
    
        // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
        public static int maxChunksToSorted2(int[] arr) {
        int n = arr.length;
        int[] rightMin = new int[n + 1];
        rightMin[n] = Integer.MAX_VALUE;
        int chunks = 0;
        // prepare right min
        for(int i = n - 1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }
        // solve count of using using a leftmax variable
        int leftmax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            leftmax = Math.max(leftmax, arr[i]);

            if(leftmax <= rightMin[i + 1])
                chunks++;
        }
        return chunks;
        }
    
        // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
    
            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
    
            int res = maxChunksToSorted2(arr);
            System.out.println(res);
        }
    }
