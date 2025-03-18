/**
<p>给你一个整数数组&nbsp;<code>arr</code>&nbsp;和两个整数 <code>k</code>&nbsp;和 <code>threshold</code>&nbsp;。</p>

<p>请你返回长度为 <code>k</code>&nbsp;且平均值大于等于&nbsp;<code>threshold</code>&nbsp;的子数组数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
<strong>输出：</strong>3
<strong>解释：</strong>子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
<strong>输出：</strong>6
<strong>解释：</strong>前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= arr.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= arr[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= k &lt;= arr.length</code></li> 
 <li><code>0 &lt;= threshold &lt;= 10<sup>4</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>滑动窗口</li></div></div><br><div><li>👍 89</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;
public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold{
    public static void main(String[] args) {
        Solution solution = new NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0, result = 0;
        threshold *= k;
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
            if (i < k-1) continue;
            if (ans >= threshold) result++;
            ans -= arr[i-k+1];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}