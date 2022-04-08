/*


Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 
 1. You are given an array of Strings.
 2. You have to group all strings that belong to the same shifting sequence.
 3. A string is "shifted" when we change each letter of a string to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 "abc" -> "bcd" -> ... -> "xyz"
 4. For example:
 Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 Output: 
 [
   ["abc","bcd","xyz"],
   ["az","ba"],
   ["acef"],
   ["a","z"]
 ]
 5. main takes input a String array from the users.
 6. This is a functional problem. 
 7. You have to complete the groupStrings function. It takes as input a String array. It return a list of list of strings of strings with same shifting sequence grouped together.
 8. Don't change the code of main.
*/
    
        import java.util.*;
        public class groupShiftedString {
        
            private static String getStringCode(String str) {
                String code = "";
                for(int i = 1; i < str.length(); i++) {
                    char ch1 = str.charAt(i - 1);
                    char ch2 = str.charAt(i);
                    int val = (int)(ch2 - ch1);
                    if(val >= 0) {
                        code += val;
                    } else { 
                        code += (val + 26);
                    }
                    code += "#";
                }
                code += ".";
                return code;
            }
        
            public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
                HashMap<String, ArrayList<String>> map = new HashMap<>();
                
                for(String str : strs) {
                    String code = getStringCode(str);
                    if(map.containsKey(code) == true) {
                        map.get(code).add(str);
                    } else {
                        ArrayList<String> list = new ArrayList<>();
                        list.add(str);
                        map.put(code, list);
                    }
                }
        
                ArrayList<ArrayList<String>> res = new ArrayList<>();
                for(ArrayList<String> list : map.values()) {
                    res.add(list);
                }
                return res;
            }
        
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                String[] arr = new String[N];
                for (int i = 0; i < N; i++) {
                    arr[i] = sc.next();
                }
                ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
                for (ArrayList<String> lst : shiftedGroup) {
                    Collections.sort(lst);
                }
                shiftedGroup.sort(new ListComparator());
                display(shiftedGroup);
            }
        
            // it is used to make the result unique
            static class ListComparator implements Comparator<List<String>> {
                @Override
                public int compare(List<String> l1, List<String> l2) {
                    if (l1.size() != l2.size()) {
                        return l2.size() - l1.size();
                    }
        
                    String l1str = l1.get(0);
                    String l2str = l2.get(0);
                    return l1str.compareTo(l2str);
        
                }
            }
        
            public static void display(ArrayList<ArrayList<String>> list) {
                for (int i = 0; i < list.size(); i++) {
                    ArrayList<String> currList = list.get(i);
                    for (int j = 0; j < currList.size(); j++) {
                        System.out.print(currList.get(j) + " ");
                    }
                    System.out.println();
                }
            }
        
        }
        