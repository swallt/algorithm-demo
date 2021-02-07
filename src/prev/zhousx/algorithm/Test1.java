package prev.zhousx.algorithm;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 */
public class Test1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.startsWith("0x")) {
                char[] chars = str.substring(2).toCharArray();
                int result = 0;
                for (int i = 0; i < chars.length; i++) {
                    int pow = chars.length - 1 - i;
                    int value;
                    if (chars[i] >= 'a' && chars[i] <= 'f') {
                        // a == 97
                        value = chars[i] - 87;
                    } else if (chars[i] >= 'A' && chars[i] <= 'F') {
                        // A == 65
                        value = chars[i] - 55;
                    } else {
                        value = chars[i] - 48;
                    }

                    int tmpResult = value;
                    while (pow > 0) {
                        tmpResult *= 16;
                        pow--;
                    }
                    result += tmpResult;
                }
                System.out.println(result);
            }
        }
    }
}
