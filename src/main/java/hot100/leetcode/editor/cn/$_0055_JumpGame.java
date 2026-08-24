package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 55: 跳跃游戏
 * RedmiBook, Fedora
 * 2026-08-24 13:49:28
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0055_JumpGame {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
//            if (n == 1) return true;
            int right = 0;
            for (int i = 0; i < n; i++) {
                if (right < i) return false;
                if (right >= n-1) return true;
                right = Math.max(right, nums[i] + i);
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神简洁写法
    class Solution1 {
        public boolean canJump(int[] nums) {
            int mx = 0;
            for (int i = 0; mx < nums.length - 1; i++) {
                if (i > mx) { // 无法到达 i
                    return false;
                }
                mx = Math.max(mx, i + nums[i]); // 从 i 最右可以跳到 i + nums[i]
            }
            return true;
        }
    }

    static void main() {
        Solution solution = new $_0055_JumpGame().new Solution();
        // put your test code here
        print(solution.canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
        print(solution.canJump(new int[]{2,0,0}));
        print(solution.canJump(new int[]{2,3,1,1,4}));
        print(solution.canJump(new int[]{3,2,1,0,4}));
    }
}