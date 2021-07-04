import java.io.*;
import java.util.*;

public class arrayDemo{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int arr[][] = new int[n][m];

    for(int i = 0 ;i < n;i++){
         for(int j = 0;j<m;j++){
            arr[i][j] = sc.nextInt();
         }
    }

    //to print the data
    for(int i = 0 ;i < n;i++){
        for(int j = 0;j<m;j++){
           System.out.print(arr[i][j]+" ");
        }
        System.out.println();  
   }
 }

}