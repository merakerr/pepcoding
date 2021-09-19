
//leetcode 853
/*
There are n cars going to the same destination along a one-lane road. The destination is target miles away.
You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
The distance between these two cars is ignored (i.e., they are assumed to have the same position).
A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
Return the number of car fleets that will arrive at the destination.
Example 1:
Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation: 
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.
*/
import java.util.*;
public class carFleet {

    private static class Pair implements Comparable<Pair> {
        int pos;
        int speed;

        public Pair(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        public int compareTo(Pair o) {
            return this.pos - o.pos;
        }
    }

    public static int carFleets(int target, int[] position, int[] speed) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < position.length; i++) {
            pq.add(new Pair(position[i], speed[i]));
        }
        double maxT = 0;
        int fleets = 0;
        while(pq.size() > 0) {
            Pair rem = pq.remove();
            double time = (target - rem.pos) / (rem.speed * 1.0);
            if(time > maxT) {
                fleets++;
                maxT = time;
            }
        }
        return fleets;
    }
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] position = new int[n];
    int[] speed = new int[n];
    for(int i = 0; i < n; i++){
        position[i] = sc.nextInt();
    }
    for(int i = 0; i < n; i++){
        speed[i] = sc.nextInt();
    } 
    int target = sc.nextInt();
    int res = carFleets(target, position, speed);
    System.out.println(res);
   } 

   
}
