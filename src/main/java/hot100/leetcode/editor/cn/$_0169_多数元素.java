package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-22 16:35:36
 * RedmiBook, Fedora
 */
public class $_0169_多数元素 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 最简单的方式当然是分组统计个数，但因为限定空间复杂度为O(1)，所以不能这么做
         * 因为刚完成一个利用亦或特质的题，所以这个还是下意识使用位运算技巧
         * 统计每一位的bit数为 0 还是 1，众数每一位上的 0 和 1 一定是最多的
         * 其实还是笨方法，对于数组循环没有灵神那种巧妙的理解
         */
        public int majorityElement(int[] nums) {
            int[] cnt = new int[32];
            for (int num : nums) {
                for (int i = 31; i >= 0; i--) {
                    if ((num >> i & 1) == 1) {
                        cnt[31-i]++;
                    } else {
                        cnt[31-i]--;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if (cnt[i] > 0) {
                    ans += 1 << (31-i);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

     /**
      * 灵神的算法很巧妙，相异的数字相互抵消，哪怕小众都和众数一一抵消，剩下的依然是众数
      */
     class Solution1 {
         public int majorityElement(int[] nums) {
             int ans = 0;
             int hp = 0;
             for (int x : nums) {
                 if (hp == 0) { // x 是初始擂主，生命值为 1
                     ans = x;
                     hp = 1;
                 } else { // 比武，同门加血，否则扣血
                     hp += x == ans ? 1 : -1;
                 }
             }
             return ans;
         }
     }

    static void main() {
        Solution solution = new $_0169_多数元素().new Solution();
        // put your test code here
        print(solution.majorityElement(new int[]{3,2,3}));
    }
}