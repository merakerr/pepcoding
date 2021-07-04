
    

import java.io.*;
import java.util.*;

public class subsetOfArray {

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int tss = (int)Math.pow(2, n);
        for(int i = 0;i<tss;i++){
            int bin = decTBin(i);
            int div = (int)Math.pow(10, n-1);
            for(int j = 0;j<n;j++){
                int q = bin/div;
                int r = bin%div;
                if(q == 0){
                    System.out.print("-\t");
                }else{
                    System.out.print(arr[j]+"\t");
                }
                bin = r;
                div/=10;

            }
            System.out.println();
        }
 }

}
