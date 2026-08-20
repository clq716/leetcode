package daily.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 3069: 将元素分配到两个数组中 I
 * RedmiBook, Fedora
 * 2026-08-20 20:03:49
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_3069_DistributeElementsIntoTwoArraysI {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] resultArray(int[] nums) {
            int n = nums.length, l = 1, r = 1;;
            int[] arr = new int[n];
            arr[0] = nums[1];
            for (int i = 2; i < n; i++) {
                if (nums[l-1] > arr[r-1]) nums[l++] = nums[i];
                else arr[r++] = nums[i];
            }
            System.arraycopy(arr, 0, nums, l, r);
            return nums;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_3069_DistributeElementsIntoTwoArraysI().new Solution();
        // put your test code here
        print(solution.resultArray(new int[]{2,1,3}));
    }
}