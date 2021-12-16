/*
//leetcode 921

A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

 

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
*/
    
    import java.io.*;
    import java.util.*;
    
    public class minimumAddToMakeParethesisValid {

        //code written here
        public static int minAddToMakeValid(String arr) {
            Stack<Character> st = new Stack<>();
            for(int i = 0; i < arr.length(); i++){
                char ch = arr.charAt(i);
                if(ch == '(' || st.size() == 0){
                    st.push(ch);
                }else if(st.peek() == '('){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
            return st.size(); //items which are left in the
            //stack are the items whose parenthies doesnt not matched
        }
    
        public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
            int result = minAddToMakeValid(read.readLine());
            System.out.println(result);
        }
    }
