<p>整数数组 <code>nums</code> 按升序排列，数组中的值 <strong>互不相同</strong> 。</p>

<p>在传递给函数之前，<code>nums</code> 在预先未知的某个下标 <code>k</code>（<code>0 &lt;= k &lt; nums.length</code>）上进行了 <strong>向左旋转</strong>，使数组变为 <code>[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]</code>（下标 <strong>从 0 开始</strong> 计数）。例如， <code>[0,1,2,4,5,6,7]</code> 下标&nbsp;<code>3</code>&nbsp;上向左旋转后可能变为&nbsp;<code>[4,5,6,7,0,1,2]</code> 。</p>

<p>给你 <strong>旋转后</strong> 的数组 <code>nums</code> 和一个整数 <code>target</code> ，如果 <code>nums</code> 中存在这个目标值 <code>target</code> ，则返回它的下标，否则返回&nbsp;<code>-1</code>&nbsp;。</p>

<p>你必须设计一个时间复杂度为 <code>O(log n)</code> 的算法解决此问题。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [4,5,6,7,0,1,2], target = 0
<strong>输出：</strong>4
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>nums = [4,5,6,7,0,1,2], target = 3
<strong>输出：</strong>-1</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1], target = 0
<strong>输出：</strong>-1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 5000</code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> 中的每个值都 <strong>独一无二</strong></li> 
 <li>题目数据保证 <code>nums</code> 在预先未知的某个下标上进行了旋转</li> 
 <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 3447, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这是一道经典的二分搜索题目，只要把图画出来并且正确理解了前文 [二分搜索框架详解](https://labuladong.online/algo/essential-technique/binary-search-framework/)，难度不算大。

把一个排好序的数组就好比一段斜向上的山坡，沿着一个元素旋转数组，相当于将山坡切断并旋转，在原本平滑的山坡上产生一个「断崖」：

![](https://labuladong.online/algo/images/brief-extra/33_1.jpeg)

注意「断崖」左侧的所有元素比右侧所有元素都大，我们是可以在这样一个存在断崖的山坡上用二分搜索算法搜索元素的，主要分成两步：

**1、确定 `mid` 中点落在「断崖」左侧还是右侧**。

**2、在第 1 步确定的结果之上，根据 `target` 和 `nums[left], nums[right], nums[mid]` 的相对大小收缩搜索区间**。

具体来说，我们首先可以根据 `nums[mid]` 和 `nums[left]` 的相对大小确定 `mid` 和「断崖」的相对位置：

```java
if (nums[mid] >= nums[left]) {
    // mid 落在断崖左边，此时 nums[left..mid] 有序
} else {
    // mid 落在断崖右边，此时 nums[mid..right] 有序
}
```

![](https://labuladong.online/algo/images/brief-extra/33_2.jpeg)

假设 `mid` 在「断崖」左侧，那么可以肯定 `nums[left..mid]` 是连续且有序的，所以如果 `nums[left] <= target < nums[mid]`，则可以收缩右边界，否则应该收缩左边界。

假设 `mid` 在「断崖」右侧，那么可以肯定 `nums[mid..right]` 是连续且有序的，所以如果 `nums[mid] < target <= nums[right]`，则可以收缩左边界，否则应该收缩右边界。

有了这个思路，即可写出正确的代码，更多细节问题见注释。

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

#include <vector>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        // 左右都闭的搜索区间
        int left = 0, right = nums.size() - 1;
        // 因为是闭区间，所以结束条件为 left > right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 首先检查 nums[mid]，是否找到 target
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                // mid 落在断崖左边，此时 nums[left..mid] 有序
                if (target >= nums[left] && target < nums[mid]) {
                    // target 落在 [left..mid-1] 中
                    right = mid - 1;
                } else {
                    // target 落在 [mid+1..right] 中
                    left = mid + 1;
                }
            } else {
                // mid 落在断崖右边，此时 nums[mid..right] 有序
                if (target <= nums[right] && target > nums[mid]) {
                    // target 落在 [mid+1..right] 中
                    left = mid + 1;
                } else {
                    // target 落在 [left..mid-1] 中
                    right = mid - 1;
                }
            }
        }
        // while 结束还没找到，说明 target 不存在
        return -1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 左右都闭的搜索区间
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        # 因为是闭区间，所以结束条件为 left > right
        while left <= right:
            mid = left + (right - left) // 2
            # 首先检查 nums[mid]，是否找到 target
            if nums[mid] == target:
                return mid
            if nums[mid] >= nums[left]:
                # mid 落在断崖左边，此时 nums[left..mid] 有序
                if target >= nums[left] and target < nums[mid]:
                    # target 落在 [left..mid-1] 中
                    right = mid - 1
                else:
                    # target 落在 [mid+1..right] 中
                    left = mid + 1
            else:
                # mid 落在断崖右边，此时 nums[mid..right] 有序
                if target <= nums[right] and target > nums[mid]:
                    # target 落在 [mid+1..right] 中
                    left = mid + 1
                else:
                    # target 落在 [left..mid-1] 中
                    right = mid - 1
        # while 结束还没找到，说明 target 不存在
        return -1
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int search(int[] nums, int target) {
        // 左右都闭的搜索区间
        int left = 0, right = nums.length - 1;
        // 因为是闭区间，所以结束条件为 left > right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 首先检查 nums[mid]，是否找到 target
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                // mid 落在断崖左边，此时 nums[left..mid] 有序
                if (target >= nums[left] && target < nums[mid]) {
                    // target 落在 [left..mid-1] 中
                    right = mid - 1;
                } else {
                    // target 落在 [mid+1..right] 中
                    left = mid + 1;
                }
            } else {
                // mid 落在断崖右边，此时 nums[mid..right] 有序
                if (target <= nums[right] && target > nums[mid]) {
                    // target 落在 [mid+1..right] 中
                    left = mid + 1;
                } else {
                    // target 落在 [left..mid-1] 中
                    right = mid - 1;
                }
            }
        }
        // while 结束还没找到，说明 target 不存在
        return -1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func search(nums []int, target int) int {
    // 左右都闭的搜索区间
    left, right := 0, len(nums) - 1
    // 因为是闭区间，所以结束条件为 left > right
    for left <= right {
        mid := left + (right - left) / 2
        // 首先检查 nums[mid]，是否找到 target
        if nums[mid] == target {
            return mid
        }
        if nums[mid] >= nums[left] {
            // mid 落在断崖左边，此时 nums[left..mid] 有序
            if target >= nums[left] && target < nums[mid] {
                // target 落在 [left..mid-1] 中
                right = mid - 1
            } else {
                // target 落在 [mid+1..right] 中
                left = mid + 1
            }
        } else {
            // mid 落在断崖右边，此时 nums[mid..right] 有序
            if target <= nums[right] && target > nums[mid] {
                // target 落在 [mid+1..right] 中
                left = mid + 1
            } else {
                // target 落在 [left..mid-1] 中
                right = mid - 1
            }
        }
    }
    // while 结束还没找到，说明 target 不存在
    return -1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var search = function(nums, target) {
    // 左右都闭的搜索区间
    let left = 0, right = nums.length - 1;
    // 因为是闭区间，所以结束条件为 left > right
    while (left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        // 首先检查 nums[mid]，是否找到 target
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] >= nums[left]) {
            // mid 落在断崖左边，此时 nums[left..mid] 有序
            if (target >= nums[left] && target < nums[mid]) {
                // target 落在 [left..mid-1] 中
                right = mid - 1;
            } else {
                // target 落在 [mid+1..right] 中
                left = mid + 1;
            }
        } else {
            // mid 落在断崖右边，此时 nums[mid..right] 有序
            if (target <= nums[right] && target > nums[mid]) {
                // target 落在 [mid+1..right] 中
                left = mid + 1;
            } else {
                // target 落在 [left..mid-1] 中
                right = mid - 1;
            }
        }
    }
    // while 结束还没找到，说明 target 不存在
    return -1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_search-in-rotated-sorted-array"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_search-in-rotated-sorted-array"></div></div>
</details><hr /><br />

</div>
</details>
</div>

