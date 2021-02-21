package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 */
public class Test12 {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        String s;
        int count=0;
        while ((s = bufferedReader.readLine()) != null ) {
            String[] tmp = s.split(" ");
            Integer key = Integer.valueOf(tmp[0]);
            Integer value = Integer.valueOf(tmp[1]);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
            count++;
            if (count == size) {
                break;
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
