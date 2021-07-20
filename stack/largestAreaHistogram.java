
import java.util.*;
public class largestAreaHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
 
        //int result send to print function
        int res = largestAreaHist(arr);
        System.out.println(res); 


    }

    //next smaller on right
    public static int[] nsr(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
    
        for(int i = 1; i < arr.length; i++) {
            while(st.size() > 0 && arr[st.peek()] > arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while(st.size() > 0) {
            res[st.pop()] = -1;
        }
        return res;
    }

    //next smaller on left
    public static int[] nsl(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);

        for(int i = arr.length - 2; i >= 0; i--) {
            while(st.size() > 0 && arr[st.peek()] > arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while(st.size() > 0) {
            res[st.pop()] = -1;
        }
        return res;
    }



    public static int largestAreaHist(int[] arr){
         int[] nextSright = nsr(arr);
         int[] nextSleft = nsl(arr);
         int ans = 0;
         for(int i = 0; i < arr.length; i++){
             ans = Math.max(ans,arr[i] * (nextSright[i]-nextSleft[i]-1));
         }
         return ans;
    }
}
