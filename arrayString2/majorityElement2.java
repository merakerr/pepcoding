
 //leetcode 229   
    
    /*
 Given an integer array of size 'n'.
 Find all elements that appear more than n / 3 times and return it in an arraylist.
 Note : solve the problem in linear time and in O(1) space.
     Example 1:
    Input: nums = [3,2,3]
    Output: [3]

    Example 2:
   Input: nums = [1]
   Output: [1]

   Example 3:
    Input: nums = [1,2]
    Output: [1,2]


    TC: O(n)
    Space: O(1)

    we basically create triplet of 3 diff num
    */
    import java.util.*;

    public class majorityElement2 {
    
        // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
        public static List<Integer> majorityElement(int[] arr) {
            int val1 = arr[0];
            int count1 = 1;  //count of val1 for curr window to make triplets

            int val2 = arr[0]; //assign random values
            int count2 = 0;    //count of val2 for curr window to make triplet

            for(int i = 1; i < arr.length; i++){
                if(arr[i] == val1){
                    count1++;
                }else if(arr[i] == val2){
                    count2++;
                }
                else{
                    if(count1 == 0){
                        val1 = arr[i];
                        count1 = 1;

                    }else if(count2 == 0){
                        val2 = arr[i];
                        count2 = 1;
                    }else{
                        count1--;
                        count2--;
                    }
                }
            }

            //check if it have freq more than n/3 using val1 and val2
            List<Integer> res = new ArrayList<>();
            
            if(count1 > 0 && checkFreqM2(arr, val1)){
                res.add(val1);
            }

            if(count2 > 0 && checkFreqM2(arr, val2)){
                res.add(val2);
            }
            return res;
        }
    



        public static boolean checkFreqM2(int[] arr, int val){
            int count = 0;
            for(int element : arr){
                if(element == val){
                    count++;
                }
            }
            return count > arr.length / 3;
        }
        // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
    
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
    
            List<Integer> res = majorityElement(arr);
            System.out.println(res);
        }
    }



    //  