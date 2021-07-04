
   import java.util.*;

   public class rotateBy90deg {

   public static Scanner scn = new Scanner(System.in);

   public static void takeInput(int[][] arr) {
       for(int i = 0; i < arr.length; i++) {
           for(int j = 0; j < arr[0].length; j++) {
               arr[i][j] = scn.nextInt();
           }
       }
   }

   public static void display(int[][] arr) {
       for(int i = 0; i < arr.length; i++) {
           for(int j = 0; j < arr[0].length; j++) {
               System.out.print(arr[i][j] + " ");
           }
           System.out.println();
       }
   }
   


   public static void rotateMatrix(int[][] arr) {
    //traspose the array
    for(int i = 0; i < arr.length-1; i++) {
        for(int j = i+1; j <arr.length; j++) {
            int temp  = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
    }

    ///resarrangement
    int left = 0;
    int right = arr.length - 1;
    while(left <right){
        for(int row = 0;row<arr.length;row++){
            int temp = arr[row][left];
            arr[row][left] = arr[row][right];
            arr[row][right] = temp;
        }
        left++;
        right--;
    }      
         


   }
   
   public static void main(String[] args) {
       int n = scn.nextInt();
       int[][] arr = new int[n][n];
       takeInput(arr);

       rotateMatrix(arr);
       display(arr);

   }
}
   






   /****************************************************************************************
   *************************************************************************** */

//     import java.util.*;

//     public class rotateBy90deg {

//     public static Scanner scn = new Scanner(System.in);

//     public static void takeInput(int[][] arr) {
//         for(int i = 0; i < arr.length; i++) {
//             for(int j = 0; j < arr[0].length; j++) {
//                 arr[i][j] = scn.nextInt();
//             }
//         }
//     }

//     public static void display(int[][] arr) {
//         for(int i = 0; i < arr.length; i++) {
//             for(int j = 0; j < arr[0].length; j++) {
//                 System.out.print(arr[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
    
//     public static void transposeMatrix(int[][] arr) {
//         for(int r = 0; r < arr.length; r++) {
//             for(int c = 0; c <= r; c++) {
//                 int temp  = arr[r][c];
//                 arr[r][c] = arr[c][r];
//                 arr[c][r] = temp;
//             }
//         }
//     }

//     public static void rotateMatrix(int[][] arr) {
//         // transpose
//         transposeMatrix(arr);
//         // reverse every row
//         for(int r = 0; r < arr.length; r++) {
//             // reverse rth row
//             int left = 0;
//             int right = arr[0].length - 1;

//             while(left < right) {
//                 // swap
//                 int temp = arr[r][left];
//                 arr[r][left] = arr[r][right];
//                 arr[r][right] = temp;

//                 left++;
//                 right--;
//             }
//         }
//     }
    
//     public static void main(String[] args) {
//         int n = scn.nextInt();
//         int[][] arr = new int[n][n];
//         takeInput(arr);

//         rotateMatrix(arr);
//         display(arr);

//     }
// }