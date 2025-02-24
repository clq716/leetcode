//<p>给你一个下标从<strong>&nbsp;0</strong>&nbsp;开始的 <strong>二进制</strong>&nbsp;字符串&nbsp;<code>floor</code>&nbsp;，它表示地板上砖块的颜色。</p>
//
//<ul> 
// <li><code>floor[i] = '0'</code>&nbsp;表示地板上第&nbsp;<code>i</code>&nbsp;块砖块的颜色是 <strong>黑色</strong>&nbsp;。</li> 
// <li><code>floor[i] = '1'</code>&nbsp;表示地板上第&nbsp;<code>i</code>&nbsp;块砖块的颜色是 <strong>白色</strong>&nbsp;。</li> 
//</ul>
//
//<p>同时给你&nbsp;<code>numCarpets</code> 和&nbsp;<code>carpetLen</code>&nbsp;。你有&nbsp;<code>numCarpets</code>&nbsp;条&nbsp;<strong>黑色</strong>&nbsp;的地毯，每一条&nbsp;<strong>黑色</strong>&nbsp;的地毯长度都为&nbsp;<code>carpetLen</code>&nbsp;块砖块。请你使用这些地毯去覆盖砖块，使得未被覆盖的剩余 <strong>白色</strong>&nbsp;砖块的数目 <strong>最小</strong>&nbsp;。地毯相互之间可以覆盖。</p>
//
//<p>请你返回没被覆盖的白色砖块的 <strong>最少</strong>&nbsp;数目。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2022/02/10/ex1-1.png" style="width: 400px; height: 73px;" /></p>
//
//<pre><b>输入：</b>floor = "10110101", numCarpets = 2, carpetLen = 2
//<b>输出：</b>2
//<b>解释：</b>
//上图展示了剩余 2 块白色砖块的方案。
//没有其他方案可以使未被覆盖的白色砖块少于 2 块。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2022/02/10/ex2.png" style="width: 353px; height: 123px;" /></p>
//
//<pre><b>输入：</b>floor = "11111", numCarpets = 2, carpetLen = 3
//<b>输出：</b>0
//<b>解释：</b>
//上图展示了所有白色砖块都被覆盖的一种方案。
//注意，地毯相互之间可以覆盖。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= carpetLen &lt;= floor.length &lt;= 1000</code></li> 
// <li><code>floor[i]</code> 要么是&nbsp;<code>'0'</code>&nbsp;，要么是&nbsp;<code>'1'</code>&nbsp;。</li> 
// <li><code>1 &lt;= numCarpets &lt;= 1000</code></li> 
//</ul>
//
//<div><li>👍 80</li><li>👎 0</li></div>

package leetcode.editor.cn;
public class MinimumWhiteTilesAfterCoveringWithCarpets{
    public static void main(String[] args) {
        Solution solution = new MinimumWhiteTilesAfterCoveringWithCarpets().new Solution();
        System.out.println(solution.minimumWhiteTiles("101111", 2, 3));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int length = floor.length();
        int[] whiteCounts = new int[length];
        int[] affections = new int[length];
        int whiteCount = 0;
        for (int i = 0; i < length + carpetLen; i++) {
            if (i < carpetLen) {
                whiteCount += (floor.charAt(i + carpetLen) - '0');
            } else {
                whiteCount -= (floor.charAt(i) - '0');
                whiteCounts[i - carpetLen] = whiteCount;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = Math.max(0, i - carpetLen); j < Math.min(length, i + carpetLen); j++) {
                affections[i] += whiteCounts[j];
            }
        }
        return 0;
    }
    //这种写法没有考虑占用后影响范围问题，直接取第一个最大值
    public int minimumWhiteTiles1(String floor, int numCarpets, int carpetLen) {
        boolean[] floors = new boolean[floor.length()];
        int i = 0;
        for (char c : floor.toCharArray()) {
            floors[i++] = '1' == c;
        }
        while (numCarpets-->0) {
            int preMax = 0;
            int preMaxTrueCount = 0;
            for (int j = 0; j < carpetLen; j++) {
                if (floors[j]) preMaxTrueCount++;
            }
            int preTrueCount = preMaxTrueCount;
            for (int j = carpetLen; j < floors.length; j++) {
                boolean left = floors[j - carpetLen];
                boolean right = floors[j];
                if (left) preTrueCount--;
                if (right) preTrueCount++;
                if (preTrueCount > preMaxTrueCount) {
                    preMaxTrueCount = preTrueCount;
                    preMax = j - carpetLen + 1;
                    if (preTrueCount == carpetLen) break;
                }
            }
            for (int j = preMax; j < preMax + carpetLen; j++) {
                floors[j] = false;
            }
        }
        int result = 0;
        for (boolean b : floors) {
            if (b) result++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}