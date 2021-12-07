  /*
  Given a circular integer array nums 
  (i.e., the next element of nums[nums.length - 1] 
  is nums[0]), return the next greater number for every
   element in nums.

 Sample Input
3
1
2
1
Sample Output
3
2
-1
2
  
  */
    
    import java.io.*;
    import java.util.*;
    
    public class nextGreaterElemenetTwo {

        //code written here 
        public static int[] nextGreaterElementII(int[] nums) {
            int[] res = new int[nums.length];
            int n = nums.length;
            Stack<Integer> st = new Stack<>();

            for(int i = n - 2; i >= 0; i--){
                while(st.size() > 0 && st.peek() <= nums[i]){
                    st.pop();
                }

                st.push(nums[i]);
            }

            for(int i = n - 1; i >= 0; i--){
                while(st.size() > 0 && st.peek() <= nums[i]){
                    st.pop();
                }
                res[i] = st.size() == 0 ? -1:st.peek();
                st.push(nums[i]);
            }
            return res;
        }
    
    
        public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    
            int n = Integer.parseInt(read.readLine());
            int nums[] = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = Integer.parseInt(read.readLine());
            }
            
            int ans[] = nextGreaterElementII(nums);
    
            n = ans.length;
    
            System.out.println(n);
            for(int e: ans){
                System.out.println(e);
            }
            
        }
    }
