import java.io.*;
import java.util.*;

public class brokenEconomy{
public static void brokenEco(int[] arr, int data){
    int ceil = -1;
    int floor = -1;
    int left = 0;
    int right = arr.length-1;
    while(left<=right){
        int mid = (left+right)/2;
        if(arr[mid] == data){
            System.out.println(arr[mid]);
           ceil = data;
           floor = data;
            break;
        }
        else if(arr[mid]<data){
           floor = arr[mid];
           left = mid+1;
        }
        else if(arr[mid]>data){
            right = mid-1;
            ceil = arr[mid];
        }
    }
    
    System.out.println(ceil);
    System.out.println(floor);
}
public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int []arr = new int[n];

    for(int i = 0;i<n;i++){
        arr[i] = sc.nextInt();
    }
    int data = sc.nextInt();
    brokenEco(arr, data);
 }

}