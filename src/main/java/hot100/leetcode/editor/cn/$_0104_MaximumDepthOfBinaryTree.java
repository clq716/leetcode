package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 104: 二叉树的最大深度
 * RedmiBook, Fedora
 * 2026-08-05 17:49:41
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0104_MaximumDepthOfBinaryTree {

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
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0104_MaximumDepthOfBinaryTree().new Solution();
        // put your test code here
        TreeNode node = new TreeNode("[1,null,2]");
        print(solution.maxDepth(node));
    }
}