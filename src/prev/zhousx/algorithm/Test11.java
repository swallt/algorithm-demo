package prev.zhousx.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 */
public class Test11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long k = (long) Math.sqrt(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= k; i++) {
            while (num % i == 0) {
                sb.append(i).append(" ");
                num /= i;
            }
        }
        if (num != 1) {
            sb.append(num).append(" ");
        }
        System.out.print(sb.toString());
    }
}
