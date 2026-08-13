package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 437: 路径总和 III
 * RedmiBook, Fedora
 * 2026-08-11 16:17:02
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0437_PathSumIii {

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

        int ans = 0;
        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> map = new HashMap<>();
            map.put(0L, 1);
            return travers(root, map, 0, targetSum);
        }

        /**
         * 前序维护节点，后续移出节点
         * 可以通过最基本的树 [1,2,3]，来通过方发栈入栈和出栈过程，想明白前序维护，后序恢复的过程
         */
        private int travers(TreeNode node, Map<Long, Integer> cnt, long sum, int targetSum) {
            if (node == null) return 0;
            //前序添加
            //increase
            sum += node.val;
            int findCOunt = cnt.getOrDefault(sum - targetSum, 0);
            cnt.merge(sum, 1, Integer::sum);
            int left = travers(node.left, cnt, sum, targetSum);
            int right = travers(node.right, cnt, sum, targetSum);
            //后续删除
            //decrease
            // 如果是先更新cnt,再更新答案，会在 targetSum = 0 的情况下，出现多算的问题
            // 因为 targetSum = 0的时候，总能找到 自身的值，而这个不是我们要找的
            // 放到 sum 更新和 cnt 更新之间没有问题，因为我们使用的更新后的sum去查找
            // int findCOunt = cnt.getOrDefault(sum - targetSum, 0);
            int decrease = cnt.merge(sum, -1, Integer::sum);
            //这里可以不用删除过期元素，但我没想明白为什么
//            if (decrease == 0) {
//                cnt.remove(sum);
//            }
            return findCOunt + left + right;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神解法
    class Solution1 {
        private int ans;

        public int pathSum(TreeNode root, int targetSum) {
            // key：从根到 node 的节点值之和
            // value：节点值之和的出现次数
            // 注意在递归过程中，哈希表只保存根到 node 的路径的前缀的节点值之和
            Map<Long, Integer> cnt = new HashMap<>();
            cnt.put(0L, 1);
            dfs(root, 0, targetSum, cnt);
            return ans;
        }

        // s 表示从根到 node 的父节点的节点值之和（node 的节点值尚未计入）
        private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
            if (node == null) {
                return;
            }

            s += node.val;
            // 把 node 当作路径的终点，统计有多少个起点
            ans += cnt.getOrDefault(s - targetSum, 0);

            cnt.merge(s, 1, Integer::sum); // cnt[s]++
            dfs(node.left, s, targetSum, cnt);
            dfs(node.right, s, targetSum, cnt);
            cnt.merge(s, -1, Integer::sum); // cnt[s]-- 恢复现场（撤销 cnt[s]++）
        }
    }

    static void main() {
        Solution solution = new $_0437_PathSumIii().new Solution();
        // put your test code here
        TreeNode node4 = new TreeNode("[1,2]");
        print(solution.pathSum(node4, 0));//0
        TreeNode node3 = new TreeNode("[1]");
        print(solution.pathSum(node3, 0));//0
        TreeNode node1 = new TreeNode("10,5,-3,3,2,null,11,3,-2,null,1");
        print(solution.pathSum(node1, 8));//3
        TreeNode node2 = new TreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        print(solution.pathSum(node2, 22));//3

    }
}