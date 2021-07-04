
//inverse index----->>
import java.util.*;
   
public class inverseOfNumber {
   
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
   int i = 1;
   int ans = 0;
   while(n!=0){
       int r = n%10;
       n = n/10;
       ans = ans+i*(int)Math.pow(10, r-1);
       i++;
   }
   System.out.println(ans);
   }
}
