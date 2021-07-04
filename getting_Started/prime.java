import java.util.*;
  
  public class prime{
  
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();

      for(int i = 1;i<=t;i++){
        int n = sc.nextInt();
        int fact = 0;
        for(int div = 2; div*div<=n;div++){
            if(n%div == 0){
               fact++;
               break;
            }
        }
        if(fact == 0){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }
      }
    
      
  
   }
  }