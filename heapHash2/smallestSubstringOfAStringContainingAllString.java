/*
1. You are given two strings s1 and s2 containing lowercase english alphabets.
2. You have to find the smallest substring of s1 that contains all the characters of s2.
3. If no such substring exists, print blank string("").


Sample Input
timetopractice
toc
Sample Output
toprac
*/


    
    import java.util.*;

    public class smallestSubstringOfAStringContainingAllString {
        public static String solution(String s1, String s2){
            String res = "";
            HashMap<Character, Integer> map2 = new HashMap<>();
            
            for(int i = 0; i < s2.length(); i++){
                char ch = s2.charAt(i);
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            }

            int matchCount = 0;
            int desireMatchCount = s2.length();

            HashMap<Character, Integer> map1 = new HashMap<>();
            //we need to two pointer as well
            int i = -1;
            int j = -1;
           
            while(true){
               
                boolean flag1 = false;
                boolean flag2 = false;
                //acquire
               while(i < s1.length() -1  && matchCount < desireMatchCount){
                i++;
                char ch = s1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
               
                if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){
                    matchCount++;
                }
                flag1 = true;
             }

             //release and collect answer
            while(j < i && matchCount == desireMatchCount){
                //collect answer
                String answer = s1.substring(j + 1, i + 1);
                //i+1 to include ith char as well
                //j + 1 to start from 0 location as j start from -1
                if(res.length() == 0 || answer.length() < res.length()){
                    res = answer;
                }
                j++;
                char ch = s1.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch); 
                }else{
                  map1.put(ch, map1.get(ch) - 1);
                }
  
  
                if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){
                    matchCount--;
                }
                flag2 = true;
              }
             if(flag1 == false && flag2 == false){
                  break;
             }
            }

            
            return res;
        }
    
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String s1 = scn.next();
            String s2 = scn.next();
            System.out.println(solution(s1,s2));
        }
    
    }
