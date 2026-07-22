package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-22 22:46:37
 * Lenovo, Win11
 */
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0015_三数之和 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            if (nums[n-1] < 0) return ans;
            for (int i = 0; i < n; i++) {
                //如果当前元素大于0，则跳过循环
                if (nums[i] > 0) break;
                //如果当前元素+最大的两个元素小于0，则跳过
                if (nums[i] + nums[n-1] + nums[n-2] < 0) continue;
                //跳过重复数字
                if (i > 0 && nums[i] == nums[i-1])continue;
                for (int l = i+1, r = n -1; l < r;) {
                    int sum = nums[i] + nums[l];
                    //较小的两个数相加大于0，则跳出循环
                    if (sum > 0) break;
                    while (r > l && (sum + nums[r]) > 0) r--;
                    if (r > l && sum + nums[r] == 0) ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    int tmp = nums[l];
					do l++;
					while (r > l && nums[l] == tmp);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

     /**
      * 灵神解法
      */
     class Solution1 {
         public List<List<Integer>> threeSum(int[] nums) {
             Arrays.sort(nums);
             List<List<Integer>> ans = new ArrayList<>();
             int n = nums.length;
             for (int i = 0; i < n - 2; i++) {
                 int x = nums[i];
                 if (i > 0 && x == nums[i - 1]) continue; // 跳过重复数字
                 if (x + nums[i + 1] + nums[i + 2] > 0) break; // 优化一
                 if (x + nums[n - 2] + nums[n - 1] < 0) continue; // 优化二
                 int j = i + 1;
                 int k = n - 1;
                 while (j < k) {
                     int s = x + nums[j] + nums[k];
                     if (s > 0) {
                         k--;
                     } else if (s < 0) {
                         j++;
                     } else { // 三数之和为 0
                         // j = i+1 表示刚开始双指针，此时 j 左边没有数字
                         // nums[j] != nums[j-1] 说明与上一轮循环的三元组不同
                         if (j == i + 1 || nums[j] != nums[j - 1]) {
                             ans.add(List.of(x, nums[j], nums[k]));
                         }
                         j++;
                         k--;
                     }
                 }
             }
             return ans;
         }
     }

    static void main() {
        Solution solution = new $_0015_三数之和().new Solution();
        // put your test code here
        print(solution.threeSum(new int[]{1,2,-2,-1}));
    }
}