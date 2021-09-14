//leetcode 881

/*
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.


Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

*/
    
    import java.util.*;

    public class boatsTosavePeople {
    
      // ~~~~~~~~~~~User's Section~~~~~~~~~~~~
      public static int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while(left <= right) {
            int sum = people[left] + people[right];
            if(sum <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            boats++;
        }
        return boats;
    }
    
      // ~~~~~~~~~~Input Management~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] people = new int[n];
    
        for (int i = 0; i < n; i++)
          people[i] = scn.nextInt();
    
        int limit = scn.nextInt();
        int boats = numRescueBoats(people, limit);
        System.out.println(boats);
      }
    }
