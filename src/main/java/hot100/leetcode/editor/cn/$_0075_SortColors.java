package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
/**
 * 75: 颜色分类
 * RedmiBook, Fedora
 * 2026-07-28 11:04:17
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0075_SortColors {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * - 滑动窗口 (l, r) + 交换元素
     */
    class Solution {
        public void sortColors(int[] nums) {
            //l: 左端点, r: 右端点, i: 当前遍历
            int n = nums.length, l = 0, r = n - 1, i = 0;
            //遍历到右端点时停止
            while (i <= r) {
                if (nums[i] == 2) {
                    //遍历节点为2, 交换到右端点， 右端点左移
                    swap(nums, i, r);
                    r--;
                } else if (nums[i] == 0) {
                    //遍历节点为0, 交换到左端点, 左端点和当前节点右移
                    swap(nums, i, l);
                    l++;
                    i++;
                } else {
                    //遍历节点为1, 则继续遍历
                    i++;
                }
            }
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 灵神解法用的是替换的思想, 记录(或者说计数)0和1 的数量
     * 先更新2, 再更新1, 最后更新0
     */
    class Solution1 {
        public void sortColors(int[] nums) {
            int p0 = 0;
            int p1 = 0;
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                nums[i] = 2;
                if (x <= 1) {
                    nums[p1++] = 1;
                }
                if (x == 0) {
                    nums[p0++] = 0;
                }
            }
        }
    }
    
    static void main() {
        Solution solution = new $_0075_SortColors().new Solution();
        // put your test code here
//        int[] nums = new int[]{2,0,2,1,1,0};
        int[] nums = new int[]{1,2,0};
        solution.sortColors(nums);
        print(nums);
    }
}