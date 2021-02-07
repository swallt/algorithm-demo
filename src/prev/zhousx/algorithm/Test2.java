package prev.zhousx.algorithm;

import java.util.Scanner;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            int[] bitmap = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            StringBuilder sb = new StringBuilder();
            for (int i = chars.length - 1; i >= 0; i--) {
                int value = chars[i] - 48;
                if (bitmap[value] == 0) {
                    sb.append(value);
                    bitmap[value] = 1;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
