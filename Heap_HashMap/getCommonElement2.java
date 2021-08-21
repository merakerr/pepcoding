
/*
statements:
You are given two arrays.. you need to find the common element present in 
both the array

arr-1 = 1 1 2 3 2 4 4 5
arr-2 = 1 2 4 3 2 1 3 7

freq in arr-1

1-->2
2-->2
3-->1
4-->2
5-->1

Now in array-2 trsversal time
if arr2.contains(key of arr1   then print the key and decrease the freq
condition map.contain(key)==true && map.get(key)>0)
*/



import java.util.*;
public class getCommonElement2{



    public static void printCommonElement2(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //prepare freq mapping
        for(int key : arr1){
            if(map.containsKey(key) == true){
                //increase freq
                map.put(key, map.get(key) + 1);

            }
            else{
                //add on the map with freq 1
                map.put(key, 1);
            }
        }

        //traverse arr2 for common items 
        for(int key : arr2){
          if(map.containsKey(key) == true && map.get(key) > 0){
              System.out.println(key);
              map.put(key, map.get(key)-1);
          }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i<n1;i++){
             arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i<n2;i++){
             arr2[i] = sc.nextInt();
        }

        printCommonElement2(arr1,arr2);
    }
}