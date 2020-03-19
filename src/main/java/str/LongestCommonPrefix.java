package str;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zzh
 * create at:  2020/3/19
 * @description:最长公共前缀
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1 || strs[0] == null || strs[0] == "") {
            return strs[0];
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : strs[0].toCharArray()) {
            queue.add(c);
        }
        for (int i = 1; i < strs.length; i++) {
            if (strs[i] == null || strs[i] == "") {
                return null;
            }
            Queue<Character> tempQ = new LinkedList<>();
            for (char c : strs[i].toCharArray()) {
                Character cc = queue.poll();
                if (cc == null || !cc.equals(c))
                    break;
                tempQ.add(c);
            }
            if (tempQ.size() > 0) {
                queue = tempQ;
            }
            else {
                queue.clear();
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }


    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String s = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(s) != 0) {
                s = s.substring(0, s.length() - 1);
            }
            i++;
        }
        return s;
    }

    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
        String[] strs = {"b", ""};


        LongestCommonPrefix demo = new LongestCommonPrefix();
        System.out.println(demo.longestCommonPrefix1(strs));
    }
}
