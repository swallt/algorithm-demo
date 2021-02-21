package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 选手编号 1-N 3<= N <=100
 * 评委  3<=M<=10
 * 分数为整形1-10
 * <p>
 * 输入异常则输出-1
 */
public class Test25 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            String[] tmp = s.split(",");
            int m = Integer.parseInt(tmp[0]);
            int n = Integer.parseInt(tmp[1]);
            String[] scores = new String[m];
            for (int i = 0; i < m; i++) {
                scores[i] = bufferedReader.readLine();
            }
            //校验M、N
            if (checkMN(m, n)) {
                System.out.println("-1");
                continue;
            }

            int[][] numScoreBitMap = new int[n][11];
            boolean scoreCheck = true;
            try {
                dealInputToBitMap(scores,n,numScoreBitMap);
            } catch (RuntimeException e) {
                scoreCheck = false;
            }
            if (scoreCheck) {
                TreeMap<Integer, List<Integer>> scoreMap = new TreeMap<>();
                for (int i = 0; i < n; i++) {
                    int tmpScore = 0;
                    for (int j = 1; j <= 10; j++) {
                        tmpScore += j * numScoreBitMap[i][j];
                    }
                    if (scoreMap.containsKey(tmpScore)) {
                        scoreMap.get(tmpScore).add(i);
                    } else {
                        List<Integer> list = new LinkedList<>();
                        list.add(i);
                        scoreMap.put(tmpScore, list);
                    }
                }
                AtomicInteger max = new AtomicInteger(3);
                List<Integer> rankList = new LinkedList<>();
                scoreMap.forEach((key, value) -> {
                    List list = (List) value;
                    if (list.size() == 1 && max.get() > 0) {
                        rankList.addAll(list);
                        max.addAndGet(-list.size());
                    } else if (list.size() == 2 && max.get() > 0) {
                        max.addAndGet(-list.size());
                        getRank(rankList, numScoreBitMap, (int)list.get(0), (int)list.get(1));
                    }
                });

                StringBuilder stringBuilder = new StringBuilder();
                for (int i : rankList) {
                    stringBuilder.append(i).append(",");
                }
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                System.out.println(stringBuilder.toString());
            } else {
                System.out.println("-1");
            }
        }
    }

    private static void getRank(List<Integer> rankList, int[][] numScoreBitMap, int i, int j) {
        boolean flag = false;
        for (int index = 10; index <= 0; index--) {
            if (numScoreBitMap[i][index] > numScoreBitMap[j][index]) {
                flag = true;
                break;
            } else if (numScoreBitMap[i][index] < numScoreBitMap[j][index]) {
                flag = false;
                break;
            } else {
            }
        }
        if (flag) {
            rankList.add(i);
            rankList.add(j);
        } else {
            rankList.add(j);
            rankList.add(i);
        }
    }

    private static void dealInputToBitMap(String[] scores,int n,int[][] bitmap) throws RuntimeException {
        for (int i = 0; i < scores.length; i++) {
            String[] tmp = scores[i].split(",");
            for (int j = 0; j < tmp.length; j++) {
                int value = Integer.parseInt(tmp[j]);
                if (value < 1 || value > 10) {
                    throw new RuntimeException("wrong score");
                }
                bitmap[j][value] = bitmap[j][value]+1;
            }
        }
    }

    private static boolean checkMN(int m, int n) {
        if (n < 3 || n > 100) {
            return true;
        }
        if (m < 3 || m > 10) {
            return true;
        }
        return false;
    }
}
