/*
1. Given an array nums of 'n' integers.
2. You have to return an array of all the unique quadruple [nums[a],
 nums[b], nums[c], nums[d]] such that: 
    2.1 a, b, c, and d are less than 'n' and greater than 0
    2.2 a,. b, c, and d are Unique.
    2.3 nums[a] + nums[b] + nums[c] + nums[d] == target.
3. You can return answer in any order.


input:
6
1 0 -1 0 -2 2
0

output:
-1 0 0 1 
-2 -1 1 2 
-2 0 0 2 
*/
    
    import java.util.*;

    public class fourSum {
    
      public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n - 3; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int val1 = nums[i];
            List<List<Integer>> subres = threeSum(nums, target - val1, i+1);
            for(List<Integer> list : subres){
                list.add(val1);
                res.add(list);
            }
        }
        return res;
      }

      public static List<List<Integer>> threeSum(int[] nums, int target, int st) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = st; i < nums.length - 2; i++) {
            if(i != st && nums[i] == nums[i - 1])
                continue;

            int val1 = nums[i];
            int smallTarget = target - val1;

            List<List<Integer>> subres = twoSum(nums, i + 1, nums.length - 1, smallTarget);
            for(List<Integer> list : subres) {
                list.add(val1);
                res.add(list);
            }
        }
        return res;
      }


      private static List<List<Integer>> twoSum(int[] arr, int st, int end, int target) {
        int left = st;
        int right = end;
        List<List<Integer>> res = new ArrayList<>();
        while(left < right) {
            if(left != st && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if(sum == target) {
                List<Integer> subres = new ArrayList<>();
                subres.add(arr[left]);
                subres.add(arr[right]);
                res.add(subres);

                left++;
                right--;
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
    
      public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        List<List<Integer>> res = fourSum(arr, target);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
          Collections.sort(list);
          String ans = "";
          for (int val : list) {
            ans += val + " ";
          }
          finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
          System.out.println(str);
        }
      }
    }
