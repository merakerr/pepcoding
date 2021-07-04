
    

    import java.util.*;
    public class saddledPoint {
    
     public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [][]arr = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
       //
       for(int i = 0;i<n;i++){
           int min = arr[i][0];
           int colno = 0;
           for(int col = 0;col<n;col++){
               if(arr[i][col]<min){
                   min = arr[i][col];
                   colno = col;
               }
           }
           boolean vc = true;
           for(int row = 0;row<n;row++){
               if(arr[row][colno]>min){
                   vc = false;
                   break;
               }
           }
           if(vc == true){
               System.out.println(min);
               return;
           }
    
       } 
       System.out.println("Invalid input"); 
     } 
}
