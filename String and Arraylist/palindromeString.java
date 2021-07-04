/*
abcc---i/p

o/p:
a
b
c
cc
c

*/

import java.io.*;
import java.util.*;




    import java.util.*;
    import java.io.*;
    public class palindromeString {
        public static boolean checkPalindrome(String str, int start, int end ){
            while(start<end){
                if(str.charAt(start) != str.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
        public static void findSubString(String str){
            int n = str.length();
            for(int i = 0; i<n; i++){
                for(int j = i;j<n;j++){
                    //String p = str.substring(i, j+1);
                    if(checkPalindrome(str,i,j)){
                       // System.out.println(p);
                       System.out.println(str.substring(i,j+1));
                    }
                }
            }
        }
    
        public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
            String str = scn.next();
            findSubString(str);
        }
    }
    
    // a
    // b
    // c
    // cc
    // c
    