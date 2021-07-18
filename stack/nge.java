import java.util.*;

class nge {
    //4,45,6,2,4,7=---45, -1, -1, 4, 7, -1
//    0  1 2 3 4 5     0   1   2  3  4   5
//	string i = st.pop()    this will return the item which is poped
//as we are inserting the index on the stack hence the index will be replaced here
//   steps for solving this problems
//   1) insert the first index in the Stack
//   2) chk if the stack is > 0 or not.. 
//   3) check if the peak element is less than the current 
//   element in the array , then the ngr is the element in the array
//   4) need to pop the element from the stack and update the particular index in the newly 
//     created arr
//   5)else insert into the stack;
  

//    4,45,6,2,4,7=---45, -1,  7, 4, 7, -1
//    0  1 2 3 4 5     0   1   2  3  4   5
   public static int[] ngr(int[] arr) {
    int[] res = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    st.push(0);

    for(int i = 1; i < arr.length; i++) {
        while(st.size() > 0 && arr[st.peek()] < arr[i]) {
            res[st.pop()] = arr[i];
        }
        st.push(i);
    }
    while(st.size() > 0) {
        res[st.pop()] = -1;
    }
    return res;
}

   public static void printFunc(int[] arr){
       for(int i: arr){
           System.out.println(i);
       }
   }
   public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] arr = new int[n];
       for(int i = 0;i<n;i++){
           arr[i] = sc.nextInt();
       }

       //int result send to print function
       int[] res = ngr(arr);
       printFunc(res);

   }
}
