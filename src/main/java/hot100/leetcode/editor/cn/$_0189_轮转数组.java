package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-22 21:20:48
 * Lenovo, Win11
 */
@SuppressWarnings("PrimitiveArrayArgumentToVarargsMethod")
public class $_0189_轮转数组 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            reverse(nums, 0, n-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, n-1);
        }

        private void reverse(int[] nums, int start, int end) {
            int tmp;
            for (int l = start, r = end; l < r; l++, r--) {
                tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0189_轮转数组().new Solution();
        // put your test code here
        int[] arr = new int[]{1,2,3,4,5,6,7};
        solution.rotate(arr, 3);
        print(arr);
    }
}