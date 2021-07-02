import java.util.*;

public class displayArr {
   public static void display(int[] arr, int index){
     if(index == arr.length){
         return;
     }
     System.out.println(arr[index]);
     display(arr, index+1);
   }
    public static void main(String []args){
        int []arr = {10,20,30,40,50};
        display(arr, 0);

    }
}


/*

//
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int []arr = new int[n];
    for(int i = 0;i<arr.length;i++){
        arr[i] = sc.nextInt();
    }
    displayArr(arr, 0);
    
  }

  public static void displayArr(int[] arr, int idx) {
        if(idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr, idx+1);
  }

}

*/