import java.io.*;
import java.util.*;

public class printDecreasing {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDecreasings(n);
    }

   public static void printDecreasings(int n) {
        // base case
        if(n == 0) {
            System.out.println();
            return;
        }
    
        // done by myself
        System.out.println(n);
        // faith
        printDecreasings(n - 1);
    }

}