//在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。 
//
// 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。 
//
// 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可
//以灌溉的区域为 [i - ranges[i], i + ranges[i]] 。 
//
// 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 5, ranges = [3,4,1,1,0,0]
//输出：1
//解释：
//点 0 处的水龙头可以灌溉区间 [-3,3]
//点 1 处的水龙头可以灌溉区间 [-3,5]
//点 2 处的水龙头可以灌溉区间 [1,3]
//点 3 处的水龙头可以灌溉区间 [2,4]
//点 4 处的水龙头可以灌溉区间 [4,4]
//点 5 处的水龙头可以灌溉区间 [5,5]
//只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
// 
//
// 示例 2： 
//
// 
//输入：n = 3, ranges = [0,0,0,0]
//输出：-1
//解释：即使打开所有水龙头，你也无法灌溉整个花园。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// ranges.length == n + 1 
// 0 <= ranges[i] <= 100 
// 
//
// Related Topics 贪心 数组 动态规划 👍 219 👎 0


package leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinimumNumberOfTapsToOpenToWaterAGarden{
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfTapsToOpenToWaterAGarden().new Solution();
        int result = solution.minTaps(7, new int[]{1,2,1,0,2,1,0,1});   //3
//        int result = solution.minTaps(5, new int[]{3,4,1,1,0,0});   //1
//        int result = solution.minTaps(9, new int[]{0,5,0,3,3,3,1,4,0,4});   //2
        log.info(""+result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTaps(int n, int[] ranges) {
        //创建新数组，记录每个水龙头端点最远喷洒位置
        int[] maxSpots = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int left = Math.max(i - ranges[i], 0);
            int right = i + ranges[i];
            maxSpots[left] = Math.max(right, maxSpots[left]);
        }

        //之前最远位置
        int prevMax = 0;
        //当前最远位置
        int currentMax = 0;
        //水龙头数量
        int count = 0;
        for (int i = 0; i < n; i++) {
            //记录当前最远位置
            currentMax = Math.max(currentMax, maxSpots[i]);
            //如果当前最远位置小于当前下标，那么 i-(i+1) 处花园无法浇灌，返回-1
            if (currentMax <= i) {
                return -1;
            }
            //如果之前最远位置已经到头，需要切换最远位置
            if (prevMax == i) {
                ++count;
                prevMax = currentMax;
            }
        }
        return count;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}