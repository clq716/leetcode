package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 209: 长度最小的子数组
 * RedmiBook, Fedora
 * 2026-08-27 16:15:48
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0209_MinimumSizeSubarraySum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            //不定长滑动窗口
            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            int sum = 0;
            for (int l = 0, r = 0; r < n; r++) {
                //向右扩大窗口
                sum += nums[r];
                //没有答案，继续滑动
                if (sum < target) {
                    continue;
                }
                //进行比较
                while (sum >= target) {
                    //向右缩小窗口
                    sum -= nums[l];
                    l++;
                }
                //更新答案
                ans = Math.min(ans, r-l+2);
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0209_MinimumSizeSubarraySum().new Solution();
        // put your test code here
        print(solution.minSubArrayLen(11, new int[]{1,2,3,4,5}));
        print(solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}