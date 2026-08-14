<p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。</p>

<p>请必须使用时间复杂度为 <code>O(log n)</code> 的算法。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,3,5,6], target = 5
<strong>输出:</strong> 2
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,3,5,6], target = 2
<strong>输出:</strong> 1
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,3,5,6], target = 7
<strong>输出:</strong> 4
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> 为&nbsp;<strong>无重复元素&nbsp;</strong>的&nbsp;<strong>升序&nbsp;</strong>排列数组</li> 
 <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 2717, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题就是考察搜索左侧边界的二分算法的细节理解，前文 [二分搜索详解](https://labuladong.online/algo/essential-technique/binary-search-framework/) 着重讲了数组中存在目标元素重复的情况，没仔细讲目标元素不存在的情况。

**当目标元素 `target` 不存在数组 `nums` 中时，搜索左侧边界的二分搜索的返回值可以做以下几种解读**：

1、返回的这个值是 `nums` 中大于等于 `target` 的最小元素索引。

2、返回的这个值是 `target` 应该插入在 `nums` 中的索引位置。

3、返回的这个值是 `nums` 中小于 `target` 的元素个数。

比如在有序数组 `nums = [2,3,5,7]` 中搜索 `target = 4`，搜索左边界的二分算法会返回 2，你带入上面的说法，都是对的。

所以以上三种解读都是等价的，可以根据具体题目场景灵活运用，显然这里我们需要的是第二种。

**详细题解**：
  - [【练习】二分搜索算法经典习题](https://labuladong.online/algo/problem-set/binary-search/)

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
    int searchInsert(vector<int>& nums, int target) {
        return left_bound(nums, target);
    }

    // 搜索左侧边界的二分算法
    int left_bound(vector<int>& nums, int target) {
        if (nums.size() == 0) return -1;
        int left = 0;
        // 注意
        int right = nums.size();

        // 注意
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 注意
                right = mid;
            }
        }
        return left;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        return self.left_bound(nums, target)

    # 搜索左侧边界的二分算法
    def left_bound(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        left = 0
        # 注意
        right = len(nums)

        # 注意
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                right = mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                # 注意
                right = mid
        return left
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        return left_bound(nums, target);
    }

    // 搜索左侧边界的二分算法
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        // 注意
        int right = nums.length;

        // 注意
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 注意
                right = mid;
            }
        }
        return left;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func searchInsert(nums []int, target int) int {
    return leftBound(nums, target)
}

// 搜索左侧边界的二分算法
func leftBound(nums []int, target int) int {
    if len(nums) == 0 {
        return -1
    }
    left := 0
    // 注意
    right := len(nums)

    // 注意
    for left < right {
        mid := left + (right - left) / 2
        if nums[mid] == target {
            right = mid
        } else if nums[mid] < target {
            left = mid + 1
        } else if nums[mid] > target {
            // 注意
            right = mid
        }
    }
    return left
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var searchInsert = function(nums, target) {
    // 搜索左侧边界的二分算法
    function left_bound(nums, target) {
        if (nums.length === 0) return -1;
        let left = 0;
        // 注意
        let right = nums.length;

        // 注意
        while (left < right) {
            let mid = left + Math.floor((right - left) / 2);
            if (nums[mid] === target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 注意
                right = mid;
            }
        }
        return left;
    }

    return left_bound(nums, target);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_search-insert-position"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_search-insert-position"></div></div>
</details><hr /><br />

</div>
</details>
</div>

