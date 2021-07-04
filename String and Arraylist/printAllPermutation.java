
    
    import java.io.*;
    import java.util.*;
    
    public class printAllPermutation {
    
        public static void solution(String str){
           int nf = 1;
		   for(int i = 2;i<=str.length();i++){
			   nf = nf*i; //6
		   }
		   for(int i = 0;i<nf;i++){ //0 1 2
			   
			   int n = i;
			   int div = str.length();
			   StringBuilder sb = new StringBuilder(str);
			   while(div >= 1){
				   int q = n/div;
				   int r = n%div;
				   System.out.print(sb.charAt(r));
				   sb.deleteCharAt(r);
				   n = q;
				   div--;
			   }
			   System.out.println();
		   }
            
        }
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String str = scn.next();
            solution(str);
        }
    
    }
