package daily.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 3471: 找出最大的几近缺失整数
 * RedmiBook, Fedora
 * 2026-08-18 09:40:18
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_3471_FindTheLargestAlmostMissingInteger {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestInteger(int[] nums, int k) {
            int n = nums.length, first = nums[0], last = nums[n-1];
            if (n == 1) return first;
            if (k == n) {
                int max = 0;
                for (int num : nums) max = Math.max(max, num);
                return max;
            }
            if (k == 1) {
                Arrays.sort(nums);
                for (int i = n-1; i >=0; i--) {
                    int p = i;
                    while (i > 0 && nums[i] == nums[i-1]) i--;
                    if (p == i) return nums[i];
                }
                return -1;
            }
            if (first == last) return -1;
            for (int i = 1; i < n-1; i++) {
                if (first != -1 && nums[i] == first) first = -1;
                if (last != -1 && nums[i] == last) last = -1;
                if (first == last) return -1;
            }
            return Math.max(first, last);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_3471_FindTheLargestAlmostMissingInteger().new Solution();
        // put your test code here
        print(solution.largestInteger(new int[]{7,5,9,10,0,12,3,12,10}, 1));
    }
}