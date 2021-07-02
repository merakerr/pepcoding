
    
    import java.util.*;
    public class towerOfHanoi {
    
        public static void toh(int n, int src, int dest, int helper) {
            if(n == 0){
                return;
            }
            toh(n-1, src, helper, dest);
            System.out.println(n+"["+src+" -> "+dest+"]");
            toh(n-1, helper, dest,src);
        }
        
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            toh(n, A,B,C); 
    
        }
    }
