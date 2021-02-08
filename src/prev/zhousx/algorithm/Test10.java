package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：
 * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。
 * 最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是”相同“的错误记录。
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 * 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
 */
public class Test10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s ;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while ((s = bufferedReader.readLine()) != null) {
            int idx1 = s.lastIndexOf(" ");
            int idx2 = s.lastIndexOf("\\");
            String key = idx1 - idx2 > 16 ? s.substring(idx1 - 16) : s.substring(idx2+1);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        for (String key : map.keySet()) {
            count++;
            if (count > (map.size() - 8)) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
