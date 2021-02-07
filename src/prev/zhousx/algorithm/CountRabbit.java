package prev.zhousx.algorithm;


import java.util.Scanner;

/**
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？
 *
 * 斐波那契数列，任一月的兔子数等于前两个月的和
 */
public class CountRabbit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int month = scanner.nextInt();
            System.out.println(getRabbitCount(month));
        }
    }

    private static int getRabbitCount(int month) {
        if (month < 3) {
            return 1;
        }
        return getRabbitCount(month - 2) + getRabbitCount(month -1);
    }
}
