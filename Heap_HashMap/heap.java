/*
Intro

1)Priority queue --->> heap
2)similar to queue but get and remove will be based on priority
3)Null is not accepted in priority Queue




*/



import java.util.*;


public class heap{



    public static void demo(){
        //default priority min
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(9);
        // System.out.println(pq.peek());
        pq.add(7);
        pq.add(11);
        // System.out.println(pq.peek());
        
        while(pq.size() > 0){
            int rem = pq.remove();
            System.out.println(rem);
        }
    
       System.out.println("**********");
       System.out.println();

        //default priority max
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());  //for max 
        pq1.add(10);
        pq1.add(9);
        // System.out.println(pq1.peek());
        pq1.add(7);
        pq1.add(11);
        pq1.add(20);
        // System.out.println(pq1.peek());



        while(pq1.size() > 0){
            int rem = pq1.remove();
            System.out.println(rem);
        }
    }
    public static void main(String[] args) {
        demo();
    }
}