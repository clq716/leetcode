//在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。所有工人和自行车的位置都用网格上的 2D 坐标表示。 
//
//
// 我们为每一位工人分配一辆专属自行车，使每个工人与其分配到的自行车之间的 曼哈顿距离 最小化。 
//
// 返回 每个工人与分配到的自行车之间的曼哈顿距离的最小可能总和 。 
//
// p1 和 p2 之间的 曼哈顿距离 为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
//输出：6
//解释：
//自行车 0 分配给工人 0，自行车 1 分配给工人 1 。分配得到的曼哈顿距离都是 3, 所以输出为 6 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
//输出：4
//解释：
//先将自行车 0 分配给工人 0，再将自行车 1 分配给工人 1（或工人 2），自行车 2 给工人 2（或工人 1）。如此分配使得曼哈顿距离的总和为 4。
// 
//
// 示例 3: 
//
// 
//输入：workers = [[0,0],[1,0],[2,0],[3,0],[4,0]], bikes = [[0,999],[1,999],[2,999]
//,[3,999],[4,999]]
//输出：4995
// 
//
// 
//
// 提示： 
//
// 
// n == workers.length 
// m == bikes.length 
// 1 <= n <= m <= 10 
// workers[i].length == 2 
// bikes[i].length == 2 
// 0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000 
// 所有的工人和自行车的位置都是 不同 的。 
// 
//
// 👍 116 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class _1066_CampusBikesIi{
    public static void main(String[] args) {
       Solution solution = new _1066_CampusBikesIi().new Solution();
	   solution.assignBikes(new int[][]{{815, 60}, {638, 626}, {6, 44}, {103, 90}, {591, 880}},
			   new int[][]{{709, 161}, {341, 339}, {755, 955}, {172, 27}, {433, 489}});
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int ans = 0;
		int len = workers.length;
		for (int i = 0; i < len; i++) {
			int[] w = workers[i];
			int min = Integer.MAX_VALUE;
			int minj = 0;
			for (int j = 0; j < len; j++) {
				int[] b = bikes[j];
				if (b[0] == -1) continue;
				int m = Math.abs(w[0]-b[0]) + Math.abs(w[1]-b[1]);
				if (m < min) {
					min = m;
					minj = j;
				}
			}
			bikes[minj][0] = -1;
			ans += min;
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}