package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 114: 二叉树展开为链表
 * RedmiBook, Fedora
 * 2026-08-06 15:47:14
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0114_FlattenBinaryTreeToLinkedList {

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
    /**
     * 虽然试出来了，但是没有完全想明白
     * 使用前序遍历，模拟出右节点链表的顺序
     * 暂存子节点，然后重构前驱节点的子节点
     */
    class Solution {
        TreeNode parent = null;
        public void flatten(TreeNode root) {
            if (root == null) return;
            //注意这里需要暂存子节点指针，否则会在之后丢失
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (parent != null) {
                parent.left = null;
                parent.right = root;
            }
            parent = root;
            flatten(left);
            flatten(right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神的逆序遍历，与 前序遍历相反
    //我使用前驱的解法，需要暂存子节点，理论上使用了 O(N) 的额外空间
    class Solution1 {
        //相当于 root 是 head 的前驱指针，与我的思路反过来
        private TreeNode head;

        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            // 右 - 左 - 根
            flatten(root.right);
            flatten(root.left);
            root.left = null;
            root.right = head; // 头插法，相当于链表的 root.next = head
            head = root; // 现在链表头节点是 root
        }
    }

    //灵神分治解法，没看懂
    class Solution2 {
        public void flatten(TreeNode root) {
            dfs(root);
        }

        private TreeNode dfs(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode leftTail = dfs(root.left);
            TreeNode rightTail = dfs(root.right);
            if (leftTail != null) {
                leftTail.right = root.right; // 左子树链表的尾节点 -> 右子树链表的头节点
                root.right = root.left; // root -> 左子树链表的头节点
                root.left = null;
            }
            return rightTail != null ? rightTail : leftTail != null ? leftTail : root;
        }
    }
    
    static void main() {
        Solution solution = new $_0114_FlattenBinaryTreeToLinkedList().new Solution();
        // put your test code here
        
    }
}