//leetcode 946

/*
1: Given two sequences pushed and popped with distinct values.
2: You have to return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack
*/
    
    import java.io.*;
    import java.util.*;
    
    public class validateStackSequebce {

        //code written here
        public static boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> st = new Stack<>();
            int j = 0;
            for(int i : pushed){
                st.push(i); 

                while(st.size() > 0 && st.peek() == popped[j]){
                    st.pop();
                    j++;
                }
            }
            return j == popped.length;
        }
    
        public static int[] getArr(String s){
            String nums[] = s.split(" ");
            int n = nums.length;
            int ar[] = new int[n];
            for(int i=0;i<n;i++){
                ar[i] = Integer.parseInt(nums[i]);
            }
            return ar;
        }
        
        public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
            int pushed [] = getArr(read.readLine());
            int popped [] = getArr(read.readLine());
            
            boolean result = validateStackSequences(pushed, popped);
    
            System.out.println(result);
        }
    }
