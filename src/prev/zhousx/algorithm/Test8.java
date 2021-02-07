package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，
 * 你能替Redraiment研究他最多走的步数吗？
 */
public class Test8 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bufferedReader.readLine();
            int[] ints = new int[Integer.valueOf(s)];
            int index = 0;
            while ((s = bufferedReader.readLine()) != null) {
                ints[index++] = Integer.valueOf(s);
                if (index == ints.length) {
                    break;
                }
            }


        }
    }
}
