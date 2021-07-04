

import java.util.*;
import java.lang.*;
   
public class rotateNumber {
   
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    
    
    int num = n;
    int nod  = 0;
    while(num != 0){
        num /=10;
        nod++;
    }
    k = k%nod;
    if(k<0){
        k = k+nod;
      }
    int div = (int)Math.pow(10, k);
   
    

    int q = n/div;
    int r = n%div;
    int mult = (int)Math.pow(10, nod-k);
    int ans = r*mult + q;
    System.out.println(ans);
    }
   }
