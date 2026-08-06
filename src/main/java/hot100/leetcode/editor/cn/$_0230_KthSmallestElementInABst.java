package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 230: 二叉搜索树中第 K 小的元素
 * RedmiBook, Fedora
 * 2026-08-06 11:10:42
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0230_KthSmallestElementInABst {

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
        int ans = -1;
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) return k;
            k = kthSmallest(root.left, k);
            if (ans != -1) return ans;
            if (k == 1) {
                ans = root.val;
                return ans;
            }
            k--;
            return kthSmallest(root.right, k);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神中序遍历，思路和我一开始的一样
    class Solution1 {
        private int ans;
        private int k;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode node) {
            if (node == null || k <= 0) {
                return;
            }
            dfs(node.left); // 左
            if (--k == 0) {
                ans = node.val; // 根
            }
            dfs(node.right); // 右
        }
    }

    /**
     * 灵神第二种写法，没看明白，还是外部变量 + 中序遍历 我最容易想到和理解
     * 写法二：不记录答案 + 提前返回
     * 写法一使用了一个外部变量记录答案，能否不使用外部变量记录呢？
     * 可以，做法如下：
     *     递归边界：如果当前节点是空节点，返回 −1，表示没有找到。注意题目保证节点值非负。
     *     执行中序遍历，先递归左子树。
     *     判断左子树的返回值 leftRes 是否为 −1。如果不是 −1，说明我们在左子树中找到了答案，返回 leftRes。如果是 −1，说明尚未找到答案，继续下一步。
     *     把 k 减少 1。如果 k=0，那么答案就是当前节点值，返回当前节点值。
     *     现在，答案要么在当前节点的右子树中，要么在除了当前子树的其余节点中。递归右子树，如果答案在右子树中，那么直接返回答案；如果答案不在右子树中，那么右子树也会返回 −1，由于当前子树搜索完毕，所以当前子树没有找到答案，返回 −1。综上所述，可以直接返回右子树的返回值。
     */
    class Solution2 {
        private int k;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            return dfs(root);
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return -1; // 题目保证节点值非负，用 -1 表示没有找到
            }
            int leftRes = dfs(node.left);
            if (leftRes != -1) { // 答案在左子树中
                return leftRes;
            }
            if (--k == 0) { // 答案就是当前节点
                return node.val;
            }
            return dfs(node.right); // 右子树会返回答案或者 -1
        }
    }


    static void main() {
        Solution solution = new $_0230_KthSmallestElementInABst().new Solution();
        // put your test code here
        print(solution.kthSmallest(new TreeNode("[5,3,6,2,4,null,null,1]"), 3));
        print(solution.ans);
    }
}