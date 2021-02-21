package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 */
public class Test19 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            long num = (long) Double.parseDouble(s);
            int i = Integer.parseInt(s.substring(s.indexOf(".") + 1, s.indexOf(".") + 2));
            if (i < 5) {
                System.out.println(num);
            } else {
                System.out.println(num+ 1);
            }
        }
    }
}
