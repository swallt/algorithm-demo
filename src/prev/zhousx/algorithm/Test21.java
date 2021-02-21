package prev.zhousx.algorithm;

import java.util.Scanner;

/**
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 */
public class Test21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        if (n == 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < 32; i++) {
                if ((n>>i & 0x1) == 1) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
