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

    //Morris遍历方法
    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            while (root != null) {
                if (root.left != null) {
                    // 找 root 的前驱 pre：在中序遍历中，root 的上一个节点
                    // 从 root.left 开始，一直向右走，直到走到尽头，或者遇到指向 root 的线索（回到 root 的路）
                    TreeNode pre = root.left;
                    while (pre.right != null && pre.right != root) {
                        pre = pre.right;
                    }

                    // root 的左子树尚未访问
                    if (pre.right == null) {
                        pre.right = root; // 建立线索（回到 root 的路），相当于把 pre.right 当作栈
                        root = root.left; // 访问左子树
                        continue;
                    }

                    // root 的左子树访问完毕，去掉线索，恢复原样
                    pre.right = null; // 注：如果调用完 inorderTraversal 不再使用这棵二叉树，这行代码可以去掉
                }

                // root 的左子树访问完毕
                ans.add(root.val); // 记录当前节点的值
                root = root.right; // 如果有右子树就访问右子树，没有就顺着线索回到指向的节点
            }

            return ans;
        }
    }
    static void main() {
        Solution solution = new $_0094_BinaryTreeInorderTraversal().new Solution();
        // put your test code here
        solution.inorderTraversal(new TreeNode("[1,2,3,4,5]"));
    }
}