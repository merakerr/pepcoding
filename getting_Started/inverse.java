
    

    import java.io.*;
import java.util.*;

public class inverse {
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static int[] inverseArray(int[] arr){
    int newArr[] = new int[arr.length];
    for(int i = 0;i<arr.length;i++){
        int pos = arr[i];
        newArr[pos] = i;
    }
    return newArr;
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] inv = inverseArray(a);
    display(inv);
 }

}
