
/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

Example 1:
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
*/
import java.util.*;
public class gasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for(int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum - costSum < 0) {
            return -1;
        }
        int indx = 0;
        int prefixSum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < gas.length; i++) {
            prefixSum += gas[i] - cost[i];
            if(prefixSum < min) {
                min = prefixSum;
                indx = i;
            }
        }
        return (indx + 1) % gas.length;
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[]gas = new int[n];
    int[]cost = new int[n];
    for(int i = 0; i < n; i++){
        gas[i] = sc.nextInt();
    }

    for(int i = 0; i < n; i++){
        cost[i] = sc.nextInt();
    }

    int res = canCompleteCircuit(gas, cost);
    System.out.println(res);

}
}
