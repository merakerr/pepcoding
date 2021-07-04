
    
    import java.io.*;
    import java.util.*;
    
    public class subArray {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }


        //
        printSubArray(arr);
     }
    public static void printSubArray(int []arr){
        
        for(int sp = 0;sp<arr.length;sp++){
            for(int ep = sp;ep<arr.length;ep++){
                for(int i = sp;i<=ep;i++){
                    System.out.print(arr[i]+"\t");

                }
                System.out.println();
            }
        }
    }
    }
