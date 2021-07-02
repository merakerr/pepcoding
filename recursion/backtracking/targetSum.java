


    import java.io.*;
    import java.util.*;
    
    public class targetSum {
    
        public static void main(String[] args) throws Exception {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int []arr = new int[n];
          for(int i = 0;i<n;i++){
              arr[i]=sc.nextInt();
    
          }
          int target = sc.nextInt();
          printTargetSumSubset(arr, 0, "",0, target);
          
        }
    
        // asf asnwer so far
        // ssf sum so far
        // tar is target
         public static void printTargetSumSubset(int[] arr, int indx, String asf,int ssf, int targ) {
             if(ssf>targ){
                return;
            }
            if(indx == arr.length){
                if(ssf == targ){
                    System.out.println(asf + ".");
                }
                return;
            }
            //want to come
            printTargetSumSubset(arr, indx+1, asf+arr[indx]+", ", ssf+arr[indx], targ);
            //does not want to come
            printTargetSumSubset(arr, indx+1, asf, ssf, targ);
         }
        }
