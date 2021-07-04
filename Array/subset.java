import java.io.*;
import java.util.*;

public class subset{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int []arr = new int[n];

    for(int i = 0;i<n;i++){
        arr[i] = sc.nextInt();
    }
    int tss = (int)Math.pow(2, n);
    for(int i = 0;i<tss;i++){
        int bin = decToBin(i);
        int div = (int)Math.pow(10, n-1);
        for(int j = 0;j<n;j++){
            int q = bin/div;
            int r = bin%div;
            bin = r;
            if(q == 0){
              System.out.print("-\t");
            }else{
                System.out.print(arr[j]+"\t");
            }
            div/=10;
        }
        System.out.println();
    }
 }


 //
 public static int decToBin(int n){
  int ans = 0;
  int power = 1;
  while(n!=0){
      int r = n%2;
      n/=2;
      ans+=r*power;
      power = power*10;
  }
  return ans;
 }
}