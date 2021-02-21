package prev.zhousx.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Test24 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            int[] nums = getNums(s);
            int result = Integer.MAX_VALUE;
            String coord = null;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int tmp = Math.abs(nums[i] + nums[j]);
                    if (result > tmp) {
                        result = tmp;
                        coord = nums[i] < nums[j] ? nums[i] + " " + nums[j] : nums[j] + " " + nums[i];
                    }
                }
            }
            System.out.println(coord + " " + result);
        }
    }

    private static int[] getNums(String s) {
        String[] tmp = s.split(" ");
        int[] result = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            result[i] = Integer.parseInt(tmp[i]);
        }
        return result;
    }
}
