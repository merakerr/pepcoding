/*

similar to previous question --> just (character, String)

1. You are given two strings S1 and S2. S1 represents a word of length N and S2 represents N space-separated words.
2. You have to find if the words in S2 follow the exact order as characters in S1.

Note -> Every string consists of lower-case English letters only.

Sample Input
abab
pep coding pep coding

Sample Output
true
*/
    
    import java.util.*;

    public class wordPattern {
    
        public static boolean wordPattern(String pattern, String strs) {
            String[] str = strs.split(" ");
            HashMap<Character, String> map = new HashMap<>();
            HashSet<String> set = new HashSet<>();
            int l1 = pattern.length();
            int l2 = str.length;
            if(l1 != l2){
                return false;
            }
            for(int i = 0, j = 0; i < pattern.length(); i++){
                char ch1 = pattern.charAt(i);
                String ch2 = str[i];
                
                if(map.containsKey(ch1) == true){
                    String ss = map.get(ch1);
                    if(!ss.equals(ch2)){
                        return false;
                    }
                }else{
                    
                    if(set.contains(ch2)){
                        return false;
                    }
                    map.put(ch1, ch2);
                    set.add(ch2);
                }
            }
            return true;
        } 
        
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String pattern = scn.nextLine();
            String words = scn.nextLine();
            System.out.println(wordPattern(pattern,words));
        }
    
    }
    
