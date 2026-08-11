package hot100.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import utils.*;
import static utils.Printer.print;
/**
 * 105: 从前序与中序遍历序列构造二叉树
 * RedmiBook, Fedora
 * 2026-08-07 14:04:04
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = inorder.length;
            Map<Integer, Integer> cnt = new HashMap<>(n);
            for (int i = 0; i < n; i++) cnt.put(inorder[i], i);
            return traverse(0, n-1, cnt, preorder, 0);
        }

        private TreeNode traverse(int start, int end, Map<Integer, Integer> cnt, int[] preOrder, int delta) {
            if (end < start) return null;
            if (end == start) return new TreeNode(preOrder[start]);
            int root = cnt.get(preOrder[start]);
            return new TreeNode(preOrder[start], traverse(start+1, root + delta, cnt, preOrder, delta + 1), traverse(root + delta+1, end, cnt, preOrder, delta));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 灵神解法
     */
    class Solution1 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            Map<Integer, Integer> index = HashMap.newHashMap(n); // 预分配空间
            for (int i = 0; i < n; i++) {
                index.put(inorder[i], i);
            }
            return dfs(0, n, 0, preorder, index); // 左闭右开区间
        }

        // 根据 preorder 的子数组 [preL,preR) 和 inorder 的子数组 [inL,inR) 生成二叉树，其中 inR 没用到，可以省略
        private TreeNode dfs(int preL, int preR, int inL, int[] preorder, Map<Integer, Integer> index) {
            if (preL == preR) { // 空节点
                return null;
            }
            int leftSize = index.get(preorder[preL]) - inL; // 左子树的大小
            TreeNode left = dfs(preL + 1, preL + 1 + leftSize, inL, preorder, index);
            TreeNode right = dfs(preL + 1 + leftSize, preR, inL + 1 + leftSize, preorder, index);
            return new TreeNode(preorder[preL], left, right);
        }
    }

    static void main() {
        Solution solution = new $_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // put your test code here
        /*
         * 解答失败:
         * 	测试用例:[4,2,1,3]
         * 			[1,2,3,4]
         * 	测试结果:[4,2,null,null,1,null,3]
         * 	期望结果:[4,2,null,1,3]
         */
        TreeNode nodec = solution.buildTree(new int[]{4,2,1,3}, new int[]{1,2,3,4});
        print(nodec);
        TreeNode nodeb = solution.buildTree(new int[]{1,2,3}, new int[]{1,3,2});
        //[1,null,2,3]
        print(nodeb);
        TreeNode node0 = solution.buildTree(new int[]{1,2}, new int[]{2,1});
        //1,2
        print(node0);
        TreeNode nodea = solution.buildTree(new int[]{1,2,3}, new int[]{2,3,1});
        //[1,2,null,null,3]
        print(nodea);
        TreeNode node1 = solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        print(node1);
        TreeNode node2 = solution.buildTree(new int[]{-1}, new int[]{-1});
        print(node2);
    }
}