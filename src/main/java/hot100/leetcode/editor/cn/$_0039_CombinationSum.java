package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 39: 组合总和
 * RedmiBook, Fedora
 * 2026-08-13 15:48:07
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0039_CombinationSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, new ArrayDeque<>(), 0, target, candidates);
            return ans;
        }

        //可重复选取怎样保证结果不同呢？
        private void dfs(List<List<Integer>> ans, Deque<Integer> path, int i, int target, int[] candidates) {
            if (target < 0) {
                return;
            }
            if (0 == target) {
                ans.add(new ArrayList<>(path));
                return;
            }
            if (i == candidates.length) return;
            for (; i < candidates.length; i++) {
                int candidate = candidates[i];
                target -= candidate;
                path.offer(candidate);
                dfs(ans, path, i, target, candidates);
                path.removeLast();
                target += candidate;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神写法，dfs内部没有用循环
    class Solution1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(0, target, candidates, ans, path);
            return ans;
        }

        private void dfs(int i, int left, int[] candidates, List<List<Integer>> ans, List<Integer> path) {
            if (left == 0) {
                // 找到一个合法组合
                ans.add(new ArrayList<>(path));
                return;
            }

            if (i == candidates.length || left < 0) {
                return;
            }

            // 不选
            dfs(i + 1, left, candidates, ans, path);

            // 选
            path.add(candidates[i]);
            dfs(i, left - candidates[i], candidates, ans, path);
            path.removeLast(); // 恢复现场
        }
    }

    //灵神写法二，也就是我的写法，但更简洁
    class Solution2 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(0, target, candidates, ans, path);
            return ans;
        }

        private void dfs(int i, int left, int[] candidates, List<List<Integer>> ans, List<Integer> path) {
            if (left == 0) {
                // 找到一个合法组合
                ans.add(new ArrayList<>(path));
                return;
            }

            // 枚举选哪个
            for (int j = i; j < candidates.length && candidates[j] <= left; j++) {
                path.add(candidates[j]);
                dfs(j, left - candidates[j], candidates, ans, path);
                path.removeLast(); // 恢复现场
            }
        }
    }

    static void main() {
        Solution solution = new $_0039_CombinationSum().new Solution();
        // put your test code here
        print(solution.combinationSum(new int[]{8,7,4,3}, 11));//[[8,3],[7,4],[4,4,3]]
        print(solution.combinationSum(new int[]{3,5,7}, 8));
        print(solution.combinationSum(new int[]{2,3}, 10));
        print(solution.combinationSum(new int[]{2,3,6,7}, 7));
        print(solution.combinationSum(new int[]{2,3,5}, 8));
        print(solution.combinationSum(new int[]{2}, 1));
    }
}