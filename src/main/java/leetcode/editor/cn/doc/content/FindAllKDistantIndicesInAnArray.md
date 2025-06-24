<p>给你一个下标从 <strong>0</strong> 开始的整数数组 <code>nums</code> 和两个整数 <code>key</code> 和 <code>k</code> 。<strong>K 近邻下标</strong> 是 <code>nums</code> 中的一个下标 <code>i</code> ，并满足至少存在一个下标 <code>j</code> 使得 <code>|i - j| &lt;= k</code> 且 <code>nums[j] == key</code> 。</p>

<p>以列表形式返回按 <strong>递增顺序</strong> 排序的所有 K 近邻下标。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,4,9,1,3,9,5], key = 9, k = 1
<strong>输出：</strong>[1,2,3,4,5,6]
<strong>解释：</strong>因此，<span><code>nums[2] == key</code></span> 且 <span><code>nums[5] == key</code></span>。
- 对下标 0 ，<span><code>|0 - 2| &gt; k</code></span> 且 <span><code>|0 - 5| &gt; k</code></span>，所以不存在 <span><code>j</code></span> 使得 <span><code>|0 - j| &lt;= k</code></span> 且 <span><code>nums[j] == key</code></span>。所以 0 不是一个 K 近邻下标。
- 对下标 1 ，<span><code>|1 - 2| &lt;= k</code></span> 且 <span><code>nums[2] == key</code></span>，所以 1 是一个 K 近邻下标。
- 对下标 2 ，<span><code>|2 - 2| &lt;= k</code></span> 且 <span><code>nums[2] == key</code></span>，所以 2 是一个 K 近邻下标。
- 对下标 3 ，<span><code>|3 - 2| &lt;= k</code></span> 且 <span><code>nums[2] == key</code></span>，所以 3 是一个 K 近邻下标。
- 对下标 4 ，<span><code>|4 - 5| &lt;= k</code></span> 且 <span><code>nums[5] == key</code></span>，所以 4 是一个 K 近邻下标。
- 对下标 5 ，<span><code>|5 - 5| &lt;= k</code></span> 且 <span><code>nums[5] == key</code></span>，所以 5 是一个 K 近邻下标。
- 对下标 6 ，<span><code>|6 - 5| &lt;= k</code></span> 且 <span><code>nums[5] == key</code></span>，所以 6 是一个 K 近邻下标。
因此，按递增顺序返回 [1,2,3,4,5,6] 。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,2,2,2,2], key = 2, k = 2
<strong>输出：</strong>[0,1,2,3,4]
<strong>解释：</strong>对 <span><code>nums</code></span> 的所有下标 i ，总存在某个下标 j 使得 <span><code>|i - j| &lt;= k</code></span> 且 <span><code>nums[j] == key</code></span>，所以每个下标都是一个 K 近邻下标。 
因此，返回 [0,1,2,3,4] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 1000</code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 1000</code></li> 
 <li><code>key</code> 是数组 <code>nums</code> 中的一个整数</li> 
 <li><code>1 &lt;= k &lt;= nums.length</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 39</li><li>👎 0</li></div>