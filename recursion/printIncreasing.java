
import java.util.*;

public class printIncreasing  {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printIncrease(n);
    }

   public static void printIncrease(int n) {
        // base case
        if(n == 0) {
           // System.out.println();
            return;
        }
    
        // done by myself
       
        // faith
        printIncrease(n - 1);
        System.out.println(n);
    }

}
