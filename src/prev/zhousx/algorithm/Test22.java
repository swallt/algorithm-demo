package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 处理过程：
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)
 * 结果 （10， -10）
 */
public class Test22 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int x = 0, y = 0;
        while ((s = bufferedReader.readLine()) != null) {
            String[] strings = s.split(";");
            for (String tmp : strings) {
                if (tmp.length() > 3) {
                    continue;
                }
                char direct = tmp.charAt(0);
                int value = 0;
                try {
                    value = Integer.parseInt(tmp.substring(1));
                } catch (Exception e) {
                    continue;
                }
                if ('A' == direct) {
                    x -= value;
                } else if ('D' == direct) {
                    x += value;
                } else if ('W' == direct) {
                    y += value;
                } else if ('S' == direct) {
                    y -= value;
                } else {
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
