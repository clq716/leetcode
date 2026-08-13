package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 46: 全排列
 * RedmiBook, Fedora
 * 2026-08-13 14:21:14
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0046_Permutations {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            boolean[] walked = new boolean[nums.length];
            dfs(nums, walked, nums.length, new ArrayList<>(nums.length));
            return ans;
        }

        private void dfs(int[] nums, boolean[] walked, int n, List<Integer> list) {
            if (list.size() == n) {
                ans.add(list);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (walked[i]) continue;
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(nums[i]);
                walked[i] = true;
                dfs(nums, walked, n, tmp);
                walked[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    //灵神解法，是在最后判断时候用的new ArrayList，初始化长度为n填充0的列表，基于set而不是add方法来赋值列表
    class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            int n = nums.length;
            //创建了长度为n,元素都是0的列表
            List<Integer> path = Arrays.asList(new Integer[n]); // 所有排列的长度都是一样的 n
            boolean[] onPath = new boolean[n];
            List<List<Integer>> ans = new ArrayList<>();

            dfs(0, nums, ans, path, onPath);
            return ans;
        }

        // 枚举 path[i] 填 nums 的哪个数
        private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] onPath) {
            if (i == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int j = 0; j < nums.length; j++) {
                if (!onPath[j]) {
                    path.set(i, nums[j]); // 从没有选的数字中选一个
                    onPath[j] = true; // 已选上
                    dfs(i + 1, nums, ans, path, onPath);
                    onPath[j] = false; // 恢复现场
                    // 注意 path 无需恢复现场，因为排列长度固定，直接覆盖就行
                }
            }
        }
    }

    static void main() {
        Solution solution = new $_0046_Permutations().new Solution();
        // put your test code here
        print(solution.permute(new int[]{1,2,3}));
    }
}