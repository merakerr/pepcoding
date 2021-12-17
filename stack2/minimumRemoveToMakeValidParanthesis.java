/*
1: Given a string s of '(' , ')' and lowercase English characters
2: Your task is to remove the minimum number of parentheses ( '(' or ')') so that the resulting parentheses string is valid and return it.
3: In case of multiple valid strings give precedence in keeping innermost parenthesis.

example
(a(b(c)d) this string has (a(bc)d), (ab(c)d) and a(b(c)d) 3 valid strings.
Among all 3 valid strings a(b(c)d) has the innermost parentheses

*/

    import java.io.*;
    import java.util.*;
    
    public class minimumRemoveToMakeValidParanthesis {

        //code written here 
        public static String reverseParentheses(String s) {
            Stack<Integer> st = new Stack<>();
            char str[] = s.toCharArray();

            for(int i = 0; i < str.length; i++){
                if(str[i] == '('){
                 st.push(i);   
                }
                else if(str[i] == ')'){
                    if(st.size() == 0){
                        str[i] = '.';
                    }else{
                        st.pop();
                    }
                }
            }
           //last check if there is only one bracket "("
            while(st.size() > 0){
                str[st.pop()] = '.';
                
            }

            StringBuilder res = new StringBuilder();
            for(char c : str){
                if(c != '.'){
                    res.append(c);
                }
            }
            return res.toString();
        }
    
        public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
            String result = reverseParentheses(read.readLine());
            System.out.println(result);
            
        }
    }
    
