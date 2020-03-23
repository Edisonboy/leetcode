package str;

/**
 * @author : zzh
 * create at:  2020/3/22
 * @description:字符串相乘
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = pos[p2] + mul;

                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(p == 0 && sb.length() == 0))
                sb.append(p);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        String a = "9";
        String b = "99";
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply(a, b));
    }
}
