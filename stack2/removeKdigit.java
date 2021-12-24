/*
//leetcode 402

Given string num representing a non-negative integer num,
 and an integer k, print the smallest possible integer after
  removing k digits from num


  Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/


    
    import java.io.*;
    import java.util.*;
    
    public class removeKdigit {
        public static String removeKdigits(String num, int k) {
            LinkedList<Character> st = new LinkedList<>();
            
            for(int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                while(k > 0 && st.size() > 0 && st.getLast() > ch) {
                    k--;
                    st.removeLast();
                }
                st.addLast(ch);
            }
            
            // manage remaining K's
            while(k > 0) {
                st.removeLast();
                k--;
            }
            
            // manage leading 0's
            while(st.size() > 0 && st.getFirst() == '0') {
                st.removeFirst();
            }
            
            StringBuilder str = new StringBuilder();
            for(char ch : st) {
                str.append(ch);
            }
            return str.length() == 0 ? "0" : str.toString();
        }
        public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
            String num = read.readLine();
            int k = Integer.parseInt(read.readLine());
            
            String res = removeKdigits(num, k);
            System.out.println(res);
        }
    }
