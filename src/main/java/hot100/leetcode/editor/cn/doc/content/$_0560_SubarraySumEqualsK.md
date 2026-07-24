<p>给你一个整数数组 <code>nums</code> 和一个整数&nbsp;<code>k</code> ，请你统计并返回 <em>该数组中和为&nbsp;<code>k</code><strong>&nbsp;</strong>的子数组的个数&nbsp;</em>。</p>

<p>子数组是数组中元素的连续非空序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1], k = 2
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], k = 3
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li> 
 <li><code>-10<sup>7</sup> &lt;= k &lt;= 10<sup>7</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 前缀和</details><br>

<div>👍 3204, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

很多读者看到这个题，忍不住就想用 [滑动窗口框架模板](https://labuladong.online/algo/essential-technique/sliding-window-framework/) 对吧？

这很好，说明你对滑动窗口算法已经有感觉了。我在框架模板总结中说过，用滑动窗口算要问自己三个问题：

1、什么时候扩大窗口？当窗口内的元素和小于 k 时，就扩大窗口。

2、什么时候缩小窗口？当窗口内的元素和大于 k 时，就缩小窗口。

3、什么时候找到答案？当窗口内的元素和等于 k 时，就找到了答案。

看起来很合理，结合这个思路和滑动窗口代码模板，你应该五分钟之内就能写出解法。

但是我想说，这道题不能用滑动窗口，因为你忽略了一个隐含前提：

当窗口内的元素和小于 k 时，你为什么想扩大窗口？因为你默认扩大窗口能让窗口内的元素和变大。

同理，当窗口内的元素和大于 k 时，你为什么想缩小窗口？因为你默认缩小窗口能让窗口内的元素和变小。

但是上述前提在这道题并不成立，因为数组中包含负数。

所以，这道题其实在考察 [前缀和技巧](https://labuladong.online/algo/data-structure/prefix-sum/) 和哈希表的结合使用，请你先解决 [✨523. 连续的子数组和](/problems/continuous-subarray-sum/) 和 [✔ ✨525. 连续数组](/problems/contiguous-array/)，然后这道题就很容易解决了。

本题和前两题的最大区别在于，需要在维护 `preSum` 前缀和数组的同时动态维护 `count` 映射，而不能等到 `preSum` 计算完成后再处理 `count`，因为 `count[need]` 应该维护 `preSum[0..i]` 中值为 `need` 的元素个数。

结合前两题的思路，本题思路看代码注释吧。

> PS：我给出的代码是保留 `preSum` 数组的，实际上你发现我们一直在访问最新的 `preSum[i]`，根本不需要 `i` 之前的前缀和，所以实际上我们根本不需要一整个 `preSum` 数组，只要维护一个变量记录最新的前缀和就行了，这个优化就留给你去做吧。

**详细题解**：
  - [【练习】前缀和技巧经典习题](https://labuladong.online/algo/problem-set/perfix-sum/)

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

#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int n = nums.size();
        // 前缀和数组
        vector<int> preSum(n + 1, 0);
        // 前缀和到该前缀和出现次数的映射，方便快速查找所需的前缀和
        unordered_map<int, int> count;
        count[0] = 1;
        // 记录和为 k 的子数组个数
        int res = 0;

        // 计算 nums 的前缀和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            // 如果之前存在值为 need 的前缀和
            // 说明存在以 nums[i-1] 结尾的子数组的和为 k
            int need = preSum[i] - k;
            if (count.find(need) != count.end()) {
                res += count[need];
            }
            // 将当前前缀和存入哈希表
            count[preSum[i]]++;
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        # 前缀和数组
        preSum = [0] * (n + 1)
        preSum[0] = 0
        # 前缀和到该前缀和出现次数的映射，方便快速查找所需的前缀和
        count = {0: 1}
        # 记录和为 k 的子数组个数
        res = 0

        # 计算 nums 的前缀和
        for i in range(1, n + 1):
            preSum[i] = preSum[i - 1] + nums[i - 1]
            # 如果之前存在值为 need 的前缀和
            # 说明存在以 nums[i-1] 结尾的子数组的和为 k
            need = preSum[i] - k
            if need in count:
                res += count[need]
            # 将当前前缀和存入哈希表
            if preSum[i] not in count:
                count[preSum[i]] = 1
            else:
                count[preSum[i]] = count[preSum[i]] + 1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和数组
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        // 前缀和到该前缀和出现次数的映射，方便快速查找所需的前缀和
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        // 记录和为 k 的子数组个数
        int res = 0;

        // 计算 nums 的前缀和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            // 如果之前存在值为 need 的前缀和
            // 说明存在以 nums[i-1] 结尾的子数组的和为 k
            int need = preSum[i] - k;
            if (count.containsKey(need)) {
                res += count.get(need);
            }
            // 将当前前缀和存入哈希表
            if (!count.containsKey(preSum[i])) {
                count.put(preSum[i], 1);
            } else {
                count.put(preSum[i], count.get(preSum[i]) + 1);
            }
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func subarraySum(nums []int, k int) int {
    n := len(nums)
    // 前缀和数组
    preSum := make([]int, n+1)
    preSum[0] = 0
    // 前缀和到该前缀和出现次数的映射，方便快速查找所需的前缀和
    count := make(map[int]int)
    count[0] = 1
    // 记录和为 k 的子数组个数
    res := 0

    // 计算 nums 的前缀和
    for i := 1; i <= n; i++ {
        preSum[i] = preSum[i-1] + nums[i-1]
        // 如果之前存在值为 need 的前缀和
        // 说明存在以 nums[i-1] 结尾的子数组的和为 k
        need := preSum[i] - k
        if val, ok := count[need]; ok {
            res += val
        }
        // 将当前前缀和存入哈希表
        count[preSum[i]]++
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var subarraySum = function(nums, k) {
    let n = nums.length;
    // 前缀和数组
    let preSum = new Array(n + 1).fill(0);
    // 前缀和到该前缀和出现次数的映射，方便快速查找所需的前缀和
    let count = new Map();
    count.set(0, 1);
    // 记录和为 k 的子数组个数
    let res = 0;

    // 计算 nums 的前缀和
    for (let i = 1; i <= n; i++) {
        preSum[i] = preSum[i - 1] + nums[i - 1];
        // 如果之前存在值为 need 的前缀和
        // 说明存在以 nums[i-1] 结尾的子数组的和为 k
        let need = preSum[i] - k;
        if (count.has(need)) {
            res += count.get(need);
        }
        // 将当前前缀和存入哈希表
        if (!count.has(preSum[i])) {
            count.set(preSum[i], 1);
        } else {
            count.set(preSum[i], count.get(preSum[i]) + 1);
        }
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_subarray-sum-equals-k"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_subarray-sum-equals-k"></div></div>
</details><hr /><br />

</div>
</details>
</div>

