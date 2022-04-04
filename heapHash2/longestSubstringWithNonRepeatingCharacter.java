/*
1. You are given a string.
2. You have to find the length of the longest substring of
 the given string that contains all non-repeating characters.

Sample Input
aabcbcdbca
Sample Output
4
 */
    
    import java.util.*;

    public class longestSubstringWithNonRepeatingCharacter {
    
        public static int solution(String str) {
            int res = 0;
            int i = -1;
            int j = -1;
            HashMap<Character, Integer> map = new HashMap<>();
            
            while(true){
                boolean flag1 = false;
                boolean flag2 = false;

                //acquire till freq !=2
                while(i < str.length() - 1){
                    flag1 = true;
                    i++;
                    char ch = str.charAt(i);
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                    if(map.get(ch) == 2){
                      break;   //invalid
                    }else{
                        //calculate the length of the substring
                        int len = i - j;
                        res = Math.max(len, res);
                    }
                }

                //release till it again become valid
                while(j < i){
                    flag2 = true;
                    j++;
                    char ch = str.charAt(j);
                    map.put(ch, map.get(ch) - 1);

                    if(map.get(ch) == 1){
                        break;
                    }
                }

                if(flag2 == false && flag1 == false){
                    break;
                }
            }
            
            return res;
        }
        
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String str = scn.next();
            System.out.println(solution(str));
        }
    
    }
