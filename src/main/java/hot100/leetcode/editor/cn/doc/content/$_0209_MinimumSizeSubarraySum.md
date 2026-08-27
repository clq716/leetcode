<p>给定一个含有&nbsp;<code>n</code><strong>&nbsp;</strong>个正整数的数组和一个正整数 <code>target</code><strong> 。</strong></p>

<p>找出该数组中满足其总和大于等于<strong> </strong><code>target</code><strong> </strong>的长度最小的 <strong><span data-keyword="subarray-nonempty">子数组</span></strong>&nbsp;<code>[nums<sub>l</sub>, nums<sub>l+1</sub>, ..., nums<sub>r-1</sub>, nums<sub>r</sub>]</code> ，并返回其长度<strong>。</strong>如果不存在符合条件的子数组，返回 <code>0</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>target = 7, nums = [2,3,1,2,4,3]
<strong>输出：</strong>2
<strong>解释：</strong>子数组&nbsp;<span><code>[4,3]</code></span>&nbsp;是该条件下的长度最小的子数组。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>target = 4, nums = [1,4,4]
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>target = 11, nums = [1,1,1,1,1,1,1,1]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= target &lt;= 10<sup>9</sup></code></li> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong></p>

<ul> 
 <li>如果你已经实现<em> </em><code>O(n)</code> 时间复杂度的解法, 请尝试设计一个 <code>O(n log(n))</code> 时间复杂度的解法。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 前缀和 | 滑动窗口</details><br>

<div>👍 2722, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题是标准的滑动窗口算法，你只要看过前文 [滑动窗口算法框架](https://labuladong.online/algo/essential-technique/sliding-window-framework/) 就能轻松搞定。

不过需要强调的是，**题目说了 `nums` 数组中的元素都是正数，有了这个前提才能使用滑动窗口算法**，因为窗口扩大时窗口内元素之和必然增大，窗口缩小时窗口内元素之和必然减小。

如果 `nums` 数组中包含负数，则窗口扩大时元素和不见得就增大，窗口缩小时元素和不见得就减小，这种情况就不能单纯使用滑动窗口技巧了，可能需要混合动态规划和单调队列来做。

比如你可以去试试 [✨1425. 带限制的子序列和](/problems/constrained-subsequence-sum/)，[✨862. 和至少为 K 的最短子数组](/problems/shortest-subarray-with-sum-at-least-k/)，[✔ ✨53. 最大子序和](/problems/maximum-subarray/)。

**详细题解**：
  - [【练习】滑动窗口算法经典习题](https://labuladong.online/algo/problem-set/sliding-window/)

</div>





<div id="solution">

## 解法代码

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">cpp</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python</button>

<button data-tab-item="java" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">java</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item active" data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left = 0, right = 0;
        // 维护窗口内元素之和
        int windowSum = 0;
        int res = INT_MAX;

        while (right < nums.size()) {
            // 扩大窗口
            windowSum += nums[right];
            right++;
            while (windowSum >= target && left < right) {
                // 已经达到 target，缩小窗口，同时更新答案
                res = min(res, right - left);
                windowSum -= nums[left];
                left++;
            }
        }
        return res == INT_MAX ? 0 : res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left = 0
        right = 0
        # 维护窗口内元素之和
        windowSum = 0
        res = float('inf')

        while right < len(nums):
            # 扩大窗口
            windowSum += nums[right]
            right += 1
            while windowSum >= target and left < right:
                # 已经达到 target，缩小窗口，同时更新答案
                res = min(res, right - left)
                windowSum -= nums[left]
                left += 1

        return 0 if res == float('inf') else res
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        // 维护窗口内元素之和
        int windowSum = 0;
        int res = Integer.MAX_VALUE;

        while (right < nums.length) {
            // 扩大窗口
            windowSum += nums[right];
            right++;
            while (windowSum >= target && left < right) {
                // 已经达到 target，缩小窗口，同时更新答案
                res = Math.min(res, right - left);
                windowSum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func minSubArrayLen(target int, nums []int) int {
    left, right := 0, 0
    // 维护窗口内元素之和
    windowSum := 0
    res := math.MaxInt32

    for right < len(nums) {
        // 扩大窗口
        windowSum += nums[right]
        right++
        for windowSum >= target && left < right {
            // 已经达到 target，缩小窗口，同时更新答案
            res = min(res, right-left)
            windowSum -= nums[left]
            left++
        }
    }
    if res == math.MaxInt32 {
        return 0
    }
    return res
}

func min(x, y int) int {
    if x < y {
        return x
    }
    return y
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var minSubArrayLen = function(target, nums) {
    let left = 0, right = 0;
    // 维护窗口内元素之和
    let windowSum = 0;
    let res = Number.MAX_VALUE;

    while (right < nums.length) {
        // 扩大窗口
        windowSum += nums[right];
        right++;
        while (windowSum >= target && left < right) {
            // 已经达到 target，缩小窗口，同时更新答案
            res = Math.min(res, right - left);
            windowSum -= nums[left];
            left++;
        }
    }
    return res == Number.MAX_VALUE ? 0 : res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_minimum-size-subarray-sum"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-size-subarray-sum"></div></div>
</details><hr /><br />

</div>
</details>
</div>

