import java.io.*;
import java.util.*;

public class gss {
  public static ArrayList<String> getSS(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String roq = str.substring(1); // roq => rest of question

        ArrayList<String> rres = getSS(roq);
        ArrayList<String> mres = new ArrayList<>();
        // add with -
        //bc res printing as it 
        /*bc -->> '','c','b','bc' */
        for (String s : rres) {
            mres.add(s);
        }
        // appending a with the res
        /*bc -->> '','c','b','bc' meh append a get get
        '','c','b','bc','a','ac','ab','abc' */
        for (String s : rres) {
            mres.add(ch + s);
        }

        return mres;
    }

    public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine();
      ArrayList<String> strs = getSS(str);
      System.out.println(strs);
    }

  
}