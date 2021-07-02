
    
    import java.io.*;
    import java.util.*;
    
    public class firstIndex {
    
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int []arr = new int[n];
            for(int i = 0;i<arr.length;i++){
                arr[i] = sc.nextInt();
            }
            int x = sc.nextInt();
            int retVal = firstIndexs(arr, 0, x);
            System.out.println(retVal);
        }
    
        public static int firstIndexs(int[] arr, int idx, int x){

            if(idx == arr.length){
                return -1;
            }
           if(arr[idx]==x){
               return idx;
           }
           int ret = firstIndexs(arr, idx+1, x);
           return ret;
        }
    
    }


    
