//leetcode 1190

/*
1: You are given a string s that consists of lower case English letters and brackets. 
2: Reverse the strings in each pair of matching parentheses, starting from the innermost one.
3: Your result should not contain any brackets.

Example
(abcd) -> dcba
(u(love)i) -> iloveu
(gni(pc(do))ep) -> pepcoding


*/
    
    import java.io.*;
    import java.util.*;
    
    public class reverseSubstringBetweenEachPairOfParenthesis {

        //code written here 
        public static String reverseParentheses(String s) {
            Stack<Character> st = new Stack<>();
        
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                
                if(ch != ')'){
                    st.push(ch);
                }else{
                   StringBuilder str = new StringBuilder();
                    while(st.peek() != '('){
                        str.append(st.pop());
                    }
                    
                    //last items need to pop as well
                    st.pop();
                   for(int j = 0; j < str.length(); j++){
                       st.push(str.charAt(j));
                   }
                }
            }
            
            StringBuilder res = new StringBuilder();
            while(st.size() > 0){
                res.append(st.pop());
            }
            res.reverse();
            return res.toString();
        }
        
        public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
            String result = reverseParentheses(read.readLine());
            System.out.println(result);
            
        }
    }
    
