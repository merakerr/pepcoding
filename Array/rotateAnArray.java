

///
import java.io.*;
import java.util.*;

public class rotateAnArray {
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

   public static void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        // k management
        k = k % n;
        if(k < 0) {
            k += n;
        }

        reverse(arr, 0, n - k - 1); // first half reversal
        reverse(arr, n - k, n - 1); // second half reversal
        reverse(arr, 0, n - 1); // complete reversal
    }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}