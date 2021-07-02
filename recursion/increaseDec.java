
import java.util.*;

public class increaseDec {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printIncreaseDecrease(n);
    }

   public static void printIncreaseDecrease(int n) {
        // base case
        if(n == 0) {
           // System.out.println();
            return;
        }
    
       
        System.out.println(n);
        printIncreaseDecrease(n - 1);
        System.out.println(n);
        
        

    }

}


