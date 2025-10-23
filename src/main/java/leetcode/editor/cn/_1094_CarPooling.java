//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trips[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行
//有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// 👍 433 👎 0


package leetcode.editor.cn;
public class _1094_CarPooling{
    public static void main(String[] args) {
       Solution solution = new _1094_CarPooling().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
		int n = 1001;
		int size = 0;
		int[] diff = new int[n];
		for (int[] update : trips) {
			int inc = update[0];
			int start = update[1];
			int end = update[2]-1;
			size = Math.max(size, start);
			size = Math.max(size, update[2]);
			diff[start] += inc;
			if (end < n - 1) {
				diff[end+1] -= inc;
			}
		}
		int[] ans = new int[size+1];
		ans[0] = diff[0];
		if (diff[0] > capacity) return false;
		for (int i = 1; i < size+1; i++) {
			ans[i] = ans[i-1] + diff[i];
			if (ans[i] > capacity) return false;
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}