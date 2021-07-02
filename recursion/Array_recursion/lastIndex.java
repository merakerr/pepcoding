
    

    
    import java.io.*;
    import java.util.*;
    
    public class lastIndex {
    
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int []arr = new int[n];
            for(int i = 0;i<arr.length;i++){
                arr[i] = sc.nextInt();
            }
            int x = sc.nextInt();
            int idx = arr.length-1;
            int retVal =  last(arr, idx, x);
            System.out.println(retVal);
        }
    
        public static int  last(int[] arr, int idx, int x){

            if(idx < 0){
                return -1;
            }
           if(arr[idx]==x){
               return idx;
           }
           int ret =  last(arr, idx-1, x);
           return ret;
        }
    
    }

/*
sir method
****************
last(arr,0,x);
--------------?>>
public static int  last(int[] arr, int idx, int x){
           if(idx==arr.length){
               return -1;
           }

           int rindex = last(arr, idx+1, x);
           if(rindex == -1){
               if(arr[idx]==x){
                   rindex = idx;
               }
           }
           return rindex;
            
        }

*/
    

