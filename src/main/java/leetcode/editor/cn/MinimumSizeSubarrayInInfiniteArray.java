/**
<p>给你一个下标从 <strong>0</strong> 开始的数组 <code>nums</code> 和一个整数 <code>target</code> 。</p>

<p>下标从 <strong>0</strong> 开始的数组 <code>infinite_nums</code> 是通过无限地将 nums 的元素追加到自己之后生成的。</p>

<p>请你从 <code>infinite_nums</code> 中找出满足 <strong>元素和</strong> 等于&nbsp;<code>target</code> 的 <strong>最短</strong> 子数组，并返回该子数组的长度。如果不存在满足条件的子数组，返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], target = 5
<strong>输出：</strong>2
<strong>解释：</strong>在这个例子中 infinite_nums = [1,2,3,1,2,3,1,2,...] 。
区间 [1,2] 内的子数组的元素和等于 target = 5 ，且长度 length = 2 。
可以证明，当元素和等于目标值 target = 5 时，2 是子数组的最短长度。</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1,2,3], target = 4
<strong>输出：</strong>2
<strong>解释：</strong>在这个例子中 infinite_nums = [1,1,1,2,3,1,1,1,2,3,1,1,...].
区间 [4,5] 内的子数组的元素和等于 target = 4 ，且长度 length = 2 。
可以证明，当元素和等于目标值 target = 4 时，2 是子数组的最短长度。
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,4,6,8], target = 3
<strong>输出：</strong>-1
<strong>解释：</strong>在这个例子中 infinite_nums = [2,4,6,8,2,4,6,8,...] 。
可以证明，不存在元素和等于目标值 target = 3 的子数组。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= target &lt;= 10<sup>9</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li><li>滑动窗口</li></div></div><br><div><li>👍 42</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;
public class MinimumSizeSubarrayInInfiniteArray{
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarrayInInfiniteArray().new Solution();
        solution.minSizeSubarray(new int[]{5,5,4,1,2,2,2,3,2,4,2,5}, 56);
//        solution.minSizeSubarray(new int[]{1,1,1,2,3}, 4);

//        solution.minSizeSubarray(new int[]{18,3,11,19,7,16,6,7,3,6,18,9,9,1,14,17,15,14,12,10}, 7);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 分三种情况：
     * int total = 数组累加和;
     * int mod = target % total;
     * int cycles = target / total;
     * (Math.max(0,cycles-1))*nums.length
     * 1. 如果 cycles 大于等于1的话，则必须是从两侧向中间滑动,即必须经过 A(0) 和 A(N) 节点， target = mod+total
     * 2. 如果 cycles 等于0的话，则可以随意滑动
     * 3. 计算ans是在两个数组拼接的最短距离
     */
    public int minSizeSubarray(int[] nums, int target) {
        long total = 0;
        //1.计算数组总和
        for (int num : nums) total += num;
        //2.取模
        long mod = target % total;
        //3.如果目标值是总和
        int cycles = (int) (target / total);
        if (mod == 0) return cycles*nums.length;
        //4.额外权重
        int ext = Math.max(0, cycles-1) * nums.length;
        int ans = Integer.MAX_VALUE;
        target = (int) ( cycles > 0 ? (mod + total) : target);
        long sum = total;
        //由于存在数组整体 + 一部分头 + 一部分尾 的情况，所以这里最多遍历到 数组长度*3
        for (int l = 0, r = nums.length; r <  nums.length*(cycles > 0 ? 3 : 2); r++) {
            sum += nums[r%nums.length];
            while (sum >= target) {
                if (sum == target) {
                    ans = Math.min(ans,r-l+1);
                    break;
                }
                if (cycles > 0 && l > nums.length) break;
                sum -= nums[l++%nums.length];
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : (ext + ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}