//leetcode 849
/*
You are given an array representing a row of seats where seats[i] = 1 represents
 a person sitting in the ith seat,
 and seats[i] = 0 represents that the ith seat is empty (0-indexed).
There is at least one empty seat, and at least one person sitting.
Alex wants to sit in the seat such that the distance between him and the closest
 person to him is maximized. 
Return that maximum distance to the closest person.

Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

*/



import java.util.*;
public class maximumDistanceToClosestPerson{

 public static  int maxDistToClosest(int[] seats) {
    int dist = 0;
    int zeros = 0;
    int indx = 0;
    // left sub part
    while(seats[indx] != 1) {
        indx++;
        zeros++;
    }
    indx++;
    dist = zeros;
    zeros = 0;
    // segements calculations
    while(indx < seats.length) {
        while(indx < seats.length && seats[indx] != 1) {
            zeros++;
            indx++;
        }
        if(indx == seats.length)
            break;

        indx++;
        dist = Math.max(dist, (zeros + 1) / 2);
        zeros = 0;
    }

    // right sub part
    return Math.max(zeros, dist);
 }

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = sc.nextInt();
    }

    int res =  maxDistToClosest(arr);
    System.out.println(res);

}
}
