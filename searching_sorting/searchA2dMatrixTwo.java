/*
Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
a). Integers in each row are sorted in ascending from left to right.
b). Integers in each column are sorted in ascending from top to bottom.

Sample Input
5 5
1 4 7 11 15
2 5 8 12 20
4 6 9 16 22
10 13 14 17 24
18 21 23 26 30
12
Sample Output
true
*/


    import java.util.*;
    import java.io.*;
    
    public class searchA2dMatrixTwo {
    
        //code written here 
        public static boolean search(int[][]matrix,int target) {
            int row = 0;
            int col = matrix[0].length - 1;

            while(row < matrix.length && col >= 0){
                if(matrix[row][col] == target){
                    return true;     
                }

                else if(matrix[row][col] < target){
                  //discard current row
                  row++;
                }else{
                  //discard current colum
                  col--;
                }
            }
            return false;
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
