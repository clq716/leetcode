package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-22 22:16:14
 * Lenovo, Win11
 */
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0238_除了自身以外数组的乘积 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length, multiple = 1;
            int[] ans = new int[n];
            ans[n - 1] = 1;
            for (int i = n-1; i >= 1; i--) ans[i - 1] = ans[i] * nums[i];
            for (int i = 0; i < n; i++) {
                ans[i] = multiple * ans[i];
                multiple *= nums[i];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0238_除了自身以外数组的乘积().new Solution();
        // put your test code here
        print(solution.productExceptSelf(new int[]{1,2,3,4}));
    }
}