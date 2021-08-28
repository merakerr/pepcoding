//Implementation of hashmap functions

import java.util.*;




class hashmap{
    private class Node{
        String key;
        int value;


        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int size = 0;
    private LinkedList<Node>[] bucket;


    private void init(int cap){
       bucket = new LinkedList[cap];
      
       for(int i = 0; i < cap; i++){
           bucket[i] = new LinkedList<>();
       }

       this.size = 0;
    }
    //constructor
    public hashmap(){
        init(4);
    }

    private int  hashFunction(String key){
      int bi = Math.abs(key.hashCode()) % bucket.length;
      /*
      The hashCode method is an inbuilt method that returns the integer 
      hashed value of the input value.
      */
      return bi;
    }

    private int searchBucket(String key, int bi){
        int di = 0;
        for(Node node : bucket[bi]){
           
            if(node.key.equals(key) == true){
                return di;
            }
            di++;
        }

        // for(int i = 0; i < bucket[bi].size(); i++){   //another way
        //     Node node = bucket[bi].get(i);
        //     if(node.key.equals(key) == true){
        //         return i;
        //     }
        // }
        return -1;
    }

    private void rehash() {
        LinkedList<Node>[] ob = bucket;
        init(2 * bucket.length);

        // travel on old bucket and fill it int bucket
        for(int i = 0; i < ob.length; i++) {
            for(Node node : ob[i]) {
                put(node.key, node.value);
            }
        }
    }

    public void put(String key, int value){
        int bi =  hashFunction(key);    //bucket index

        //check if it is present or not
        int di = searchBucket(key, bi);

        if(di == -1){
            //not present
            bucket[bi].addLast(new Node(key, value));
            size++;
        }else{
            //else present
            bucket[bi].get(di).value = value;
        }

        int n = size;
        int N = bucket.length;
        double lambda = n*1.0 / N;
        if(lambda > 2){
            rehash();
        }
    }
    public int remove(String key){
     int bi = hashFunction(key);
     int di = searchBucket(key, bi);
     if(di == -1){
         return -1;
     }else{
       //remove node in linked list
        Node rem = bucket[bi].remove(di);
        size--;
       //retun value

       return rem.value;
     }
    }
    public int get(String key){
       int bi = hashFunction(key);
       int di = searchBucket(key, bi);
       if(di == -1){
           return -1;
       }
       else{
           Node found = bucket[bi].get(di);
           return found.value;
       }
    }
    public boolean containsKey(String key){
        int bi = hashFunction(key);
        int di = searchBucket(key, bi);
        if(di == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public ArrayList<String> keySet(){
     ArrayList<String> list = new ArrayList<>();
     for(int bi = 0; bi < bucket.length; bi++){
         for(Node node : bucket[bi]){
             list.add(node.key);
         }
     }
     return list;
    }
    public int size(){
        return this.size;
    }

    public void display(){
        for(int bi = 0; bi < bucket.length; bi++){
            for(Node node : bucket[bi]){
                System.out.println("["+node.key+"="+node.value+"],");
            }
        }
        System.out.println(".");
    }

    public void hashMapView(){
        for(int bi = 0; bi < bucket.length; bi++){
            System.out.print("bucket "+bi+"-->");
            for(Node node : bucket[bi]){
                System.out.println("["+node.key+"="+node.value+"],");
            }
            System.out.println(".");    
        }
       
    }
    
}


public class hashmapCreation {

  public static void fun(){
      hashmap map = new hashmap();
      map.put("india", 125);
      map.put("Nepal", 120);
      map.put("sri lanka", 145);
      map.put("bhutan", 1455);
      map.put("malasia", 1125);
      map.display();;
      map.hashMapView();
  }

    public static void main(String[] args) {
        fun();
    }
}
