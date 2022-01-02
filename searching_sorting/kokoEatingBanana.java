
    /*
    1. Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
    2. Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    3. Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
    4. Return the minimum integer k such that she can eat all the bananas within h hours.
    
    Sample Input
    4
    3 6 7 11
    8
    Sample Output
    4

    need to find minimum speed under which koko can eat all
    the bananas in 8 hrs

    */
import java.util.*;
import java.io.*;

public class kokoEatingBanana {
    
    public static boolean pilesCanBeEaten(int[] arr, int speed, int hr){
        int time = 0;
        for(int i = 0; i < arr.length; i++){
            time += (int)Math.ceil(arr[i] * 1.0 / speed);

        }
        return time <= hr;
    }

    public static int minEatingSpeed(int[]piles,int h) {

        int max = 0;
       for(int data : piles){
         max = Math.max(max, data);
       }

       if(h == piles.length){  //it means at least one piles 
        //per one item is required
           return max;
       }

       int low = 0;
       int high = max;

       int speed = Integer.MAX_VALUE;
       while(low <= high){
           int sp = low + (high - low) / 2;
           if(pilesCanBeEaten(piles, sp, h) == true){
               speed = sp;
               high = sp - 1;
           }else{
               low = sp + 1;
           }
       }
       return speed;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]piles = new int[n];

        for(int i=0 ; i < n ; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();

        int speed = minEatingSpeed(piles,h);
        System.out.println(speed);
    }
}

