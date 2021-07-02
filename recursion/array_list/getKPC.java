
    
    import java.io.*;
    import java.util.*;
    
    public class getKPC {
        public static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };
        public static ArrayList<String> getKPCs(String str) {
        if(str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        int indx = str.charAt(0) - '0';
        String roq = str.substring(1);
        String code = codes[indx];
        ArrayList<String> rres = getKPCs(roq);

        ArrayList<String> mres = new ArrayList<>();

        for(int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            for(String s : rres) {
                mres.add(ch + s);
            }
        }

        return mres;
    }
        public static void main(String[] args) throws Exception {
           Scanner sc = new Scanner(System.in);
           String str = sc.nextLine();
           ArrayList<String> res = getKPCs(str);
           System.out.println(res);

        }
    
        
    
    }
