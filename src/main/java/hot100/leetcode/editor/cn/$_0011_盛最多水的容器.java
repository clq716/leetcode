package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-23 10:15:22
 * RedmiBook, Fedora
 */
 @SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
 public class $_0011_盛最多水的容器 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            //双向双指针
            int n = height.length, ans = 0, l = 0, r = n - 1;
            while (l < r) {
                if (height[l] > height[r]) {
                    ans = Math.max(ans, height[r] * (r-l));
                    r--;
                } else {
                    ans = Math.max(ans, height[l] * (r-l));
                    l++;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0011_盛最多水的容器().new Solution();
        // put your test code here
        print(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}