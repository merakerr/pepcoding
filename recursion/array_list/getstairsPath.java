

import java.io.*;
import java.util.*;

public class getstairsPath {
    public static ArrayList<String> getStairPath(int n) {
        if(n==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        else if(n<0){
            ArrayList<String> bres = new ArrayList<>();  
            return bres;
        }
        ArrayList<String> path1 = getStairPath(n-1);
        ArrayList<String> path2 = getStairPath(n-2);
        ArrayList<String> path3 = getStairPath(n-3);
      //resultant arraylist
        ArrayList<String> res = new ArrayList<>();
        for(String path: path1){
            res.add(1+path);
        }
        for(String path: path2){
            res.add(2+path);
        }
        for(String path: path3){
            res.add(3+path);
        }
     
        return res;
    }

    public static void main(String[] args) throws Exception {
           Scanner sc = new Scanner(System.in);
           int n = sc.nextInt();
           ArrayList<String> arr = getStairPath(n);
          System.out.println(arr);
    }

}




    // import java.io.*;
    // import java.util.*;
    
    // public class getstairsPath {
    //     public static ArrayList<String> getStairPath(int n) {
    //         if(n == 0) {
    //             ArrayList<String> bres = new ArrayList<>();
    //             bres.add(""); // don't move
    //             return bres;
    //         }
    
    //         ArrayList<String> mres = new ArrayList<>();
    //         if(n - 1 >= 0) {
    //             // jump for 1
    //             ArrayList<String> rres = getStairPath(n - 1);
    //             for(String s : rres) {
    //                 mres.add("1" + s);
    //             }
    //         }
    
    //         if(n - 2 >= 0) {
    //             // jump for 2
    //             ArrayList<String> rres = getStairPath(n - 2);
    //             for(String s : rres) {
    //                 mres.add("2" + s);
    //             }
    //         }
    
    //         if(n - 3 >= 0) {
    //             // jump for 3
    //             ArrayList<String> rres = getStairPath(n - 3);
    //             for(String s : rres) {
    //                 mres.add("3" + s);
    //             }
    //         }
    //         return mres;
    //     }
    
    //     public static void main(String[] args) throws Exception {
    //            Scanner sc = new Scanner(System.in);
    //            int n = sc.nextInt();
    //            ArrayList<String> arr = getStairPath(n);
    //           System.out.println(arr);
    //     }
    
    // }
    
