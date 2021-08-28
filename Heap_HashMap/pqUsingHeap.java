
/*

definition----->>
            10
          /   \
        20      30
      /   \    /   \
     35   37   40  46

    * Indirect connection between parent and child
    let parent index = pi
    #left child = 2*pi+1;
    #right child = 2*pi+2

    in tree--->> we can move in downward direction only
    in arrayList-->>we can move in upward direction too

    child index = i;
    parent index = (i-1)/2



*/

import java.io.*;
import java.util.*;

public class pqUsingHeap {



  
  public static class PriorityQueue {
    ArrayList<Integer> data;
    private boolean flag;

    public PriorityQueue() {
      data = new ArrayList<>();
      flag = false;

    }
    public PriorityQueue(boolean flag) {
      data = new ArrayList<>();
      this.flag = false;

    }
    private void processArray(int[] arr) {
      for(int val : arr) {
          data.add(val);
      }

      for(int i = arr.length - 1; i >= 0; i--) {
          downheapify(i);
      }
  }

  public PriorityQueue(int[] arr) {
    data = new ArrayList<>();
    this.flag = false;
    processArray(arr);
}

public PriorityQueue(int[] arr, boolean flag) {
    data = new ArrayList<>();
    this.flag = flag;
    processArray(arr);
}
   
    private int checkPriority(int child, int parent){
        if(flag == true){
         //for max priority
          if(data.get(child) > data.get(parent)){
            return 1;
          }
        }
        else{
          //for min priority
          if(data.get(child) < data.get(parent)){
            return 1;
          }
        }
        return 0;
    }


   private void swap(int i, int j){
     int temp = data.get(i);
     data.set(i, data.get(j));
     data.set(j, temp);
   }

    private void upheapify(int index){
      if(index == 0){
        return;
      }

      int pi = (index-1)/2;
      if(checkPriority(index, pi) > 0){   //if priority of children is max than swap parent
        swap(index, pi);
        upheapify(pi);
      }
    }
    public void add(int val) {
      data.add(val);
      // maintain heap order property
      upheapify(data.size() - 1);
    }


    private void downheapify(int index){
         int minIndex = index;
        int leftChildIndex = 2*index+1;
        int rightChildIndex = 2*index+2;
        if(leftChildIndex < data.size() && data.get(minIndex) > data.get(leftChildIndex)){
          minIndex = leftChildIndex;
        }
        if(rightChildIndex < data.size() && data.get(minIndex) > data.get(rightChildIndex)){
          minIndex = rightChildIndex;
        }

        if(minIndex != index){
          swap(index, minIndex);
          downheapify(minIndex);
        }
        
    }
    public int remove() {
      if(data.size() == 0){
        System.out.println("Queue underflow");
        return -1;
      }
      swap(0, data.size()-1);
      int val = data.remove(data.size()-1);
      //maintain heap order property
      downheapify(0);

      return val;
    }

    public int peek() {
      if(data.size() == 0){
        System.out.println("Queue underflow");
        return -1;
      }

      //return head node
      return data.get(0);
    }

    public int size() {
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}





/*

removal of node-->>
1)swap between first node and last node ie swap(0, data,size-1)
2)remove last item  ie data.remove(size-1)
3)maintain heap order property--->> As order is degraded from 0th position
  so downheapify(0)



*/