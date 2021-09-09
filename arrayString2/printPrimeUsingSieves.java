 /*
 1. Given an Integer 'n'.
2. Print all primes from 2 to 'n'.
3. Portal is not forced you, but try to submit the 
problem in less than n.root(n) complexity.
 
input : 10

ouput: 
2 3 5 7 
 */
    
    import java.util.*;

    public class printPrimeUsingSieves {
        
        // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
        public static void printPrimeUsingSieve(int n) {
           boolean[] isPrime = new boolean[n + 1];
           Arrays.fill(isPrime, true);

           
          for(int i = 2; i * i <= n; i++){
              if(isPrime[i] == false){
                  //then i is not prime
                  continue;
              }
              for(int j = i + i; j <= n; j += i){
                  isPrime[j] = false;
              }
          }

          for(int i = 2; i <= n; i++){
              if(isPrime[i] == true){
                  System.out.print(i + " ");
              }
          }
        }
    
        // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
        public static void main(String[] args) {   
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            printPrimeUsingSieve(n);
        }
    }
