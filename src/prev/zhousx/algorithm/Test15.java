package prev.zhousx.algorithm;

import java.util.Scanner;

/**
 * 计算最后一个单词的字符长度
 */
public class Test15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int lastIndex = s.lastIndexOf(" ");
        if (lastIndex > 0) {
            System.out.println(s.length() - 1 - lastIndex);
        } else {
            System.out.println(s.length());
        }
//        while ((s = scanner.nextLine()) != null) {
//            int lastIndex = s.lastIndexOf(" ");
//            if (lastIndex > 0) {
//                System.out.println(s.length() - 1 - lastIndex);
//            } else {
//                System.out.println(s.length());
//            }
//        }
    }
}
