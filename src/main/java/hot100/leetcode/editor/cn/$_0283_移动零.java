package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-21 22:53:32
 * Lenovo, Win11
 */
public class $_0283_移动零 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int l = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[l] = nums[i];
                    l++;
                }
            }
            Arrays.fill(nums, l, nums.length, 0);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


     /**
      * 灵神做法1，和我的类似，但是他想到的是用栈的思想
      */
     class Solution1 {
         public void moveZeroes(int[] nums) {
             int stackSize = 0;
             for (int x : nums) {
                 if (x != 0) {
                     nums[stackSize++] = x; // 把 x 入栈
                 }
             }
             Arrays.fill(nums, stackSize, nums.length, 0);
         }
     }

     /**
      * 灵神做法2，比较绕，但是能保证1次便利
      * 保证 [i0 ,i−1] 对应的元素值全为 0，并通过交换 为0的 i0 和 非0 的 i, 向右滑动这个全为0的窗口
      */
     class Solution2 {
         public void moveZeroes(int[] nums) {
             int i0 = 0;
             for (int i = 0; i < nums.length; i++) {
                 if (nums[i] != 0) {
                     // 交换 nums[i] 和 nums[i0]
                     int tmp = nums[i];
                     nums[i] = nums[i0];
                     nums[i0] = tmp;
                     i0++;
                 }
             }
         }
     }

    static void main() {
        Solution solution = new $_0283_移动零().new Solution();
        // put your test code here
        int[] arr = new int[]{0,1,0,3,12};
        solution.moveZeroes(arr);
        print(arr);
    }
}