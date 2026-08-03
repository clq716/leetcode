package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 94: 二叉树的中序遍历
 * RedmiBook, Fedora
 * 2026-08-03 09:57:41
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0094_BinaryTreeInorderTraversal {

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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            traverse(root, ans);
            return ans;
        }

        private void traverse(TreeNode node, List<Integer> ans) {
            if (node == null) return;
            traverse(node.left, ans);
            ans.add(node.val);
            traverse(node.right, ans);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0094_BinaryTreeInorderTraversal().new Solution();
        // put your test code here
        solution.inorderTraversal(new TreeNode("[1,2,3,4,5]"));
    }
}