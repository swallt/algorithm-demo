package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Test26 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        int[][] servers = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                servers[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (servers[i][j] == 1) {
                    Map<String, Object> existsMap = new HashMap<>();
                    maxCount = Math.max(maxCount, getCount(servers, i, j, 1, existsMap));
                }
            }
        }
        System.out.println(maxCount);
    }

    private static int getCount(int[][] servers, int i, int j, int count, Map<String,Object> existsMap) {
        if (servers[i][j] == 0) {
            return 0;
        }
        String key = i + "-" + j;
        if (existsMap.containsKey(key)) {
            return 0;
        }
        existsMap.put(key, null);
        int maxI = servers.length, maxJ = servers[0].length;
        if (i - 1 >= 0 && servers[i-1][j] == 1) {
            count += getCount(servers, i - 1, j, count, existsMap);
        } else if (i + 1 < maxI && servers[i + 1][j] == 1) {
            count += getCount(servers, i + 1, j, count, existsMap);
        } else if (j - 1 >= 0 && servers[i][j - 1] == 1) {
            count += getCount(servers, i, j - 1, count, existsMap);
        } else if (j + 1 < maxJ && servers[i][j + 1] == 1) {
            count += getCount(servers, i, j + 1, count, existsMap);
        } else {
            count = 1;
        }
        return count;
    }
}
