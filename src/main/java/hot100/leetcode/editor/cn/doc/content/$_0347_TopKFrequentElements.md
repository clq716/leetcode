<p>给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> ，请你返回其中出现频率前 <code>k</code> 高的元素。你可以按 <strong>任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>nums = [1,1,1,2,2,3], k = 2</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">[1,2]</span></p>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>nums = [1], k = 1</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>[1]</span></p>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>nums = [1,2,1,2,1,2,3,1,3,2], k = 2</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">[1,2]</span></p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>4</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>k</code> 的取值范围是 <code>[1, 数组中不相同的元素的个数]</code></li> 
 <li>题目数据保证答案唯一，换句话说，数组中前 <code>k</code> 个高频元素的集合是唯一的</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你所设计算法的时间复杂度 <strong>必须</strong> 优于 <code>O(n log n)</code> ，其中 <code>n</code><em>&nbsp;</em>是数组大小。</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 分治 | 桶排序 | 计数 | 快速选择 | 排序 | 堆（优先队列）</details><br>

<div>👍 2220, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

首先，肯定要用一个 `valToFreq` 哈希表把每个元素出现的频率计算出来。

然后，这道题就变成了 [✨215. 数组中的第 K 个最大元素](/problems/kth-largest-element-in-an-array/)，只不过第 215 题让你求数组中元素值 `e` 排在第 `k` 大的那个元素，这道题让你求数组中元素值 `valToFreq[e]` 排在前 `k` 个的元素。

我在 [快速排序详解及运用](https://labuladong.online/algo/practice-in-action/quick-sort/) 中讲过第 215 题，可以用 [优先级队列](https://labuladong.online/algo/data-structure-basic/binary-heap-basic/) 或者快速选择算法解决这道题。这里稍微改一下优先级队列的比较函数，或者改一下快速选择算法中的逻辑即可。

这里我再加一种解法，用计数排序的方式找到前 `k` 个高频元素，见代码。

**详细题解**：
  - [【练习】优先级队列经典习题](https://labuladong.online/algo/problem-set/binary-heap/)

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

// 用优先级队列解决这道题
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        // nums 中的元素 -> 该元素出现的频率
        unordered_map<int, int> valToFreq;
        for (int v : nums) {
            valToFreq[v]++;
        }

        auto cmp = [](pair<int, int>& entry1, pair<int, int>& entry2) {
            // 队列按照键值对中的值（元素出现频率）从小到大排序
            return entry1.second > entry2.second;
        };
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(cmp)> pq(cmp);

        for (auto& entry : valToFreq) {
            pq.push(entry);
            if (pq.size() > k) {
                // 弹出最小元素，维护队列内是 k 个频率最大的元素
                pq.pop();
            }
        }

        vector<int> res(k);
        for (int i = k - 1; i >= 0; i--) {
            // res 数组中存储前 k 个最大元素
            res[i] = pq.top().first;
            pq.pop();
        }

        return res;
    }
};

// 用计数排序的方法解决这道题
class Solution2 {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        // nums 中的元素 -> 该元素出现的频率
        unordered_map<int, int> valToFreq;
        for (int v : nums) {
            valToFreq[v]++;
        }

        // 频率 -> 这个频率有哪些元素
        vector<vector<int>> freqToVals(nums.size() + 1);
        for (auto& entry : valToFreq) {
            int freq = entry.second;
            freqToVals[freq].push_back(entry.first);
        }

        vector<int> res(k);
        int p = 0;
        // freqToVals 从后往前存储着出现最多的元素
        for (int i = freqToVals.size() - 1; i > 0; i--) {
            for (int val : freqToVals[i]) {
                // 将出现次数最多的 k 个元素装入 res
                res[p] = val;
                p++;
                if (p == k) {
                    return res;
                }
            }
        }

        return {};
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

from typing import List
import heapq
from collections import Counter

class Solution:
    # 用优先级队列解决这道题
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # nums 中的元素 -> 该元素出现的频率
        val_to_freq = Counter(nums)

        # 队列按照键值对中的值（元素出现频率）从小到大排序
        # Initialize a min-heap
        pq = []
        for num, freq in val_to_freq.items():
            heapq.heappush(pq, (freq, num))
            # 弹出最小元素，维护队列内是 k 个频率最大的元素
            if len(pq) > k:
                heapq.heappop(pq)

        # res 数组中存储前 k 个最大元素
        res = []
        while pq:
            res.append(heapq.heappop(pq)[1])
        return res[::-1]

class Solution2:
    # 用计数排序的方法解决这道题
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # nums 中的元素 -> 该元素出现的频率
        val_to_freq = Counter(nums)

        # 频率 -> 这个频率有哪些元素
        freq_to_vals = [[] for _ in range(len(nums) + 1)]
        for num, freq in val_to_freq.items():
            freq_to_vals[freq].append(num)

        # freqToVals 从后往前存储着出现最多的元素
        res = []
        for i in range(len(freq_to_vals) - 1, 0, -1):
            for val in freq_to_vals[i]:
                # 将出现次数最多的 k 个元素装入 res
                res.append(val)
                if len(res) == k:
                    return res
        return None
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 用优先级队列解决这道题
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // nums 中的元素 -> 该元素出现的频率
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        for (int v : nums) {
            valToFreq.put(v, valToFreq.getOrDefault(v, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>>
                pq = new PriorityQueue<>((entry1, entry2) -> {
            // 队列按照键值对中的值（元素出现频率）从小到大排序
            return entry1.getValue().compareTo(entry2.getValue());
        });

        for (Map.Entry<Integer, Integer> entry : valToFreq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                // 弹出最小元素，维护队列内是 k 个频率最大的元素
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            // res 数组中存储前 k 个最大元素
            res[i] = pq.poll().getKey();
        }

        return res;
    }
}

// 用计数排序的方法解决这道题
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        // nums 中的元素 -> 该元素出现的频率
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        for (int v : nums) {
            valToFreq.put(v, valToFreq.getOrDefault(v, 0) + 1);
        }

        // 频率 -> 这个频率有哪些元素
        ArrayList<Integer>[] freqToVals = new ArrayList[nums.length + 1];
        for (int val : valToFreq.keySet()) {
            int freq = valToFreq.get(val);
            if (freqToVals[freq] == null) {
                freqToVals[freq] = new ArrayList<>();
            }
            freqToVals[freq].add(val);
        }

        int[] res = new int[k];
        int p = 0;
        // freqToVals 从后往前存储着出现最多的元素
        for (int i = freqToVals.length - 1; i > 0; i--) {
            ArrayList<Integer> valList = freqToVals[i];
            if (valList == null) continue;
            for (int j = 0; j < valList.size(); j++) {
                // 将出现次数最多的 k 个元素装入 res
                res[p] = valList.get(j);
                p++;
                if (p == k) {
                    return res;
                }
            }
        }

        return null;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 用优先级队列解决这道题
func topKFrequent(nums []int, k int) []int {
    // nums 中的元素 -> 该元素出现的频率
    valToFreq := make(map[int]int)
    for _, v := range nums {
        valToFreq[v]++
    }

    pq := &PriorityQueue{}
    heap.Init(pq)

    for key, value := range valToFreq {
        heap.Push(pq, &Element{key, value})
        if pq.Len() > k {
            // 弹出最小元素，维护队列内是 k 个频率最大的元素
            heap.Pop(pq)
        }
    }

    res := make([]int, k)
    for i := k - 1; i >= 0; i-- {
        // res 数组中存储前 k 个最大元素
        res[i] = heap.Pop(pq).(*Element).value
    }

    return res
}

type Element struct {
    value    int
    priority int
}

type PriorityQueue []*Element

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
    // 队列按照键值对中的值（元素出现频率）从小到大排序
    return pq[i].priority < pq[j].priority
}

func (pq PriorityQueue) Swap(i, j int) {
    pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
    *pq = append(*pq, x.(*Element))
}

func (pq *PriorityQueue) Pop() interface{} {
    old := *pq
    n := len(old)
    item := old[n-1]
    *pq = old[0 : n-1]
    return item
}

// 用计数排序的方法解决这道题
func topKFrequent2(nums []int, k int) []int {
    // nums 中的元素 -> 该元素出现的频率
    valToFreq := make(map[int]int)
    for _, v := range nums {
        valToFreq[v]++
    }

    // 频率 -> 这个频率有哪些元素
    freqToVals := make([][]int, len(nums)+1)
    for val, freq := range valToFreq {
        freqToVals[freq] = append(freqToVals[freq], val)
    }

    res := make([]int, k)
    p := 0
    // freqToVals 从后往前存储着出现最多的元素
    for i := len(freqToVals) - 1; i > 0; i-- {
        for _, val := range freqToVals[i] {
            // 将出现次数最多的 k 个元素装入 res
            res[p] = val
            p++
            if p == k {
                return res
            }
        }
    }

    return nil
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 用优先级队列解决这道题
var topKFrequent = function(nums, k) {
    // nums 中的元素 -> 该元素出现的频率
    let valToFreq = new Map();
    for (let v of nums) {
        valToFreq.set(v, (valToFreq.get(v) || 0) + 1);
    }

    let pq = new PriorityQueue((entry1, entry2) => {
        // 队列按照键值对中的值（元素出现频率）从小到大排序
        return entry1[1] - entry2[1];
    });

    for (let entry of valToFreq.entries()) {
        pq.enqueue(entry);
        if (pq.size() > k) {
            // 弹出最小元素，维护队列内是 k 个频率最大的元素
            pq.dequeue();
        }
    }

    let res = new Array(k);
    for (let i = k - 1; i >= 0; i--) {
        // res 数组中存储前 k 个最大元素
        res[i] = pq.dequeue()[0];
    }

    return res;
};

// 用计数排序的方法解决这道题
var topKFrequent2 = function(nums, k) {
    // nums 中的元素 -> 该元素出现的频率
    let valToFreq = new Map();
    for (let v of nums) {
        valToFreq.set(v, (valToFreq.get(v) || 0) + 1);
    }

    // 频率 -> 这个频率有哪些元素
    let freqToVals = new Array(nums.length + 1).fill(null).map(() => []);
    for (let [val, freq] of valToFreq.entries()) {
        freqToVals[freq].push(val);
    }

    let res = new Array(k);
    let p = 0;
    // freqToVals 从后往前存储着出现最多的元素
    for (let i = freqToVals.length - 1; i > 0; i--) {
        let valList = freqToVals[i];
        if (valList.length === 0) continue;
        for (let j = 0; j < valList.length; j++) {
            // 将出现次数最多的 k 个元素装入 res
            res[p] = valList[j];
            p++;
            if (p === k) {
                return res;
            }
        }
    }

    return null;
};
```

</div></div>
</div></div>

</div>
</details>
</div>

