package prev.zhousx.algorithm;

import java.util.Locale;
import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 */
public class Test16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase(Locale.ROOT);
        char ch = scanner.nextLine().toLowerCase(Locale.ROOT).charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
