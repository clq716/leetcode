package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 35: 搜索插入位置
 * RedmiBook, Fedora
 * 2026-08-14 15:59:36
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0035_SearchInsertPosition {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            return dfs(nums, target, -1, nums.length);
        }

        private int dfs(int[] nums, int target, int left, int right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            if (left + 1 == right || left == right) return right;
            if (nums[middle] < target) return dfs(nums, target, middle, right);
            return dfs(nums, target, left, middle);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神三种写法
    //最关键区别是： int mid = left + (right - left) / 2;
    //而我用的是 (right - left) / 2 来获取中间值
    class Solution1 {
        public int searchInsert(int[] nums, int target) {
            return lowerBound(nums, target); // 选择其中一种写法即可
        }

        // lowerBound 返回最小的满足 nums[i] >= target 的 i
        // 如果数组为空，或者所有数都 < target，则返回 nums.length
        // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]

        // 闭区间写法
        private int lowerBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1; // 闭区间 [left, right]
            while (left <= right) { // 区间不为空
                // 循环不变量：
                // nums[left-1] < target
                // nums[right+1] >= target
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1; // 范围缩小到 [mid+1, right]
                } else {
                    right = mid - 1; // 范围缩小到 [left, mid-1]
                }
            }
            return left;
        }

        // 左闭右开区间写法
        private int lowerBound2(int[] nums, int target) {
            int left = 0;
            int right = nums.length; // 左闭右开区间 [left, right)
            while (left < right) { // 区间不为空
                // 循环不变量：
                // nums[left-1] < target
                // nums[right] >= target
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1; // 范围缩小到 [mid+1, right)
                } else {
                    right = mid; // 范围缩小到 [left, mid)
                }
            }
            return left; // 或者 right
        }

        // 开区间写法
        private int lowerBound3(int[] nums, int target) {
            int left = -1;
            int right = nums.length; // 开区间 (left, right)
            while (left + 1 < right) { // 区间不为空
                // 循环不变量：
                // nums[left] < target
                // nums[right] >= target
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid; // 范围缩小到 (mid, right)
                } else {
                    right = mid; // 范围缩小到 (left, mid)
                }
            }
            return right;
        }
    }

    static void main() {
        Solution solution = new $_0035_SearchInsertPosition().new Solution();
        // put your test code here
        print(solution.searchInsert(new int[]{1,3,5,6},0));
    }
}