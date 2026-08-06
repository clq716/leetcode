package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 98: 验证二叉搜索树
 * RedmiBook, Fedora
 * 2026-08-06 10:19:27
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0098_ValidateBinarySearchTree {

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
        TreeNode pre = null;
        boolean ans = true;

        /**
         * 一开始没想到思路，还想着取左子树最大值和右子树最小值，与当前节点进行比较判断
         * 看了提示中序遍历，想到能用前驱指针记录前驱节点
         * 中序遍历是 左 根 右 的顺序
         * 所以只要判断当前指针的值大于前驱节点的值就可以
         */
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            ans = ans && isValidBST(root.left);
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            return ans && isValidBST(root.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神使用前中后三种方式来实现，以下列出
    //只有中序遍历能不使用额外方法解决这个问题，但需要额外变量记录前驱节点
    //1. 灵神中序遍历，优化点有两个
    //使用 long 类型记录前驱数值，避免Integer最小值无法比较
    //去除 ans 记录结果的逻辑，因为只有false才会 return,同样实现了剪枝的效果
    class Solution中序 {
        private long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) { // 左
                return false;
            }
            if (root.val <= pre) { // 中
                return false;
            }
            pre = root.val;
            return isValidBST(root.right); // 右
        }
    }

    /**
     * 灵神前序遍历
     * dfs 额外传入两个参数，分别表示从根到当前节点路径上的最小值和最大值。
     * 当前节点的值必须在最小值和最大值之间（不能等于）。原理见视频。
     */
    class Solution前序 {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode node, long left, long right) {
            if (node == null) {
                return true;
            }
            long x = node.val;
            return left < x && x < right &&
                    isValidBST(node.left, left, x) &&
                    isValidBST(node.right, x, right);
        }
    }

    /**
     * 灵神后序遍历实现方式
     * 最难理解，需要使用额外数组
     * dfs 返回子树的最小值和最大值，供上面的节点判断是否为二叉搜索树。
     */
    class Solution后序 {
        public boolean isValidBST(TreeNode root) {
            return dfs(root)[1] != Long.MAX_VALUE;
        }

        private long[] dfs(TreeNode node) {
            if (node == null) {
                return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
            }
            long[] left = dfs(node.left);
            long[] right = dfs(node.right);
            long x = node.val;
            // 也可以在递归完左子树之后立刻判断，如果发现不是二叉搜索树，就不用递归右子树了
            if (x <= left[1] || x >= right[0]) {
                //出现一次之后，说明不平衡，后面归的过程中就不会再进入这个条件，在下面的 return 语句中恒定返回 long[]{Long.MIN_VALUE, Long.MAX_VALUE};
                return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
            }
            return new long[]{Math.min(left[0], x), Math.max(right[1], x)};
        }
    }

    
    static void main() {
        Solution solution = new $_0098_ValidateBinarySearchTree().new Solution();
        // put your test code here
        
    }
}