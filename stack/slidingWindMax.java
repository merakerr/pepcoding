
    
    import java.util.*;

    public class slidingWindMax {
        public static int[] rightGreaterIndex(int[] arr) {
            int[] res = new int[arr.length];
            Stack<Integer> st = new Stack<>();
            st.push(0);
    
            for(int i = 1; i < arr.length; i++) {
                while(st.size() > 0 && arr[st.peek()] < arr[i]) {
                    res[st.pop()] = i;
                }
                st.push(i);
            }
            while(st.size() > 0) {
                res[st.pop()] = arr.length;
            }
            return res;
        }
        public static void slidingWindowMax(int[] arr, int k) {

            int[] rgi = rightGreaterIndex(arr);
            int j = 0;
            for(int i = 0; i <= arr.length-k; i++){
               j = i;
               while(rgi[j] < i+k){
                  j = rgi[j];
               }
               System.out.println(arr[j]);

            }
            /*
            int[] rgi = rightGreaterIndex(arr);
    
            int j = 0;
            for(int i = 0; i <= arr.length - k; i++) {
                if(i > j) {
                    j = i;
                }
    
                while(i + k > rgi[j]) {
                    j = rgi[j];
                }
                System.out.println(arr[j]);
            }
            */
        }
    
       public static void main(String args[]){
        //    Scanner sc = new Scanner(System.in);
        //    int n = sc.nextInt();
        //    int[] arr = new int[n];
        //    for(int i = 0;i<n;i++){
        //        arr[i] = sc.nextInt();
        //    }
        //    int k = sc.nextInt();

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
         int k = 3; //window size
           slidingWindowMax(arr, k);
    
       }
    }
