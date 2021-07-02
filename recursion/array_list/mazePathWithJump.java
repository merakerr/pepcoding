
    
    import java.io.*;
    import java.util.*;
    
    public class mazePathWithJump {
    
        public static void main(String[] args) throws Exception {
            Scanner sn = new Scanner(System.in);
            //   int sr = sn.nextInt();
            //   int sc = sn.nextInt();
               int dr = sn.nextInt();
               int dc = sn.nextInt();
               ArrayList<String> arr = getMazePathWithJumps(0,0,dr-1,dc-1);
               System.out.println(arr);
        }
    
        // sr - source row
        // sc - source column
        // dr - destination row
        // dc - destination column
        public static ArrayList<String> getMazePathWithJumps(int sr, int sc, int dr, int dc) {
            if(sr == dr && sc == dc) {
                ArrayList<String> bres = new ArrayList<>();
                bres.add("");
                return bres;
            }
    
            ArrayList<String> mres = new ArrayList<>();
            // horizontal
            for(int jump = 1; jump + sc <= dc; jump++) {
                ArrayList<String> res = getMazePathWithJumps(sr, sc + jump, dr, dc);
    
                for(String s : res) {
                    mres.add("h" + jump + s);
                }
            }
            // vertical
            for(int jump = 1; jump + sr <= dr; jump++) {
                ArrayList<String> res = getMazePathWithJumps(sr + jump, sc, dr, dc);
    
                for(String s : res) {
                    mres.add("v" + jump + s);
                }
            }
            // diagonal
            for(int jump = 1; sr + jump <= dr && jump + sc <= dc; jump++) {
                ArrayList<String> res = getMazePathWithJumps(sr + jump, sc + jump, dr, dc);
    
                for(String s : res) {
                    mres.add("d" + jump + s);
                }
            }
            return mres;
        }
    
    
    }
