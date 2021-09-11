//leetcode 680
    
/*
Given a string s, return true if the s can be palindrome after deleting at
 most one character from it.

Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
*/
    import java.util.*;

    public class validPalindrome {
    
      // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
      public static boolean validPalindromes(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
      }

      private static boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
    
      // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
    
        boolean res = validPalindromes(str);
        System.out.println(res);
      }
    }
