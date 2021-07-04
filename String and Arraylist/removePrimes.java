
//this is arraylist problems

// here in this problems we need to remove the elements from the last index
//primes number are 2,3,5,7,9,------
import java.io.*;
import java.util.*;

public class removePrimes {
    public static boolean isprime(int val){
        for(int i = 2;i*i<=val;i++){
            if(val%i == 0){
                return false;
            }
        }
        return true;
    }
	public static void solution(ArrayList<Integer> al){
		int len = al.size()-1;
        for(int i = len;i>=0;i--){
            if(isprime(al.get(i))){
                al.remove(i);
            }
        }
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}

}