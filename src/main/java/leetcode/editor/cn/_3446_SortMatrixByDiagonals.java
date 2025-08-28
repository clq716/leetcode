//给你一个大小为 n x n 的整数方阵 grid。返回一个经过如下调整的矩阵： 
//
// 
// 左下角三角形（包括中间对角线）的对角线按 非递增顺序 排序。 
// 右上角三角形 的对角线按 非递减顺序 排序。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入： grid = [[1,7,3],[9,8,2],[4,5,6]] 
// 
//
// 输出： [[8,2,3],[9,6,7],[4,5,1]] 
//
// 解释： 
//
// 
//
// 标有黑色箭头的对角线（左下角三角形）应按非递增顺序排序： 
//
// 
// [1, 8, 6] 变为 [8, 6, 1]。 
// [9, 5] 和 [4] 保持不变。 
// 
//
// 标有蓝色箭头的对角线（右上角三角形）应按非递减顺序排序： 
//
// 
// [7, 2] 变为 [2, 7]。 
// [3] 保持不变。 
// 
//
// 示例 2： 
//
// 
// 输入： grid = [[0,1],[1,2]] 
// 
//
// 输出： [[2,1],[1,0]] 
//
// 解释： 
//
// 
//
// 标有黑色箭头的对角线必须按非递增顺序排序，因此 [0, 2] 变为 [2, 0]。其他对角线已经符合要求。 
//
// 示例 3： 
//
// 
// 输入： grid = [[1]] 
// 
//
// 输出： [[1]] 
//
// 解释： 
//
// 只有一个元素的对角线已经符合要求，因此无需修改。 
//
// 
//
// 提示： 
//
// 
// grid.length == grid[i].length == n 
// 1 <= n <= 10 
// -10⁵ <= grid[i][j] <= 10⁵ 
// 
//
// 👍 24 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _3446_SortMatrixByDiagonals{
    public static void main(String[] args) {
       Solution solution = new _3446_SortMatrixByDiagonals().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] sortMatrix(int[][] grid) {
		int n = grid.length;
		PriorityQueue<Integer>[] cnt = new PriorityQueue[2*n+1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int idx = j + n - i;
				PriorityQueue<Integer> queue = cnt[idx];
				if(queue == null) {
					queue = cnt[idx] = j > i ? new PriorityQueue<>() : new PriorityQueue<>((a,b)->b-a);
				}
				queue.add(grid[i][j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int idx = j + n - i;
				grid[i][j] = cnt[idx].poll();
			}
		}
		return grid;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}