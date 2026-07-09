package leetcode.lingshen.a_double_point_1;

import java.util.Arrays;

public class LeetCode0709 {
    static void main() {

    }

    static class Solution {
        public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
            boolean[] ans = new boolean[queries.length];
            if (n == 1) {
                Arrays.fill(ans, true);
                return ans;
            }
            int[] cnt = new int[n];
            for (int i = 1; i < n; i++) {
                if (nums[i] - nums[i-1] <= maxDiff) cnt[i] = cnt[i-1] == n ? i-1 : cnt[i-1];
                else cnt[i] = n;
            }
            for (int i = 0; i < queries.length; i++) {
                int u = queries[i][0], v = queries[i][1];
                ans[i] = u == v || Math.min(u, v) >= cnt[Math.max(u, v)];
            }
            return ans;
        }
    }
}
