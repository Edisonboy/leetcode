package str;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author : zzh
 * create at:  2020/3/24
 * @description:复原IP地址
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList();
        if(s.length() > 12) return list;

        helper(s, list, 0, "", 0);
        return list;
    }

    /**
     * DFS 深度优先遍历
     *
     * sec：分为4个区
     * 每个区最多3个数，所以每个区最深遍历次数是3
     *
     * 退出条件是：sec==4 && pos == s.length()
     * @param s
     * @param list
     * @param pos
     * @param res
     * @param sec
     */
    void helper(String s, List<String> list, int pos, String res, int sec){
        if(sec == 4 && pos == s.length()) {
            list.add(res);
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(pos + i > s.length())
                break;
            String section = s.substring(pos, pos + i);
            if(section.length() > 1 && section.startsWith("0") || Integer.parseInt(section) >= 256)
                break;
            helper(s, list, pos + i, sec == 0 ? section : res + "." + section, sec + 1);
        }
    }

    public static void main(String[] args) {

        RestoreIpAddresses demo = new RestoreIpAddresses();
        demo.restoreIpAddresses("25525511135");

        //Function<Integer,Integer> test1= i -> i + 1;
        //System.out.println(calculate(test1,5));
        List<String> list = calculate(12, i -> {
            System.out.println(i);
            return demo.restoreIpAddresses("");
        });

    }
    public static <T, R> R calculate(T param, Function<T, R> test){
        return test.apply(param);
    }
}