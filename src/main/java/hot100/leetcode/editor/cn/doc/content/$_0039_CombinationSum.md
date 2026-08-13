<p>给你一个 <strong>无重复元素</strong> 的整数数组&nbsp;<code>candidates</code> 和一个目标整数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中可以使数字和为目标数&nbsp;<code>target</code> 的 所有<em>&nbsp;</em><strong>不同组合</strong> ，并以列表形式返回。你可以按 <strong>任意顺序</strong> 返回这些组合。</p>

<p><code>candidates</code> 中的 <strong>同一个</strong> 数字可以 <strong>无限制重复被选取</strong> 。如果至少一个数字的被选数量不同，则两种组合是不同的。&nbsp;</p>

<p>对于给定的输入，保证和为&nbsp;<code>target</code> 的不同组合数少于 <code>150</code> 个。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>candidates = [2,3,6,7], target = 7
<strong>输出：</strong>[[2,2,3],[7]]
<strong>解释：</strong>
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入: </strong>candidates = [2,3,5], target = 8
<strong>输出: </strong>[[2,2,2,2],[2,3,3],[3,5]]</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入: </strong>candidates = [2], target = 1
<strong>输出: </strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= candidates.length &lt;= 30</code></li> 
 <li><code>2 &lt;= candidates[i] &lt;= 40</code></li> 
 <li><code>candidates</code> 的所有元素 <strong>互不相同</strong></li> 
 <li><code>1 &lt;= target &lt;= 40</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>

<div>👍 3238, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

你需要先看前文 [回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 和 [回溯算法团灭子集、排列、组合问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/)，然后看这道题就很简单了，无非是回溯算法的运用而已。

这道题的关键在于 `candidates` 中的元素可以复用多次，体现在代码中是下面这段：

```java
void backtrack(int[] candidates, int start, int target, int sum) {
    // 回溯算法框架
    for (int i = start; i < candidates.length; i++) {
        // 选择 candidates[i]
        backtrack(candidates, i, target, sum);
        // 撤销选择 candidates[i]
    }
}
```

对比 [回溯算法团灭子集、排列、组合问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/) 中不能重复使用元素的标准组合问题：

```java
void backtrack(int[] candidates, int start, int target, int sum) {
    // 回溯算法框架
    for (int i = start; i < candidates.length; i++) {
        // 选择 candidates[i]
        backtrack(candidates, i + 1, target, sum);
        // 撤销选择 candidates[i]
    }
}
```

体会到控制是否重复使用元素的关键了吗？

**详细题解**：
  - [回溯算法秒杀所有排列/组合/子集问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/)

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
    vector<vector<int>> res;

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if (candidates.empty()) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }

    // 记录回溯的路径
    vector<int> track;

    // 回溯算法主函数
    void backtrack(vector<int>& candidates, int start, int target, int sum) {
        if (sum == target) {
            // 找到目标和
            res.push_back(track);
            return;
        }

        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (int i = start; i < candidates.size(); i++) {
            // 选择 candidates[i]
            track.push_back(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(candidates, i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.pop_back();
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def __init__(self):
        self.res = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return self.res
        self.backtrack(candidates, 0, target, 0)
        return self.res

    # 记录回溯的路径
    track = []

    # 回溯算法主函数
    def backtrack(self, candidates: List[int], start: int, target: int, sum: int) -> None:
        if sum == target:
            # 找到目标和
            self.res.append(self.track.copy())
            return
        if sum > target:
            # 超过目标和，直接结束
            return

        # 回溯算法框架
        for i in range(start, len(candidates)):
            # 选择 candidates[i]
            self.track.append(candidates[i])
            sum += candidates[i]
            # 递归遍历下一层回溯树
            self.backtrack(candidates, i, target, sum)
            # 撤销选择 candidates[i]
            sum -= candidates[i]
            self.track.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }

    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();

    // 回溯算法主函数
    void backtrack(int[] candidates, int start, int target, int sum) {
        if (sum == target) {
            // 找到目标和
            res.add(new LinkedList<>(track));
            return;
        }

        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (int i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            track.add(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(candidates, i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.removeLast();
        }
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

// combinationSum ...
func combinationSum(candidates []int, target int) [][]int {
	res := make([][]int, 0)
	backtrack(candidates, 0, target, 0, list.New(), &res)
	return res
}

// 记录回溯的路径
// 回溯算法主函数
func backtrack(candidates []int, start, target, sum int, track *list.List, res *[][]int) {
	if sum == target {
		// 找到目标和
		temp := make([]int, track.Len())
		for i, e := 0, track.Front(); e != nil; i, e = i+1, e.Next() {
			temp[i] = e.Value.(int)
		}
		*res = append(*res, temp)
		return
	}

	if sum > target {
		// 超过目标和，直接结束
		return
	}

	// 回溯算法框架
	for i := start; i < len(candidates); i++ {
		// 选择 candidates[i]
		track.PushBack(candidates[i])
		sum += candidates[i]
		// 递归遍历下一层回溯树
		backtrack(candidates, i, target, sum, track, res)
		// 撤销选择 candidates[i]
		sum -= candidates[i]
		track.Remove(track.Back())
	}
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var combinationSum = function(candidates, target) {
    // 记录所有可能的组合结果
    let res = [];
    // 记录回溯的路径
    let track = [];

    // 回溯算法主函数
    function backtrack(start, target, sum) {
        // 找到目标和
        if (sum === target) {
            res.push([...track]);
            return;
        }

        // 超过目标和，直接结束
        if (sum > target) {
            return;
        }

        // 回溯算法框架
        for (let i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            track.push(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.pop();
        }
    }

    backtrack(0, target, 0);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_combination-sum"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_combination-sum"></div></div>
</details><hr /><br />

</div>
</details>
</div>

