/*
check for balanced bracket
e.g.
[(a + b) + {(c + d) * (e / f)}] -> true
[(a + b) + {(c + d) * (e / f)]} -> false
[(a + b) + {(c + d) * (e / f)} -> false
([(a + b) + {(c + d) * (e / f)}] -> false



*/
import java.util.*;
    public class balancedBracket {
        
        public static boolean findBalanced(String str){
            Stack<Character> st = new Stack<>();
    
            for(int i = 0;i<str.length();i++){
                char ch = str.charAt(i);
    
                if(ch == '(' || ch == '{' || ch == '['){
                   st.push(ch);
                }
                else if(ch ==')'){
                   if(st.isEmpty() || st.peek() != '(') return false;
                   st.pop();
    
                }
                else if(ch =='}'){
                if( st.peek() != '{') return false;
                  st.pop();
                }
                else if(ch == ']'){
                    if(st.peek() != '[') return false;
                    st.pop();
                }
                else{
                   // continue;
                }
            }
            if(st.size() ==0){
                return true;
            }
            else{
                return false;
            }
            //return st.size()==0;
        }
        
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            //string declaration
            String str = sc.nextLine();
            boolean res = findBalanced(str);
            System.out.println(res);
        }
    }