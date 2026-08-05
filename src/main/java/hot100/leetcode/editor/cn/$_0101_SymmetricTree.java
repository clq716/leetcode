package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 101: 对称二叉树
 * RedmiBook, Fedora
 * 2026-08-05 18:13:26
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0101_SymmetricTree {

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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return traverse(root.left, root.right, true);
        }

        public boolean traverse(TreeNode left, TreeNode right, boolean ans) {
            if (!ans) return false;
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            return traverse(left.left, right.right, ans) && traverse(left.right, right.left, ans);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神的简洁写法
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            return isSameTree(root.left, root.right);
        }

        // 100. 相同的树（改成镜像判断）
        private boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) {
                return p == q;
            }
            return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
        }
    }

    static void main() {
        Solution solution = new $_0101_SymmetricTree().new Solution();
        // put your test code here
        TreeNode node = new TreeNode("[1,0]");
        print(solution.isSymmetric(node));
    }
}