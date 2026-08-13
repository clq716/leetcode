package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 78: 子集
 * RedmiBook, Fedora
 * 2026-08-13 14:45:20
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0078_Subsets {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(nums, 0, nums.length, ans, new ArrayList<>());
            return ans;
        }

        private void dfs(int[] nums, int i, int n, List<List<Integer>> ans, List<Integer> list) {
            ans.add(list);
            for (; i < n; i++) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(nums[i]);
                dfs(nums, i + 1, n, ans, tmp);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神选或不选的方式，灵神喜欢在更新结果的时候复制数组
    class Solution1 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(0, nums, path, ans);
            return ans;
        }

        // 枚举选哪个：在下标 i 到 n-1 中选一个数，加到 path 末尾
        private void dfs(int i, int[] nums, List<Integer> path, List<List<Integer>> ans) {
            ans.add(new ArrayList<>(path)); // 不选，把当前子集加入答案
            for (int j = i; j < nums.length; j++) { // 选，枚举选择的数字
                path.add(nums[j]);
                dfs(j + 1, nums, path, ans); // 选 nums[j] 意味着 i 到 j-1 都跳过不选，下一个数从 j+1 开始选
                path.removeLast(); // path.remove(path.size() - 1);
            }
        }
    }

    //灵神选或不选的思路
    class Solution3 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(0, nums, path, ans);
            return ans;
        }

        // 选或不选：讨论 nums[i] 是否加入 path
        private void dfs(int i, int[] nums, List<Integer> path, List<List<Integer>> ans) {
            if (i == nums.length) { // 子集构造完毕
                ans.add(new ArrayList<>(path)); // 复制 path
                return;
            }

            // 不选 nums[i]
            dfs(i + 1, nums, path, ans); // 考虑下一个数 nums[i+1] 选或不选

            // 选 nums[i]
            path.add(nums[i]);
            dfs(i + 1, nums, path, ans); // 考虑下一个数 nums[i+1] 选或不选
            path.removeLast(); // path.remove(path.size() - 1);
        }
    }

    //二进制枚举+位运算，本体长度小于等于10, 可以用这种技巧，没看懂
    class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>(1 << n); // 预分配空间
            for (int i = 0; i < (1 << n); i++) { // 枚举全集 U 的所有子集 i
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if ((i >> j & 1) == 1) { // j 在集合 i 中
                        subset.add(nums[j]);
                    }
                }
                ans.add(subset);
            }
            return ans;
        }
    }

    static void main() {
        Solution solution = new $_0078_Subsets().new Solution();
        // put your test code here
        
    }
}