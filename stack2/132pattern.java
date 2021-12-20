/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false.
*/
    
    import java.io.*;
    import java.util.*;
    
    public class 132pattern {
        
        public static boolean pattern(int[] nums){
            int[] lmin = new int[nums.length];
            
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < nums.length; i++) {
                min = Math.min(min, nums[i]);
                lmin[i] = min;
            }
            
            Stack<Integer> st = new Stack<>();
            for(int i = nums.length - 1; i >= 0; i--) {
                while(st.size() > 0 && st.peek() <= lmin[i]) {
                    st.pop();
                }
                if(st.size() > 0 && st.peek() < nums[i]) {
                    return true;
                }
                st.push(nums[i]);
            }
            return false;
        }
        
        public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
        boolean res = pattern(arr);
        System.out.println(res);
          
        }
    }
    
