
    
//The State Of Wakanda - 2
import java.util.*;

public class stateOfWakanda2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [][]arr = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
            //solution
            for(int diag = 0;diag < n;diag++){
                for(int i=0,j=diag;j<n;i++,j++){
                    System.out.println(arr[i][j]);
                }
            }
        
    }
}
