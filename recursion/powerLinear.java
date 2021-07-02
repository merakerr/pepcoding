
    //x raised to the power n
    //2 raised 5 --->>  32
    

    import java.io.*;
    import java.util.*;
    
    public class powerLinear {
    
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int n = sc.nextInt();
            int val = powerL(x,n);
            System.out.println(val);
        }
    
        public static int powerL(int x, int n){
            if(n ==0){
                return 1;
            }

            return x * powerL(x,n-1);
        }
    
    }
