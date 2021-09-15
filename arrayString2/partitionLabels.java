import java.util.Scanner;

// leetcode 763

/*
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
Return a list of integers representing the size of these parts.

 

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]

*/
import java.util.*;
public class partitionLabels {
    public static List<Integer> partitionLabelss(String s) {
        // 1. Make hashmap of last occurence
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        // 2. solve using chaining technique
        List<Integer> res = new ArrayList<>();

        int prev = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            max = Math.max(max, map.get(ch));
            if(max == i) {
                res.add(i - prev + 1);
                prev = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Integer> res = partitionLabelss(str);
        System.out.println(res);

    }
}
