
/*
/check for duplcates
e.g.'
((a + b) + (c + d)) -> false
(a + b) + ((c + d)) -> true
*/

import java.util.*;
public class duplicateBracket {
//function declaration 
public static boolean findDuplicates(String str){
    Stack<Character> st = new Stack<>();
    
     for(int i = 0; i<str.length(); i++){
        char ch = str.charAt(i);
        if(ch != ')'){
            st.push(ch);
        }
        else{
            System.out.println(st.peek());
            if(st.peek() == '(')   return true;

            while(st.peek() != '('){
                st.pop();
                //pop the last element also.
            }
                st.pop();
            
        }
     }
     return false;

}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    //string declaration
    String str = sc.nextLine();
    boolean res = findDuplicates(str);
    System.out.println(res);
}
}
