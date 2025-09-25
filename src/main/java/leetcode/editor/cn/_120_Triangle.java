//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
//
// 👍 1486 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class _120_Triangle{
    public static void main(String[] args) {
       Solution solution = new _120_Triangle().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
		//i j
		//i+1 j i+1 j+1
		int n = triangle.size();
		int[][] memo = new int[n][n];
		for (int[] me : memo) {
			Arrays.fill(me, Integer.MIN_VALUE);
		}
		return dfs(triangle, 0, 0, memo);
    }

	private int dfs(List<List<Integer>> triangle, int i, int j, int[][] memo) {
		int n = triangle.size();
		if (i == n-1) return triangle.get(i).get(j);
		if (memo[i][j] != Integer.MIN_VALUE) return memo[i][j];
		int current = triangle.get(i).get(j);
		int next1 = dfs(triangle, i+1, j, memo);
		int next2 = dfs(triangle, i+1, j+1, memo);
		memo[i][j] = current + Math.min(next1, next2);
		return memo[i][j];
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}