/**
<p>给你一个长度为 <code>n</code> 的整数数组&nbsp;<code>nums</code><em>&nbsp;</em>和 一个目标值&nbsp;<code>target</code>。请你从 <code>nums</code><em> </em>中选出三个整数，使它们的和与&nbsp;<code>target</code>&nbsp;最接近。</p>

<p>返回这三个数的和。</p>

<p>假定每组输入只存在恰好一个解。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,2,1,-4], target = 1
<strong>输出：</strong>2
<strong>解释：</strong>与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,0], target = 1
<strong>输出：</strong>0
<strong>解释：</strong>与 target 最接近的和是 0（0 + 0 + 0 = 0）。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>3 &lt;= nums.length &lt;= 1000</code></li> 
 <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li> 
 <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 1738</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;

import java.util.Arrays;

public class _0016_ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new _0016_ThreeSumClosest().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int x = target - nums[i];
            int j = i + 1;
            int k = nums.length-1;
            while (j < k) {
                int distance = x - nums[j] - nums[k];
                if (Math.abs(distance) < Math.abs(delta)) delta = distance;
                if (distance == 0) {
                    return target;
                } else if (distance > 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return target - delta;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}