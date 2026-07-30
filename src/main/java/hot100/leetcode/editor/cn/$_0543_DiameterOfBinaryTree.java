package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 543: 二叉树的直径
 * RedmiBook, Fedora
 * 2026-07-30 19:16:30
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0543_DiameterOfBinaryTree {

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
        int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            traverse(root);
            return ans;
        }

        // 节点最大深度 = Max(左侧最大深度, 右侧最大深度) + 1
        // 节点直径 = 左侧最大深度 + 右侧最大深度
        private int traverse(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = traverse(node.left);
            int right = traverse(node.right);
            ans = Math.max(left + right, ans);
            return Math.max(left, right) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0543_DiameterOfBinaryTree().new Solution();
        // put your test code here
        TreeNode node = new TreeNode("[1,2,3,4,5]");
        print(node);
        print(solution.diameterOfBinaryTree(node));
    }
}