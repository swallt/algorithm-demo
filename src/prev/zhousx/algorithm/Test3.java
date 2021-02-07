package prev.zhousx.algorithm;

import java.util.Scanner;

/**
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。
 * 不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            int[] bitmap = new int[128];
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (bitmap[chars[i]] == 0) {
                    bitmap[chars[i]] = 1;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
