
    
//abccbc---9

import java.io.*;
import java.util.*;




    import java.util.*;
    import java.io.*;
    public class countPalindromicSubstring {
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
            int count = 0;
            for(int i = 0; i<n; i++){
                for(int j = i;j<n;j++){
                    if(checkPalindrome(str,i,j)){
                      // System.out.println(str.substring(i,j+1));
                      count++;
                    }
                }
            }
            System.out.println(count);
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
    
