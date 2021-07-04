
import java.io.*;
import java.util.*;

public class firstAndLastIndex {
public static void fili(int[] arr, int data){
   int fi = -1;
    int left = 0;
    int right = arr.length-1;
    while(left<=right){
        int mid = (left+right)/2;
        if(arr[mid] == data){
           fi = mid;
           right = mid-1;
        }
        else if(arr[mid]<data){
           left = mid+1;
        }
        else if(arr[mid]>data){
            right = mid-1;
        }
    }

    // 
     int li = -1;
     left = 0;
   right = arr.length-1;
    while(left<=right){
        int mid = (left+right)/2;
        if(arr[mid] == data){
           li = mid;
           left  = mid+1;
        }
        else if(arr[mid]<data){
           left = mid+1;
        }
        else if(arr[mid]>data){
            right = mid-1;
        }
    }
    
    System.out.println(fi);
    System.out.println(li);
}
public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int []arr = new int[n];

    for(int i = 0;i<n;i++){
        arr[i] = sc.nextInt();
    }
    int data = sc.nextInt();
    fili(arr, data);
 }

}

