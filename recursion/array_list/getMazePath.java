
    
    import java.io.*;
    import java.util.*;
    ;
        
        public class getMazePath {
            public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
                // System.out.println(sr + " " + sc);
                if(sr == dr && sc == dc) {
                    ArrayList<String> bres = new ArrayList<>();
                    bres.add("");
                    return bres;
                } else if(sr > dr || sc > dc) {
                    ArrayList<String> bres = new ArrayList<>();
                    return bres;
                }
        
        
                // stupd call
                // horizontal call
                ArrayList<String> hres = getMazePaths(sr, sc + 1, dr, dc);
                // vertical call
                ArrayList<String> vres = getMazePaths(sr + 1, sc, dr, dc);
        
                ArrayList<String> mres = new ArrayList<>();
                for(String s : hres) {
                    mres.add("h" + s);
                }
        
                for(String s : vres) {
                    mres.add("v" + s);
                }
                return mres;
            }
            public static void main(String[] args) throws Exception {
               Scanner sn = new Scanner(System.in);
            //   int sr = sn.nextInt();
            //   int sc = sn.nextInt();
               int dr = sn.nextInt();
               int dc = sn.nextInt();
               ArrayList<String> arr = getMazePaths(0,0,dr-1,dc-1);
               System.out.println(arr);
        
            }
        
            // sr - source row
            // sc - source column
            // dr - destination row
            // dc - destination column
            
        
        }
