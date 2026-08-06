package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 108: 将有序数组转换为二叉搜索树
 * RedmiBook, Fedora
 * 2026-08-05 18:28:15
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0108_ConvertSortedArrayToBinarySearchTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
      * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return binary(nums, 0, nums.length-1);
        }

        private TreeNode binary(int[] nums, int left, int right) {
            if (left > right) return null;
            if (left == right) return new TreeNode(nums[left]);
            int middle = (left + right) / 2;
            return new TreeNode(nums[middle], binary(nums, left, middle - 1), binary(nums, middle + 1, right));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神的简洁写法，但是没有我的好理解
    class Solution1 {
        public TreeNode sortedArrayToBST(int[] nums) {
            return dfs(nums, 0, nums.length);
        }

        // 把 nums[left] 到 nums[right-1] 转成平衡二叉搜索树
        private TreeNode dfs(int[] nums, int left, int right) {
            if (left == right) {
                return null;
            }
            int m = (left + right) >>> 1;
            return new TreeNode(nums[m], dfs(nums, left, m), dfs(nums, m + 1, right));
        }
    }

    static void main() {
        Solution solution = new $_0108_ConvertSortedArrayToBinarySearchTree().new Solution();
        // put your test code here
        
    }
}