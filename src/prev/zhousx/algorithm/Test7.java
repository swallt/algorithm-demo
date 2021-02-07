package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * 请注意本题含有多组样例输入。
 */
public class Test7 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            int num = Integer.valueOf(s);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num; i++) {
                int start = i * (i + 1) / 2 + 1;
                int step = i + 2;
                for (int j = 0; j < num - i; j++) {
                    sb.append(start).append(" ");
                    start += step;
                    step++;
                }
                sb.setCharAt(sb.length() - 1, '\n');
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
