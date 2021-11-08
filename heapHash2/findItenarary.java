
/*
1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
2. You have to find the itinerary in order using the given list of tickets.

Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.

input:

Chennai Banglore 
Bombay Delhi 
Goa Chennai 
Delhi Goa 

Sample Output
Bombay -> Delhi -> Goa -> Chennai -> Banglore.
*/
    import java.util.*;
    
    public class findItenarary {
        
        
        public static void findingRoute(HashMap<String, String> routes){
            
          HashMap<String, Boolean> map = new HashMap<>();
          for(String src : routes.keySet()){
              String dest = routes.get(src);
              
              //make every destination to false
              map.put(dest, false);
              
              //if the value is not in the map list add it with true
              if(map.containsKey(src) == false){
                 map.put(src, true); 
              }
          }
          
          String source = "";
          for(String city : map.keySet()){
              if(map.get(city) == true){
                 source = city;
                 break;
              }
          }

          while(true){
              if(routes.containsKey(source) == true){  //dest is present for this src
                System.out.print(source + " -> ");
                 source = routes.get(source);
              }else{
                System.out.print(source + ".");
                break;
              }
          }
          
        }
        
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int noofpairs_src_des = scn.nextInt();
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < noofpairs_src_des; i++) {
                String s1 = scn.next();
                String s2 = scn.next();
                map.put(s1, s2);	
            }
    
        
        findingRoute(map);
    
    
        }
    }
    
