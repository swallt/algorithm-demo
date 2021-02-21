package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class Test18 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                if (sb.length() == 8) {
                    System.out.println(sb.toString());
                    sb.replace(0, 8, "");
                }
            }
            if (sb.length() != 0) {
                int limit = 8 - sb.length();
                for (int i = 0; i < limit; i++) {
                    sb.append("0");
                }
                System.out.println(sb.toString());
            }
        }
    }
}
