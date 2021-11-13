/*
1. Write an efficient algorithm that searches for a value in a m x n matrix. This matrix has the following properties:
a). Integers in each row are sorted from left to right.
b). The first integer of each row is greater than the last integer of the previous row.
*/

//we need to find first the possible row, and from that row 
//need to apply binary search

    
    import java.util.*;
    import java.io.*;
    
    public class searchIn2dMatrix {
    
        /*your task is to complete this function which returns true if target exists in the matrix
        else return false*/

        private static int findRowIndex(int[][] matrix, int target){
            int index = -1;
            int low = 0;
            int high = matrix.length - 1;

            while(low <= high){
               int mid = low + (high - low) /2;

               //if value on the row is <= target &&
               //target is less the the last item on that row then set the 
               //row and return
               if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]){
                   index = mid;
                   break;
               }

               else if(target < matrix[mid][0]){
                   //need to search from 0 to mid row only
                  high = mid - 1;
               }
               else{
                   low = mid + 1;
               }
            }


            return index;
        }



        public static int findInRowIndex(int[][] matrix, int target, int row){
            int index = -1;
            int low = 0;
            int high = matrix[0].length - 1;

            while(low <= high){
                int mid = low + (high - low ) / 2;
                if(matrix[row][mid] == target){
                    index = mid;
                    break;
                }
                else if(matrix[row][mid] < target){
                   low = mid + 1;
                }
                else{
                   high = mid - 1;
                }
            }

            return index;
        }

        //code written here 
        public static boolean search(int[][]matrix,int target) {
            int rowIndex = findRowIndex(matrix, target);
            if(rowIndex == -1){
                return false;
            }
            int res = findInRowIndex(matrix, target, rowIndex);
             if(res == -1){
                 return false;
             }
             return true;
        }
    
        public static void main(String[]args) {
            //input work
            Scanner scn = new Scanner(System.in);
            int m = scn.nextInt();
            int n = scn.nextInt();
    
            int[][]matrix = new int[m][n];
    
            for(int i=0; i < m;i++) {
                for(int j=0; j < n;j++) {
                    matrix[i][j] = scn.nextInt();
                }
            }
    
            int target = scn.nextInt();
    
            boolean isFound = search(matrix,target);
            System.out.println(isFound);
    
        }
    }