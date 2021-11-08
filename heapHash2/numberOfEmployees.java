
/*
1. You are given number N and 2*N number of strings that contains mapping
    of the employee and his manager.
2. An employee directly reports to only one manager. 
3. All managers are employees but the reverse is not true.
4. An employee reporting to himself is the CEO of the company.
5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.

Input Format
A number N
N number of lines, where each line contains 2 strings.

Output Format
Name of every employee and number of employees working under him.


Sample Input
6
A C
B C
C F
D E
E F
F F
Sample Output
A 0
B 0
C 2
D 0
E 1
F 5
*/


    import java.io.*;
    import java.util.*;
    
    public class numberOfEmployees {
    private static int getSize(HashMap<String, HashSet<String>> tree,
             String man, HashMap<String, Integer> res) {
            if(tree.containsKey(man) == false) {
                res.put(man, 0);
                return 1;
            }
            int count = 0;
            for(String emp : tree.get(man)) {
                count += getSize(tree, emp, res);
            }
            res.put(man, count);
            return count + 1;
        }
    

        //code written here 
        private static void printEmployeeManager(String[][] relations) {
            HashMap<String, HashSet<String>> tree = new HashMap<>();
            String ceo = "";
            for(String[] relation : relations) {
                String emp = relation[0];
                String man = relation[1];
    
                if(emp.equals(man) == true) {
                    ceo = man;
                    continue;
                }
                if(tree.containsKey(man) == true) {
                    tree.get(man).add(emp);
                } else {
                    HashSet<String> set = new HashSet<>();
                    set.add(emp);
                    tree.put(man, set);
                }
            }
    
            // travel on tree and get number of employees under every manager
            HashMap<String, Integer> res = new HashMap<>();
            getSize(tree, ceo, res);
           
            for(String str : res.keySet()) {
                System.out.println(str + " " + res.get(str));
            }
        }
      public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String[][] relations = new String[n][2];
    
            for(int i = 0; i < n; i++){
                relations[i][0] = sc.next();
                relations[i][1] = sc.next();
            }
    
            printEmployeeManager(relations);
    
    }}