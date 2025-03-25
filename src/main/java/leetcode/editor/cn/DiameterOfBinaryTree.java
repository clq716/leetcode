//<p>给你一棵二叉树的根节点，返回该树的 <strong>直径</strong> 。</p>
//
//<p>二叉树的 <strong>直径</strong> 是指树中任意两个节点之间最长路径的 <strong>长度</strong> 。这条路径可能经过也可能不经过根节点 <code>root</code> 。</p>
//
//<p>两节点之间路径的 <strong>长度</strong> 由它们之间边数表示。</p>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg" style="width: 292px; height: 302px;" /> 
//<pre>
//<strong>输入：</strong>root = [1,2,3,4,5]
//<strong>输出：</strong>3
//<strong>解释：</strong>3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
//</pre>
//
//<p><strong class="example">示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1,2]
//<strong>输出：</strong>1
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>树中节点数目在范围 <code>[1, 10<sup>4</sup>]</code> 内</li> 
// <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
//</ul>
//
//<div><li>👍 1686</li><li>👎 0</li></div>

package leetcode.editor.cn;
public class DiameterOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
    }
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
    public int diameterOfBinaryTree(TreeNode root) {
        recurse(root);
        return depth;
    }

    int depth = 0;

    private int recurse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = recurse(node.left);
        int right = recurse(node.right);
        depth = Math.max(depth, left + right);
        return Math.max(left, right) + 1;
    }
}
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}