//leetcode 1750

/*
Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:

Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
The prefix and the suffix should not intersect at any index.
The characters from the prefix and suffix must be the same.
Delete both the prefix and the suffix.
Return the minimum length of s after performing the above operation any number of times (possibly zero times).

Example 
Input: s = "cabaabac"
Output: 0
Explanation: An optimal sequence of operations is:
- Take prefix = "c" and suffix = "c" and remove them, s = "abaaba".
- Take prefix = "a" and suffix = "a" and remove them, s = "baab".
- Take prefix = "b" and suffix = "b" and remove them, s = "aa".
- Take prefix = "a" and suffix = "a" and remove them, s = "".
*/

import java.util.*;
public class minLengthOfStringAfterDelSimilarEnd {
    public static int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right && s.charAt(left) == s.charAt(right)){
            
            char ch = s.charAt(left);
            //move left ahead with same char present
            while(left <= right && s.charAt(left) == ch){
                left++;
            }
            //move right in backward with same char
            while(left <= right && s.charAt(right) == ch){
                right--;
            }
        }
        return right - left + 1;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int res = minimumLength(str);
    System.out.println(res);
}    
}
