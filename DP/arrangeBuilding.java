

import java.util.*;
public class arrangeBuilding {
  public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
    
        int[][] dp = new int[n+1][2];
        //int val = arrangeBuilding_rec(n, 1);
       /// System.out.println(val*val);
        //int res = arrangeBuilding_tabu1(n);
        int res = arrangeBuilding_optimized(n);
        System.out.println(res);
  }  
 

   // recurrsion solution
  public static int arrangeBuilding_rec(int n, int lastItem){ //last item --->>space
         
    if(n == 0){
        return 1;
    }
    int count = 0;
  //0 -->> building 
  //1-->>spaces
    if(lastItem == 1){             //if spaces we can add building
    count += arrangeBuilding_rec(n-1, 0);
    }
    //else we cannot add bulding here 
    count += arrangeBuilding_rec(n-1, 1);

    return count;
  }


  //tabulation
  public static int arrangeBuilding_tabu1(int n){
      int[] dp_b = new int[n+1];
      int[] dp_s = new int[n+1];

      dp_b[1] = 1;
      dp_s[1] = 1;
      
      for(int i = 2; i <= n; i++){
          dp_s[i] = dp_s[i-1]+dp_b[i-1];
          dp_b[i] = dp_s[i-1];
      }
      int res = dp_b[n]+dp_s[n];
      return res*res;

      //we can arrange building combination in both ends -->>res*res
  }

  //optimized problem
  public static int arrangeBuilding_optimized(int n){
      
     int building = 1;
     int spaces = 1;
     for(int i = 2; i <= n; i++){
         int n_building = spaces;
        int n_spaces = building + spaces;

        spaces = n_spaces;
        building = n_building;
     }
    int res =  spaces+building;
    return res*res;
  }
}
