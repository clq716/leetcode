<p>给你一个整数数组 <code>nums</code>，有一个大小为&nbsp;<code>k</code><em>&nbsp;</em>的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 <code>k</code>&nbsp;个数字。滑动窗口每次只向右移动一位。</p>

<p>返回 <em>滑动窗口中的最大值 </em>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [1,3,-1,-3,5,3,6,7], k = 3
<b>输出：</b>[3,3,5,5,6,7]
<b>解释：</b>
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       <strong>3</strong>
 1 [3  -1  -3] 5  3  6  7       <strong>3</strong>
 1  3 [-1  -3  5] 3  6  7      <strong> 5</strong>
 1  3  -1 [-3  5  3] 6  7       <strong>5</strong>
 1  3  -1  -3 [5  3  6] 7       <strong>6</strong>
 1  3  -1  -3  5 [3  6  7]      <strong>7</strong>
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [1], k = 1
<b>输出：</b>[1]
</pre>

<p>&nbsp;</p>

<p><b>提示：</b></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>4</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= k &lt;= nums.length</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>队列 | 数组 | 滑动窗口 | 单调队列 | 堆（优先队列）</details><br>

<div>👍 3527, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/monotonic-queue/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

> 我在 [✨155. 最小栈](/problems/min-stack/) 的思路中详细分析了动态集合中维护最值的「千古难题」，如果你没有做，可以先去做一下。我想请你结合这两道题仔细思考：队列和栈分别是如何解决最值维护问题的？

使用一个队列充当不断滑动的窗口，每次滑动记录其中的最大值：

![](https://labuladong.online/algo/images/monotonic-queue/1.png)

如何在 `O(1)` 时间计算最大值，只需要一个特殊的数据结构「单调队列」，`push` 方法依然在队尾添加元素，但是要把前面比自己小的元素都删掉，直到遇到更大的元素才停止删除。

![](https://labuladong.online/algo/images/monotonic-queue/3.png)

使用单调队列数据结构就能完成本题。

**详细题解**：
  - [单调队列结构解决滑动窗口问题](https://labuladong.online/algo/data-structure/monotonic-queue/)

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

// 单调队列的实现
class MonotonicQueue {
    deque<int> maxq;
public:
    void push(int n) {
        // 将小于 n 的元素全部删除
        while (!maxq.empty() && maxq.back() < n) {/**<extend down -250>![](https://labuladong.online/algo/images/monotonic-queue/3.png) */
            maxq.pop_back();
        }
        // 然后将 n 加入尾部
        maxq.push_back(n);
    }
    
    int max() {
        return maxq.front();
    }
    
    void pop(int n) {
        if (n == maxq.front()) {
            maxq.pop_front();
        }
    }
};

class Solution {
    public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        MonotonicQueue window;
        vector<int> res;
        
        for (int i = 0; i < nums.size(); i++) {
            if (i < k - 1) {
                // 先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {/**<extend up -100>![](https://labuladong.online/algo/images/monotonic-queue/1.png) */
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.push_back(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
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

class MonotonicQueue:
    def __init__(self):
        self.maxq = []
    
    def push(self, n):
        # 将小于 n 的元素全部删除
        while self.maxq and self.maxq[-1] < n: # <extend up -100>![](https://labuladong.online/algo/images/monotonic-queue/3.png) #
            self.maxq.pop()
        # 然后将 n 加入尾部
        self.maxq.append(n)
    
    def max(self):
        return self.maxq[0]
    
    def pop(self, n):
        if n == self.maxq[0]:
            self.maxq.pop(0)

class Solution(object):
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        window = MonotonicQueue()
        res = []
        
        for i in range(len(nums)):
            if i < k - 1:
                # 先填满窗口的前 k - 1
                window.push(nums[i])
            else: # <extend up -100>![](https://labuladong.online/algo/images/monotonic-queue/1.png) #
                # 窗口向前滑动，加入新数字
                window.push(nums[i])
                # 记录当前窗口的最大值
                res.append(window.max())
                # 移出旧数字
                window.pop(nums[i - k + 1])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 单调队列的实现
    class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();
        public void push(int n) {
            // 将小于 n 的元素全部删除
            while (!q.isEmpty() && q.getLast() < n) {/**<extend down -300>![](https://labuladong.online/algo/images/monotonic-queue/3.png) */
                q.pollLast();
            }
            // 然后将 n 加入尾部
            q.addLast(n);
        }

        public int max() {
            return q.getFirst();
        }

        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }

    // 解题函数的实现
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {/**<extend up -150>![](https://labuladong.online/algo/images/monotonic-queue/1.png) */
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        // 需要转成 int[] 数组再返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

import (
	"container/list"
)

type MonotonicQueue struct {
    maxq list.List
}

func (mq *MonotonicQueue) push(n int) {
    // 将小于 n 的元素全部删除
    for mq.maxq.Len() > 0 && mq.maxq.Back().Value.(int) < n {/**<extend down -250>![](https://labuladong.online/algo/images/monotonic-queue/3.png) */
        mq.maxq.Remove(mq.maxq.Back())
    }
    // 然后将 n 加入尾部
    mq.maxq.PushBack(n)
}

func (mq *MonotonicQueue) max() int {
    return mq.maxq.Front().Value.(int)
}

func (mq *MonotonicQueue) pop(n int) {
    if n == mq.maxq.Front().Value.(int) {
        mq.maxq.Remove(mq.maxq.Front())
    }
}

func maxSlidingWindow(nums []int, k int) []int {
    window := MonotonicQueue{maxq: list.List{}}
    res := []int{}

    for i := 0; i < len(nums); i++ {
        if i < k-1 {
            // 先填满窗口的前 k - 1
            window.push(nums[i])
        } else {
            /* <extend up -100>
            ![](https://labuladong.online/algo/images/monotonic-queue/1.png)
            */
            // 窗口向前滑动，加入新数字
            window.push(nums[i])
            // 记录当前窗口的最大值
            res = append(res, window.max())
            // 移出旧数字
            window.pop(nums[i-k+1])
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 单调队列的实现
class MonotonicQueue {
    constructor() {
        this.maxq = [];
    }

    push(n) {
        // 将小于 n 的元素全部删除
        while (this.maxq.length > 0 && this.maxq[this.maxq.length - 1] < n) {/**<extend down -250>![](https://labuladong.online/algo/images/monotonic-queue/3.png) */
            this.maxq.pop();
        }
        // 然后将 n 加入尾部
        this.maxq.push(n);
    }

    max() {
        return this.maxq[0];
    }

    pop(n) {
        if (n === this.maxq[0]) {
            this.maxq.shift();
        }
    }
}

function maxSlidingWindow(nums, k) {
    var window = new MonotonicQueue();
    var res = [];
    for (var i = 0; i < nums.length; i++) {
        if (i < k - 1) {
            // 先填满窗口的前 k - 1
            window.push(nums[i]);
        } else {/**<extend up -100>![](https://labuladong.online/algo/images/monotonic-queue/1.png) */
            // 窗口向前滑动，加入新数字
            window.push(nums[i]);
            // 记录当前窗口的最大值
            res.push(window.max());
            // 移出旧数字
            window.pop(nums[i - k + 1]);
        }
    }
    return res;
}
```

</div></div>
</div></div>

</div>
</details>
</div>

