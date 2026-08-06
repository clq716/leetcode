package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 199: 二叉树的右视图
 * RedmiBook, Fedora
 * 2026-08-06 14:58:12
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0199_BinaryTreeRightSideView {

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
    //看了提示里的思路，使用BFS遍历
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            if (root == null) return ans;
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                while (size-->0) {
                    TreeNode node = deque.poll();
                    root = node;
                    if (node.left != null) deque.offer(node.left);
                    if (node.right != null) deque.offer(node.right);
                }
                ans.add(root.val);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神的DFS解法
    //先递归右子树，再递归左子树，当某个深度首次到达时，对应的节点就在右视图中。
    class Solution1 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            dfs(root, 0, ans);
            return ans;
        }

        private void dfs(TreeNode root, int depth, List<Integer> ans) {
            if (root == null) {
                return;
            }
            if (depth == ans.size()) { // 这个深度首次遇到
                ans.add(root.val);
            }
            dfs(root.right, depth + 1, ans); // 先递归右子树，保证首次遇到的一定是最右边的节点
            dfs(root.left, depth + 1, ans);
        }
    }
    static void main() {
        Solution solution = new $_0199_BinaryTreeRightSideView().new Solution();
        // put your test code here
        print(solution.rightSideView(new TreeNode()));

    }
}