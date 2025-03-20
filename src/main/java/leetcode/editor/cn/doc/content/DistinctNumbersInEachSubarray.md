<p>给你一个长度为&nbsp;<code>n</code>&nbsp;的整数数组&nbsp;<code>nums</code>&nbsp;与一个整数 <code>k</code>。你的任务是找到&nbsp;<code>nums</code>&nbsp;<strong>所有</strong>&nbsp;长度为&nbsp;<code>k</code>&nbsp;的子数组中&nbsp;<strong>不同</strong>&nbsp;元素的数量。</p>

<p>返回一个数组 <code>ans</code>，其中&nbsp;<code>ans[i]</code>&nbsp;是对于每个索引&nbsp;<code>0 &lt;= i &lt; n - k</code>，<code>nums[i..(i + k - 1)]</code>&nbsp;中不同元素的数量。</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,2,3,2,2,1,3], k = 3
<strong>输出:</strong> [3,2,2,2,3]
<b>解释</b>：每个子数组的数字种类计算方法如下：
- nums[0..2] = [1,2,3] 所以 ans[0] = 3
- nums[1..3] = [2,3,2] 所以 ans[1] = 2
- nums[2..4] = [3,2,2] 所以 ans[2] = 2
- nums[3..5] = [2,2,1] 所以 ans[3] = 2
- nums[4..6] = [2,1,3] 所以 ans[4] = 3
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,1,1,1,2,3,4], k = 4
<strong>输出:</strong> [1,2,3,4]
<strong>解释: </strong>每个子数组的数字种类计算方法如下：
- nums[0..3] = [1,1,1,1] 所以 ans[0] = 1
- nums[1..4] = [1,1,1,2] 所以 ans[1] = 2
- nums[2..5] = [1,1,2,3] 所以 ans[2] = 3
- nums[3..6] = [1,2,3,4] 所以 ans[3] = 4
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>滑动窗口</li></div></div><br><div><li>👍 15</li><li>👎 0</li></div>