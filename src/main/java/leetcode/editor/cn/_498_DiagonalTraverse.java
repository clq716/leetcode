//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
//
// 👍 540 👎 0


package leetcode.editor.cn;

public class _498_DiagonalTraverse {
	public static void main(String[] args) {
		Solution solution = new _498_DiagonalTraverse().new Solution();
		solution.findDiagonalOrder(new int[][]{{2,5},{8,4},{0,-1}});
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] findDiagonalOrder(int[][] mat) {
			int m = mat.length;
			int n = mat[0].length;
			int[] ans = new int[m * n];
			int idx = 0;
			for (int k = 0; k < m+n-1; k++) {
				int minJ = Math.max(k-m+1, 0);
				int maxJ = Math.min(k, n-1);
				if (k % 2 ==0 ) {
					for (int j = minJ; j <= maxJ; j++) {
						ans[idx++] = mat[k-j][j];
					}
				} else {
					for (int j = maxJ; j >= minJ; j--) {
						ans[idx++] = mat[k-j][j];
					}
				}
			}
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}