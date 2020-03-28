package str;

import java.util.*;

/**
 * @author : zzh
 * create at:  2020/3/23
 * @description:路径简化
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<Object> stack = new Stack<>();
        String[] strs = path.split("/");
        for (String s : strs) {
            if (s.length() == 0 || s.equals("."))
                continue;
            if (s.equals("..") && stack.size() != 0) {
                stack.pop();
                stack.pop();
            }else {
                stack.push("/");
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString().length() == 0 ? "/" : sb.toString();
    }


    public String simplifyPath2(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
//        String s = "/home/";
//        String s = "/home//foo/";
//        String s = "/../";
//        String s = "/a/./b/../../c/";
//        String s = "/a/../../b/../c//.//";
        String s = "/a//b////c/d//././/..";
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath2(s));
    }

//    示例 1：
//
//    输入："/home/"
//    输出："/home"
//    解释：注意，最后一个目录名后面没有斜杠。
//    示例 2：
//
//    输入："/../"
//    输出："/"
//    解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
//    示例 3：
//
//    输入："/home//foo/"
//    输出："/home/foo"
//    解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
//    示例 4：
//
//    输入："/a/./b/../../c/"
//    输出："/c"
//    示例 5：
//
//    输入："/a/../../b/../c//.//"
//    输出："/c"
//    示例 6：
//
//    输入："/a//b////c/d//././/.."
//    输出："/a/b/c"
}
