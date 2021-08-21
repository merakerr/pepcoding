/*
string  = zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
ans = q  -->> it has the highest freq

*/

    import java.util.*;
    
    public class highestFreqCharacter {
           public static void printHighestFreqChar(String str) {
            HashMap<Character, Integer> map = new HashMap<>();
    
            // maintain freq map
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(map.containsKey(ch) == true) {
                    // increase frequency
                    map.put(ch, map.get(ch) + 1);
                } else {
                    // first time occurrence
                    map.put(ch, 1);
                }
            }

            //find max freq character
            char ch = 'a';
            int maxFreq = 0;
            for(char key : map.keySet()){
                if(map.get(key) > maxFreq){
                    maxFreq = map.get(key);
                    ch = key;
                }
            }
            System.out.println(ch);
          // System.out.println(ch+" "+maxFreq);
        }
        public static void main(String[] args) throws Exception {
           Scanner sc = new Scanner(System.in);
           String str = sc.nextLine();
           printHighestFreqChar(str);
           
        }
    
    }
