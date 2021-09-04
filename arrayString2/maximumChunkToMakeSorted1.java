//leetcode 769.

/*
You are given an integer array arr of length n that represents a
 permutation of the integers in the range [0, n - 1].
 We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them,
 the result should equal the sorted array.
Return the largest number of chunks we can make to sort the array

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in 
[3, 4, 0, 1, 2], which isn't sorted.
*/
    
    import java.util.*;

    public class maximumChunkToMakeSorted1 {
    
        // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
        public static int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if(max == i)
                chunks++;
        }
        return chunks;  
        }
    
        // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
    
            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
    
            int res = maxChunksToSorted(arr);
            System.out.println(res);
        }
    }
