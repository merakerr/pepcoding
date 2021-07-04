
/*

int n1 = 0;
int n2 = 0;
 System.out.println(n1);
  System.out.println(n2);
  for(int i = 2;i<n;i++){
      int n3 = n1+n2;
         System.out.println(n3);
          n1 = n2;
          n2 = n3;
  }

*/






import java.util.*;
  
public class fibonacci {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int n1 = 0;
    int n2 = 1;
      for(int i = 1;i<=n;i++){
          System.out.println(n1);
          int n3 = n1+n2;
          n1 = n2;
          n2 = n3;
      }

    }


   }
