
    
    import java.util.*;

    public class reverseOfArr {
       public static void reverse(int[] arr, int index){
         if(index == arr.length){
             return;
         }
         
         reverse(arr, index+1);
         System.out.println(arr[index]);
       }
        public static void main(String []args){
            int []arr = {10,20,30,40,50};
            reverse(arr, 0);
    
        }
    }
    
