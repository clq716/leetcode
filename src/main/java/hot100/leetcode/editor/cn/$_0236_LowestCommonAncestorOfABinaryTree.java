package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 236: 二叉树的最近公共祖先
 * RedmiBook, Fedora
 * 2026-08-13 11:39:47
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0236_LowestCommonAncestorOfABinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        //看了提示里的后序遍历，和灵神思路一样，但是灵神代码更简洁
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);
            if (l != null && r != null) return root;
            if ((root == p || root == q) && (l != null || r != null)) {
                return root;
            }
            if (l != null) return l;
            if (r != null) return r;
            if (root == p || root == q) return root;
            return null;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root; // 找到 p 或 q 就不往下递归了，原因见上面答疑
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) { // 左右都找到
                return root; // 当前节点是最近公共祖先
            }
            // 如果只有左子树找到，就返回左子树的返回值
            // 如果只有右子树找到，就返回右子树的返回值
            // 如果左右子树都没有找到，就返回 null（注意此时 right = null）
            return left != null ? left : right;
        }
    }

    static void main() {
        Solution solution = new $_0236_LowestCommonAncestorOfABinaryTree().new Solution();
        // put your test code here
        print(solution.lowestCommonAncestor(new TreeNode("[1,2]"), new TreeNode(1),new TreeNode(2)));
        print(solution.lowestCommonAncestor(new TreeNode("[3,5,1,6,2,0,8,null,null,7,4]"), new TreeNode(5),new TreeNode(4)));
    }
}