//leetcode 815
/*
You are given an array routes representing bus routes where routes[i] is a bus 
route that the ith bus repeats forever.
For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in 
the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
You will start at the bus stop source (You are not on any bus initially),
 and you want to go to the bus stop target. You can travel between bus stops
  by buses only.

Return the least number of buses you must take to travel from source to target.
 Return -1 if it is not possible.
Example 1:
Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
*/
    
    import java.io.*;
    import java.util.*;
    
    public class busRoute {
        private void makeMapWithBusStopAndBus(int[][] routes, HashMap<Integer, ArrayList<Integer>> map) {
            for(int r = 0; r < routes.length; r++) { // r -> bus number
                for(int c = 0; c < routes[r].length; c++) {
                    int stand = routes[r][c];
                    if(map.containsKey(stand) == true) {
                        // check if key is already present,
                        //if yes just add value i.e. bus number with that bus stop
                        map.get(stand).add(r);
                    } else {
                        ArrayList<Integer> busNo = new ArrayList<>();
                        busNo.add(r);
                        map.put(stand, busNo);
                    }
                }
            }
        }
    
        public int numBusesToDestination(int[][] routes, int source, int target) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            makeMapWithBusStopAndBus(routes, map);
    
            HashSet<Integer> visBus = new HashSet<>();
            HashSet<Integer> visStand = new HashSet<>();
            Queue<Integer> qu = new LinkedList<>();
            qu.add(source);
            int level = -1;
            while(qu.size() > 0) {
                int size = qu.size();
                level++;
                while(size-- > 0) {
                    int rem = qu.remove();
                    
                    if(rem == target) return level;
    
                    for(int busNum : map.get(rem)) {
                        if(visBus.contains(busNum) == true) {
                            continue;
                        } else {
                            for(int busStand : routes[busNum]) {
                                if(visStand.contains(busStand) == false) {
                                    visStand.add(busStand);
                                    qu.add(busStand);
                                }
                            }
                            visBus.add(busNum);
                        }
                    }
                }
            }
            return -1;
        }
      public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
    
        int[][] arr = new int[n][m];
    
        for (int i = 0; i < n; i++) {
          String[] st = br.readLine().split(" ");
          for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        String[] st1 = br.readLine().split(" ");
        int src = Integer.parseInt(st1[0]);
        int dest = Integer.parseInt(st1[1]);
        System.out.println(numBusesToDestination(arr, src, dest));
    
      }
    
      
    }
    
