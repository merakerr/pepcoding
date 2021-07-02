
    /*
3 3
0 0 0
1 0 1
0 0 0
*/

import java.util.*;

public class floodFill {

    public static int[] rdir = {-1,0,1,0};
    //  0  1 2  3
   public static int[] cdir = {0,-1, 0, 1};
   ////  0 1 2  3
   public static char[] charDir ={'t', 'l', 'd', 'r'};
        ////  0    1    2     3    public static void main(String[] args){
      
                                    
public static void main(String[] args){
//take input 
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int m = sc.nextInt();

int[][] arr = new int[n][m];
for(int i = 0;i<arr.length;i++){
    for(int j = 0;j<arr[0].length;j++){
        arr[i][j] = sc.nextInt();
    }
}
 floodFills(arr, 0, 0, "");
}          
public static void floodFills(int[][] arr, int sr, int sc, String asf){
    //  public static int []rdir = {-1,0,1,0};
    //                         //  0  1 2  3
    // public static int []cdir = {0,-1, 0, 1};
    //                       ////  0 1 2  3
    // public static char[] charDir = {"t", "l", "d", "r"};
    //                             ////  0    1    2     3
    // 0 0 0
    // 1 0 1
    // 0 0 0
    
    
    //base case 
    if(sr == arr.length-1 && sc== arr[0].length-1){
        System.out.println(asf);
        return;
    }
    
     arr[sr][sc] = 1;
        
    
    for(int d = 0;d<rdir.length;d++){
        int row = sr+rdir[d];  //0+-1 = -1;
        int col = sc+cdir[d];   //0+0 == 0;
       // -1,0 and charDir === t
       char dir = charDir[d];
       
       if(row>=0 && row<arr.length && col>=0 && col<arr[0].length && arr[row][col] != 1){
           floodFills(arr, row, col, asf+dir);
       }
    }
     arr[sr][sc] = 0;
}

    
}

