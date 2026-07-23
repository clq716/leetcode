package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-23 11:06:20
 * RedmiBook, Fedora
 */
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0042_接雨水 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            //结果, 累计值, 最大值
            int ans = 0, sum = 0, max = 0, n = height.length;
            //从左到右遍历
            for (int h : height) {
                if (h >= max) {
                    //更新最大值，更新结果，重置累计值
                    max = h;
                    ans += sum;
                    sum = 0;
                } else {
                    sum += (max - h);
                }
            }
            sum = 0;
            max = 0;
            //从右向左遍历
            for (int i = n-1; i >= 0; i--) {
                int h = height[i];
                //注意是大于，大于等于的从左到右遍历过了
                if (h > max) {
                    //更新最大值，更新结果，重置累计值
                    max = h;
                    ans += sum;
                    sum = 0;
                } else {
                    sum += (max - h);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

     /**
      * 灵神的相向双指针，只用了一次遍历
      */
     class Solution1 {
         public int trap(int[] height) {
             int ans = 0;
             int preMax = 0; // 前缀最大值，随着左指针 left 的移动而更新
             int sufMax = 0; // 后缀最大值，随着右指针 right 的移动而更新
             int left = 0;
             int right = height.length - 1;

             while (left < right) {
                 preMax = Math.max(preMax, height[left]);
                 sufMax = Math.max(sufMax, height[right]);
                 if (preMax < sufMax) { // 可以确定 left 处的接水量
                     ans += preMax - height[left];
                     left++; // 搞定了 left，现在问题缩小到 [left+1, right]
                 } else { // 可以确定 right 处的接水量
                     ans += sufMax - height[right];
                     right--; // 搞定了 right，现在问题缩小到 [left, right-1]
                 }
             }

             return ans;
         }
     }

    static void main() {
        Solution solution = new $_0042_接雨水().new Solution();
        // put your test code here
        
    }
}