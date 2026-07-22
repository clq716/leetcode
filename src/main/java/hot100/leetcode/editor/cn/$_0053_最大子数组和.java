package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-22 20:26:36
 * Lenovo, Win11
 */
public class $_0053_最大子数组和 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubArray(int[] nums) {
            int ans = Integer.MIN_VALUE, maxCurrent = 0;
            for (int num : nums) {
                maxCurrent = Math.max(num, maxCurrent + num);
                ans = Math.max(ans, maxCurrent);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0053_最大子数组和().new Solution();
        // put your test code here
        
    }
}