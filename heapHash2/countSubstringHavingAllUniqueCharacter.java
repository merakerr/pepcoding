/*
1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.


Sample Input
aabcbcdbca
Sample Output
24

formula for substring = n * (n + 1) / 2
*/
    
    import java.util.*;

    public class countSubstringHavingAllUniqueCharacter {
    
        public static int solution(String str) {
            int res = 0;
            int i = -1;
            int j = -1;
            HashMap<Character, Integer> map = new HashMap<>();

            while(true){
                boolean flag1 = false;
                boolean flag2 = false;

                //acquire till no duplicate
               while(i < str.length() - 1){
                   flag1 = true;
                   i++;
                   char ch = str.charAt(i);
                   map.put(ch, map.getOrDefault(ch, 0) + 1);
                   if(map.get(ch) == 2){
                       //duplicates
                       break;
                   }else{
                       //no duplicates
                       res += i - j;
                   }
               }
            
                //release when duplicates
                while(j < i){
                    flag2 = true;
                    j++;

                    char ch = str.charAt(j);
                    map.put(ch, map.get(ch) - 1);

                    if(map.get(ch) == 1){
                        //valid ---> collect answer
                        res += i - j; 
                        
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
    
