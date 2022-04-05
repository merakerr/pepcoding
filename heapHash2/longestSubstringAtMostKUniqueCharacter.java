/*
1. You are given a string(str) and a number K.
2. You have to find the length of longest substring of 
the given string that contains at most K unique characters.


Sample Input
aabcbcdbca
2
Sample Output
4
*/
    
    import java.util.*;

    public class longestSubstringAtMostKUniqueCharacter {
    
        public static int solution(String str, int k) {
            int res = 0;
            int i = -1;
            int j = -1;
            HashMap<Character, Integer> map = new HashMap<>();
            while(true){
              boolean flag1 = false;
              boolean flag2 = false;
            //acquire strategy
              while( i < str.length() - 1){
                  flag1 = true;
                 i++;
                 char ch = str.charAt(i);
                 map.put(ch, map.getOrDefault(ch, 0) + 1);

                 if(map.size() <= k){
                     int len = i - j;
                    if(len > res){
                        res = len;
                    }
                 }else{
                     break;
                 }
              }

              //release case
                while(j < i){
                    flag2 = true;
                    j++;
                    char ch = str.charAt(j);

                    //remove till map.size > k
                    if(map.get(ch) == 1){
                        map.remove(ch);
                    }else{
                        //decrease the freq
                        map.put(ch, map.get(ch) -1);
                    }

                    //if map.size > k then we need to remove another as well
                    if(map.size() > k){
                        continue;
                    }else{
                        //it means we are on the matching state 
                        int len = i - j;
                        if(len > res){
                            res = len;
                        }
                    }
                    break;
                }

                if(flag1 == false && flag2 == false){
                    break;
                }
                
            }
            return res;
        }
        
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String str = scn.next();
            int k = scn.nextInt();
            System.out.println(solution(str,k));
        }
    
    }
    
