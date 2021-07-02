
    
    import java.io.*;
    import java.util.*;
    
    public class factorial {
    
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int val = factorials(n);
            System.out.println(val);

        }
    
        public static int factorials(int n){
          if(n==0){
              return 1;
          }
          return n*factorials(n-1);

        }
    
    }
