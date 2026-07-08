package leetcode.lingshen.a_double_point_1;

import java.util.Arrays;

public class LeetCode0708 {
    static void main() {
        String s = "2711785625";
        int[][] queries = {{1,9}};

        int m = s.length(), MOD = 10_0000_0007;
        int[] preSum = new int[m + 1], cnt = new int[m + 1];
        long[] preMod = new long[m + 1], ten = new long[m+1];
        ten[0] = 1;
        for (int i = 0, j = 0; i < m; i++) {
            int c = s.charAt(i) - '0';
            if (c == 0) {
                cnt[i+1] = cnt[i];
                preSum[i+1] = preSum[i];
                preMod[i+1] = preMod[i];
            } else {
                cnt[i+1] = cnt[i] + 1;
                preSum[i + 1] = preSum[i] + c;
                preMod[i + 1] = ((preMod[i]*10L)%MOD + c) % MOD;
                ten[j + 1] = (ten[j] * 10L)%MOD;
                j++;
            }
        }
        int[] result = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int l = query[0], r = query[1];
            int sum = preSum[r+1] - preSum[l];
            long mod = preMod[r + 1] - preMod[l] * ten[cnt[r+1] - cnt[l]];
            mod %= MOD;
            if (mod < 0) mod += MOD;
            //mod = mod < 0 ? MOD + mod : mod % MOD;
            result[i++] = (int) ((mod * sum) % MOD);
        }
        //711785625
        System.out.println("894996047 = " + Arrays.toString(result));
    }
}
