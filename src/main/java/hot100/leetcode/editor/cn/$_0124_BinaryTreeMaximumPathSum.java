package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 124: 二叉树中的最大路径和
 * RedmiBook, Fedora
 * 2026-08-13 13:56:22
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0124_BinaryTreeMaximumPathSum {

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

        int maxAns = Integer.MIN_VALUE;

        //这个题虽然是苦难，但是看了后序遍历的提示，稍微向下就做出来了，比较简单
        public int maxPathSum(TreeNode root) {
            traverse(root);
            return maxAns;
        }

        //计算每个节点的最大路径和，比较出其中最大的
        public int traverse(TreeNode node) {
            if (node == null) return 0;
            int left = traverse(node.left);
            int right = traverse(node.right);
            int ans = node.val;
            if (left > 0 && right > 0) {
                //注意这里，是为了防止将左右结果都加到节点最大值里
                maxAns = Math.max(ans + left + right, maxAns);
                ans += Math.max(left, right);
            } else {
                if (left > 0) ans += left;
                if (right > 0) ans += right;
                maxAns = Math.max(ans, maxAns);
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
    //灵神解法，用了一个技巧，通过0覆盖负数，避免进行负数判断
    class Solution1 {
        private int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0; // 没有节点，和为 0
            }
            int sumL = dfs(node.left); // 左子树最大链和
            int sumR = dfs(node.right); // 右子树最大链和
            ans = Math.max(ans, sumL + node.val + sumR); // 左链 + node + 右链 = 路径
            return Math.max(Math.max(sumL, sumR) + node.val, 0); // 当前子树最大链和（注意这里和 0 取最大值了）
        }
    }

    
    static void main() {
        Solution solution = new $_0124_BinaryTreeMaximumPathSum().new Solution();
        // put your test code here
        
    }
}