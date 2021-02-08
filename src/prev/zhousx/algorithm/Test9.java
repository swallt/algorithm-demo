package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 对字符串中的所有单词进行倒排。
 * 说明：
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * * 4、每个单词最长20个字母；
 */
public class Test9 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            int fast = s.length() - 1, slow = s.length() - 1;
            StringBuilder sb = new StringBuilder();
            while (fast >= 0) {
                char tmp = s.charAt(fast);
                if ((tmp >= 'a' && tmp <= 'z') || (tmp >= 'A' && tmp <= 'Z')) {
                    fast--;
                } else {
                    if (fast != slow) {
                        sb.append(s.substring(fast+1, slow+1)).append(" ");
                        slow = fast;
                    } else {
                        fast--;
                        slow--;
                    }
                }
            }
            if (fast != slow) {
                sb.append(s.substring(0, slow + 1)).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
