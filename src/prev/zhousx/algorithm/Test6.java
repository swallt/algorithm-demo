package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 */
public class Test6 {

    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            char[] ch = s.toCharArray();
            char[] newChar = new char[ch.length];
            int j = 0;
            int start = 'a';
            while (start <= 'z') {
                for (int i = 0; i < ch.length; i++) {
                    if (ch[i] == start || ch[i]+32 == start) {
                        newChar[j++] = ch[i];
                    }
                }
                start++;
            }
            j = 0;
            for (int i = 0; i < ch.length; i++) {
                if ((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) {
                    ch[i] = newChar[j++];
                }
            }
            System.out.println(new String(ch));
        }
    }
}
