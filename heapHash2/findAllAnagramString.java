/*
1. You are given two strings s1 and s2.
2. You have to find the count of s2's anagrams that are present in s1.
3. Also, you have to print the start indices of such anagrams in s1.

Note -> Both s1 ad s2 consist of lowercase English letters only

Sample Input
cbaebabacd
abc

Sample Output
2
0 6 
*/
    
    import java.util.*;

    public class findAllAnagramString {
        public static void findAnagrams(String s, String p) {
           HashMap<Character, Integer> pmap = new HashMap<>();
           HashMap<Character, Integer> smap = new HashMap<>();

           //pattern map
           for(int i = 0; i < p.length(); i++){
               char ch = p.charAt(i);
               pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
           }
           
           //source map
           for(int i = 0; i < p.length(); i++){
               char ch = s.charAt(i);
               smap.put(ch, smap.getOrDefault(ch, 0) + 1);
           }

            
        }
    
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String s = scn.next();
            String p = scn.next();
            findAnagrams(s, p);
        }
    
    }
    
