

/*
1. You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
2. Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
3. You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


Sample Input
10 3
Sample Output
3

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
*/


    
    import java.util.*;
    import java.io.*;
    
    public class findBadVersion {
    
        //code written here 
      public static int firstBadVersion(int n) {
       int low = 1;
       int high = n;
       
       int first_bad_version = -1;

       while(low <= high){
           int mid = low + (high - low) / 2;
           if(isBadVersion(mid) == true){
             first_bad_version = mid;
             high = mid - 1;
           }else{
               low = mid + 1;
           }

       }
        return first_bad_version;
      }
    
      static int bad = 0;
      public static boolean isBadVersion(int val) {
        if (val >= bad) {
          return true;
        }
        else {
          return false;
        }
      }
    
      public static void solve(int n, int fbv) {
        bad = fbv;
        System.out.println(firstBadVersion(n));
      }
    
      public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int fbv = scn.nextInt();
    
        solve(n, fbv);
      }
    }
