/**
<p>您将获得一个 <strong>从0开始的</strong> 整数数组 <code>candies</code> ，其中 <code>candies[i]</code>&nbsp;表示第 <code>i</code> 个糖果的味道。你妈妈想让你和你妹妹分享这些糖果，给她 <code>k</code> 个 <strong>连续 </strong>的糖果，但你想保留尽可能多的糖果口味。<br /> 在与妹妹分享后，返回 <strong>最多</strong> 可保留的 <strong>独特</strong> 口味的糖果。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong> candies = [1,<u>2,2,3</u>,4,3], k = 3
<strong>输出:</strong> 3
<strong>解释:</strong>
将[1,3]（含[2,2,3]）范围内的糖果加入[2,2,3]口味。
你可以吃各种口味的糖果[1,4,3]。
有3种独特的口味，所以返回3。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> candies = [2,2,2,<u>2,3</u>,3], k = 2
<strong>输出:</strong> 2
<strong>解释:</strong>
在[3,4]范围内（含[2,3]）的糖果中加入[2,3]口味。
你可以吃各种口味的糖果[2,2,2,3]。
有两种独特的口味，所以返回2。
请注意，你也可以分享口味为[2,2]的糖果，吃口味为[2,2,3,3]的糖果。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> candies = [2,4,5], k = 0
<strong>输出:</strong> 3
<strong>解释:</strong>
你不必给任何糖果。
你可以吃各种口味的糖果[2,4,5]。
有3种独特的口味，所以返回3。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>0 &lt;= candies.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= candies[i] &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= k &lt;= candies.length</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>滑动窗口</li></div></div><br><div><li>👍 10</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NumberOfUniqueFlavorsAfterSharingKCandies{
    public static void main(String[] args) {
        Solution solution = new NumberOfUniqueFlavorsAfterSharingKCandies().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shareCandies(int[] candies, int k) {
        k = candies.length - k;
        if (k < 2) return k;
        int max = 0, h = k-1;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0, right = candies.length-1; h>=0; i++) {
            if (i < k) {
                cnt.put(candies[i], cnt.getOrDefault(candies[i], 0) + 1);
            } else {
                max = Math.max(cnt.size(), max);
                cnt.put(candies[right], cnt.getOrDefault(candies[right], 0) + 1);
                int left = cnt.get(candies[h]);
                if (left == 1) cnt.remove(candies[h]);
                else cnt.put(candies[h], left - 1);
                right--;
                h--;
            }
        }
        return Math.max(cnt.size(), max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}