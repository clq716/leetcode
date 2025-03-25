/**
<p>几张卡牌<strong> 排成一行</strong>，每张卡牌都有一个对应的点数。点数由整数数组 <code>cardPoints</code> 给出。</p>

<p>每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 <code>k</code> 张卡牌。</p>

<p>你的点数就是你拿到手中的所有卡牌的点数之和。</p>

<p>给你一个整数数组 <code>cardPoints</code> 和整数 <code>k</code>，请你返回可以获得的最大点数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>cardPoints = [1,2,3,4,5,6,1], k = 3
<strong>输出：</strong>12
<strong>解释：</strong>第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>cardPoints = [2,2,2], k = 2
<strong>输出：</strong>4
<strong>解释：</strong>无论你拿起哪两张卡牌，可获得的点数总是 4 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>cardPoints = [9,7,7,9,7,7,9], k = 7
<strong>输出：</strong>55
<strong>解释：</strong>你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>cardPoints = [1,1000,1], k = 1
<strong>输出：</strong>1
<strong>解释：</strong>你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。 
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>cardPoints = [1,79,80,1,1,1,200,1], k = 3
<strong>输出：</strong>202
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= cardPoints.length &lt;= 10^5</code></li> 
 <li><code>1 &lt;= cardPoints[i] &lt;= 10^4</code></li> 
 <li><code>1 &lt;= k &lt;= cardPoints.length</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>前缀和</li><li>滑动窗口</li></div></div><br><div><li>👍 441</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;
public class MaximumPointsYouCanObtainFromCards{
    public static void main(String[] args) {
        Solution solution = new MaximumPointsYouCanObtainFromCards().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //这里套滑动窗口公式比较死板，复杂度为O(N)
        //实际可以遍历K值，写两个循环 (0 -> k) 和 (n-k -> n), 这样滑动复杂度为O(K)
        //另外由于是求和，可以将窗口进入和移出简化为一步 sum += nums[n-i]-nums[k-i];
        int ans = 0, sum = 0;
        for (int i = cardPoints.length-k; i < cardPoints.length + k; i++) {
            if (i < cardPoints.length) {
                sum += cardPoints[i];
                if (i < cardPoints.length - 1) continue;
            } else {
                sum += cardPoints[i-cardPoints.length];
            }
            ans = Math.max(ans, sum);
            if (i < cardPoints.length + k-1) sum -= cardPoints[i - k + 1];
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}