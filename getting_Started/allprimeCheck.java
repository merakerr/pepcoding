

import java.util.*;
public class allprimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        for(int i = n1;i<=n2;i++){
            int fact = 0;
            for(int div = 2;div*div<=i;div++){
                if(i%div == 0){
                    fact++;
                    break;
                }
            }
            if(fact == 0){
                System.out.println(i);
            }
        }
    }
}
