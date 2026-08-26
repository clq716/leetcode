package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 34: 在排序数组中查找元素的第一个和最后一个位置
 * RedmiBook, Fedora
 * 2026-08-26 22:06:01
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0034_FindFirstAndLastPositionOfElementInSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //套模板写法
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[]{-1, -1};
            int n = nums.length;
            int left = 0, l2 = left;
            int right = n - 1, r2 = right;
            while (left <= right || l2 <= r2) {
                if (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    //此处为大于时，left 是第一个等于target的位置，right = left-1，是最后一个小于target的位置
                    if (nums[mid] < target) left = mid + 1;
                    else right = mid - 1;
                }
                if (l2 <= r2) {
                    int m2 = l2 + ((r2-l2) >> 1);
                    //此处为大于等于是，left 是第一个大于target的位置，right = left -1，是最后一个target出现的位置
                    if (nums[m2] <= target) l2 = m2 + 1;
                    else r2 = m2 - 1;
                }
            }
            if (left < n && nums[left] == target) ans[0] = left;
            if (r2 >= 0 && nums[r2] == target) ans[1] = r2;
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神写法
    class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            int start = lowerBound(nums, target);
            if (start == nums.length || nums[start] != target) {
                return new int[]{-1, -1}; // nums 中没有 target
            }
            // 如果 start 存在，那么 end 必定存在
            int end = lowerBound(nums, target + 1) - 1;
            return new int[]{start, end};
        }

        // lowerBound 返回最小的满足 nums[i] >= target 的下标 i
        // 如果数组为空，或者所有数都 < target，则返回 nums.length
        // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]
        private int lowerBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1; // 闭区间 [left, right]
            while (left <= right) { // 区间不为空
                // 循环不变量：
                // nums[left-1] < target
                // nums[right+1] >= target
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1; // 范围缩小到 [left, mid-1]
                } else {
                    left = mid + 1; // 范围缩小到 [mid+1, right]
                }
            }
            // 循环结束后 left = right+1
            // 此时 nums[left-1] < target 而 nums[left] = nums[right+1] >= target
            // 所以 left 就是第一个 >= target 的元素下标
            return left;
        }
    }

    static void main() {
        Solution solution = new $_0034_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // put your test code here
        print(solution.searchRange(new int[]{1}, 1));
        print(solution.searchRange(new int[]{5,8,8,8,8,10}, 8));
        print(solution.searchRange(new int[]{5,7,7,8,8,10}, 6));
        print(solution.searchRange(new int[]{}, 0));
    }
}