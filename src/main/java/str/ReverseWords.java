package str;

/**
 * @author : zzh
 * create at:  2020/3/23
 * @description:翻转字符串里的单词
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";
        String[] strs = s.split(" ");
        if (strs == null || strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].length() > 0) {
                sb.append(strs[i]).append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
//        String s = "the sky is blue";
//        String s = "  hello world!  ";
        String s = "a good   example";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(s));
    }

//    输入: "the sky is blue"
//    输出: "blue is sky the"
//    示例 2：
//
//    输入: "  hello world!  "
//    输出: "world! hello"
//    解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//    示例 3：
//
//    输入: "a good   example"
//    输出: "example good a"
//    解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
}
