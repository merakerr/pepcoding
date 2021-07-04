import java.util.Scanner;

public class digitOfNumber{

    public static int countDigit(int num){
        int val = num;
        int c = 0;
        while(val != 0){
            c++;
            val = val/10;
        }
        return c;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = countDigit(n);
        int div = (int)Math.pow(10, c-1);
        while(div>0){
            int q  = n/div;
            int r = n%div;
            System.out.println(q);
            n = r;
            div = div/10;

        }
    }
}