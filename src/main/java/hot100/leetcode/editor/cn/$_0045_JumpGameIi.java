package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 45: 跳跃游戏 II
 * RedmiBook, Fedora
 * 2026-08-24 14:15:57
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0045_JumpGameIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int x = 0, n = nums.length;
            if (n == 1) return 0;
            int ans = 1;
            while (x + nums[x] < n-1) {
                //遍历最远的区间，比灵神的时间复杂度更高
                int prex = x, premx = nums[x];
                for (int i = prex; i <= prex + premx; i++) {
                    if (i + nums[i] >= x + nums[x]) {
                        x = i;
                    }
                }
                ans++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神思路
    class Solution1 {
        public int jump(int[] nums) {
            int ans = 0;
            int curEnd = 0; // 已建造的桥的右端点
            int nextEnd = 0; // 下一座桥的右端点的最大值
            for (int i = 0; i < nums.length - 1; i++) {
                // 遍历的过程中，记录下一座桥的最远点
                nextEnd = Math.max(nextEnd, i + nums[i]);
                if (i == curEnd) { // 无路可走，必须建桥
                    curEnd = nextEnd; // 建桥后，最远可以到达 nextEnd
                    ans++;
                }
            }
            return ans;
        }
    }
    
    static void main() {
        Solution solution = new $_0045_JumpGameIi().new Solution();
        // put your test code here
        print(solution.jump(new int[]{1,2,3}));
    }
}