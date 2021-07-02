
    
    import java.io.*;
    import java.util.*;
    
    public class powerLogarithmic {
    
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int n = sc.nextInt();
            int val = powerL(x,n);
            System.out.println(val);
        }
    
        public static int powerL(int x, int n){
           if(n==0){
               return 1;
           } 
           int xpower = powerL(x, n/2);
           int xn = xpower*xpower;

           if(n%2 == 1){
               xn = xn*x;
           }
           return xn;
        }
    
    }
