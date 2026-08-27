package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 33: 搜索旋转排序数组
 * RedmiBook, Fedora
 * 2026-08-26 22:28:15
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0033_SearchInRotatedSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //本质上这个题是分情况讨论
        //但是怎么分需要技巧
        //另外就是处理边界条件
        //我尝试了几个小时也没能找到正确思路
        //从灵神评论区找到了能够理解的答案
        public int search(int[] nums, int target) {
            int n = nums.length, left = 0, right = n-1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) return mid;
                if (nums[mid] >= nums[left]) {
                    //left -> mid 单调递增
                    if (nums[mid] > target && target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    //mid -> right 单调递增
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神评论区思路
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            // 左半段有序 例如[4 5 6 7 8 1 2] mid是7，左半边456是有序的
            if (nums[left] <= nums[mid]) {
                // target 在 [nums[left], nums[mid-1]] 内
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else { // target 在右边 [nums[mid+1], nums[right]]
                    left = mid + 1;
                }
            } else { // 右半段有序 例如[4 5 1 2 3 4 5] mid是2，右半边345是有序的
                // target 在 [nums[mid+1], nums[right]] 内
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else { // target在左半边
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    
    static void main() {
        Solution solution = new $_0033_SearchInRotatedSortedArray().new Solution();
        // put your test code here
        print(solution.search(new int[]{3,1}, 3)); //0
        print(solution.search(new int[]{3,1}, 1)); //1
        print(solution.search(new int[]{5,1,3}, 1)); //1
        print(solution.search(new int[]{4,5,6,7,8,1,2,3}, 8));//4
        print(solution.search(new int[]{1,3,5}, 3));//1
        print(solution.search(new int[]{1}, 0));//-1
        print(solution.search(new int[]{4,5,6,7,0,1,2}, 3));//-1
        print(solution.search(new int[]{4,5,6,7,0,1,2}, 0));//4
    }
}