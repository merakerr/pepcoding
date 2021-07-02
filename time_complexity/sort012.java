import java.util.*;
public class sort012 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];

        for(int i = 0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        sortTheArray(arr);
        displayArray(arr);
    }
    public static void sortTheArray(int[] arr){
                /*
        it means that if arr[i] == 0, then swap, and increase i,j
                    if arr[i] == 1, then increment i only
                    else if arr[i] == 2,swap i, k then decrease k from last
        */
        int i = 0;
        int j = 0;
        int k = arr.length-1;
        while(i<=k){
            if(arr[i]==0){
                swap(arr, i, j);
                i++;
                j++;
            }
            else if(arr[i]==1){
                i++;
            }
            else{
                swap(arr, i, k);
                k--;
            }
        }



      }
      public static void displayArray(int []arr){
          System.out.println("#############");
          for(int ar:arr){
              System.out.println(ar);
          }
      }
      
      public static void swap(int []arr, int x, int y){
          int temp = arr[x];
          arr[x] = arr[y];
          arr[y] = temp;
      }
}
