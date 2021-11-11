//https://practice.geeksforgeeks.org/problems/marks-of-pcm2529/1

/*
1. You are provided with marks of N students in Physics, Chemistry and Maths.
Perform the following 3 operations: 
a). Sort the students in Ascending order of their Physics marks.
b). Once this is done, sort the students having same marks in Physics in the descending order of their Chemistry marks.
c). Once this is also done, sort the students having same marks in Physics and Chemistry in the ascending order of their Maths marks.
2. Your task is to complete the function customSort() which takes  phy[],  chem[],  math[] . The function sorts the marks in the described order and the final changes should be made in the given arrays only.
*/


import java.util.*;
import java.io.*;

public class marksOfPcm {

    /*You have to complete the body of customSort function, 
    after sorting final changes should be made in given arrays only. */


    public static class students implements Comparable<students>{
     int phy;
     int Chem;
     int maths;

     public students(int phy, int chem, int maths){
         this.phy = phy;
         this.Chem = chem;
         this.maths = maths;
     }

     public int  compareTo(students o){
         if(this.phy == o.phy){
             //decision depends on chemistry
            
             if(this.Chem == o.Chem){
                 //decision depend on math  now
                 return this.maths - o.maths;
             }
             else{
                 //reverse of default behavior
                 return o.Chem - this.Chem;
             }
         }
         else{
             //default behavior
            return this.phy - o.phy;

         }
     }
    }

    public static void customSort(int[]phy,int[]chem,int[]math) {
        students[] arr = new students[phy.length];

        for(int i = 0; i < phy.length ; i++){
            arr[i] = new students(phy[i], chem[i], math[i]);
        }
     
        Arrays.sort(arr);

        for(int i = 0; i < phy.length ;i++){
            phy[i] = arr[i].phy;
            chem[i] = arr[i].Chem;
            math[i] = arr[i].maths;
        }

    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int N = scn.nextInt();

        int[]phy = new int[N];
        int[]chem = new int[N];
        int[]math = new int[N];

        for(int i=0; i < N;i++) {
            phy[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            chem[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            math[i] = scn.nextInt();
        }

        customSort(phy,chem,math);

        //output
        for(int i=0; i < N;i++) {
            System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
        }
    }
}