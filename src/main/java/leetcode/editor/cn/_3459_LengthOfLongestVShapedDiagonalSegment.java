//给你一个大小为 n x m 的二维整数矩阵 grid，其中每个元素的值为 0、1 或 2。 
//
// V 形对角线段 定义如下： 
//
// 
// 线段从 1 开始。 
// 后续元素按照以下无限序列的模式排列：2, 0, 2, 0, ...。 
// 该线段： 
// 
// 起始于某个对角方向（左上到右下、右下到左上、右上到左下或左下到右上）。 
// 沿着相同的对角方向继续，保持 序列模式 。 
// 在保持 序列模式 的前提下，最多允许 一次顺时针 90 度转向 另一个对角方向。 
// 
// 
//
// 
//
// 返回最长的 V 形对角线段 的 长度 。如果不存在有效的线段，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
// 输入： grid = [[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]] 
// 
//
// 输出： 5 
//
// 解释： 
//
// 
//
// 最长的 V 形对角线段长度为 5，路径如下：(0,2) → (1,3) → (2,4)，在 (2,4) 处进行 顺时针 90 度转向 ，继续路径为 (3,
//3) → (4,2)。 
//
// 示例 2： 
//
// 
// 输入： grid = [[2,2,2,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]] 
// 
//
// 输出： 4 
//
// 解释： 
//
// 
//
// 最长的 V 形对角线段长度为 4，路径如下：(2,3) → (3,2)，在 (3,2) 处进行 顺时针 90 度转向 ，继续路径为 (2,1) → (1,
//0)。 
//
// 示例 3： 
//
// 
// 输入： grid = [[1,2,2,2,2],[2,2,2,2,0],[2,0,0,0,0],[0,0,2,2,2],[2,0,0,2,0]] 
// 
//
// 输出： 5 
//
// 解释： 
//
// 
//
// 最长的 V 形对角线段长度为 5，路径如下：(0,0) → (1,1) → (2,2) → (3,3) → (4,4)。 
//
// 示例 4： 
//
// 
// 输入： grid = [[1]] 
// 
//
// 输出： 1 
//
// 解释： 
//
// 最长的 V 形对角线段长度为 1，路径如下：(0,0)。 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// m == grid[i].length 
// 1 <= n, m <= 500 
// grid[i][j] 的值为 0、1 或 2。 
// 
//
// 👍 16 👎 0


package leetcode.editor.cn;
public class _3459_LengthOfLongestVShapedDiagonalSegment{
    public static void main(String[] args) {
       Solution solution = new _3459_LengthOfLongestVShapedDiagonalSegment().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
		int n = grid[0].length;
		int ans = 0;
		int[][][] memo = new int[m][n][8];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						ans = Math.max(ans, dfs(i,j,k,1,2,grid,memo)+1);
					}
				}
			}
		}
		return ans;
    }
	private final int[][] DIRS = {{1,1},{1,-1},{-1,-1},{-1,1}};
	private int dfs(int i, int j, int k, int canturn, int target, int[][] grid, int[][][] memo) {
		i += DIRS[k][0];
		j += DIRS[k][1];
		if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != target) {
			return 0;
		}
		int mask = k << 1 | canturn;
		if (memo[i][j][mask] > 0) return memo[i][j][mask];
		int res = dfs(i,j,k,canturn,2-target,grid,memo) + 1;
		if (canturn == 1) res = Math.max(res, dfs(i,j,(k+1)%4,0,2-target,grid,memo)+1);
		return memo[i][j][mask] = res;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}