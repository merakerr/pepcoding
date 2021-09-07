
    // lintcode 912
 
    /*
 A group of two or more people wants to meet and minimize the total travel
  distance. You are given a 2D grid of values 0 or 1, where each 1 marks
   the home of someone in the group. The distance is calculated using 
   Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.


Example 1:
Input:
[[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output:
6

Explanation:
The point `(0,2)` is an ideal meeting point, as the total travel distance
 of `2 + 2 + 2 = 6` is minimal. So return `6`.

Example 2:
Input:
[[1,1,0,0,1],[1,0,1,0,0],[0,0,1,0,1]]
Output:
14
    */


    import java.util.*;

    public class bestMeetingPoint {
    
        // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
        public static int minTotalDistance(int[][] grid) {
        ArrayList<Integer> xcord = new ArrayList<>();
        // fill xcordinate in sorted manner -> row wise traversal
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1)
                    xcord.add(r);
            }
        }
        ArrayList<Integer> ycord = new ArrayList<>();
        // fill ycordinate in sorted manner -> column wise traversal
        for(int c = 0; c < grid[0].length; c++) {
            for(int r = 0; r < grid.length; r++) {
                if(grid[r][c] == 1)
                    ycord.add(c);
            }
        }
        // find meeting point
        int x = xcord.get(xcord.size() / 2);
        int y = ycord.get(ycord.size() / 2);
        int dist = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    dist += Math.abs(x - r) + Math.abs(y - c);
                }  
            }
        }
        return dist;
        }
    
        // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int m = scn.nextInt();
    
    
            int[][] grid = new int[n][m];
    
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    grid[i][j] = scn.nextInt();
                }
            }
    
            int dist = minTotalDistance(grid);
            System.out.println(dist);
        }
    }
