  /*

  leetcode 856
  Given a balanced parentheses string S, compute the score of the string based on the following rule:
    () has score 1
    AB has score A + B, where A and B are balanced parentheses strings.
    (A) has score 2 * A, where A is a balanced parentheses string.

Score of ()()() string is 3 => 1 + 1 + 1
Score of (()) string is 2 => 2 * 1
  */
    
    import java.io.*;
    import java.util.*;
    
    public class scoresOfParenthesis {

        //code written here 
        public static int scoreOfParentheses(String s) {
            Stack<Integer> st = new Stack<>();
             for(int i = 0; i < s.length(); i++){
                 char ch = s.charAt(i);
                 if(ch == '('){
                     st.push(-1);
                 }else{

                     //if

                     if(st.peek() == -1){
                         //we got ()===>> 1
                         st.pop();
                         st.push(1);
                     }
                     //else
                        else{
                            int sum = 0;
                             while(st.peek() != -1) {
                               sum += st.pop();
                             }
                            //at the end pop the -1 as well
                            st.pop();
                            
                            //now push the value 2*a value
                            st.push(2*sum);
                        
                        }
                 }
             }
            int sum = 0;
             while(st.size() > 0){
                 sum += st.pop();
             }
             
            return sum;
        }
    
        public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
            int score = scoreOfParentheses(read.readLine());
            System.out.println(score);
            
        }
    }
    
