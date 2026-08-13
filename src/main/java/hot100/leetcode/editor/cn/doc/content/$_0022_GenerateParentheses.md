<p>数字 <code>n</code>&nbsp;代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 <strong>有效的 </strong>括号组合。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>["((()))","(()())","(())()","()(())","()()()"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>["()"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 8</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划 | 回溯 | 括号序列</details><br>

<div>👍 4129, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/generate-parentheses/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

本题可以改写为：

现在有 `2n` 个位置，每个位置可以放置字符 `(` 或者 `)`，组成的所有括号组合中，有多少个是合法的？

这就是典型的回溯算法提醒，暴力穷举就行了。

不过为了减少不必要的穷举，我们要知道合法括号串有以下性质：

**1、一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解**。

**2、对于一个「合法」的括号字符串组合 `p`，必然对于任何 ` 0 <= i < len(p)` 都有：子串 `p[0..i]` 中左括号的数量都大于或等于右括号的数量**。

因为从左往右算的话，肯定是左括号多嘛，到最后左右括号数量相等，说明这个括号组合是合法的。

用 `left` 记录还可以使用多少个左括号，用 `right` 记录还可以使用多少个右括号，就可以直接套用 [回溯算法套路框架](https://labuladong.online/algo/essential-technique/backtrack-framework/) 了。

**详细题解**：
  - [回溯算法实践：括号生成](https://labuladong.online/algo/practice-in-action/generate-parentheses/)

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
private:
    // 回溯过程中的路径
    string track = "";
    // 记录所有合法的括号组合
    vector<string> res; 
public:
    vector<string> generateParenthesis(int n) {
        if (n == 0) return res;
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    void backtrack(int left, int right) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.push_back(track);
            return;
        }

        // 做选择，尝试放一个左括号
        track.push_back('(');
        backtrack(left - 1, right);
        // 撤消选择
        track.pop_back();

        // 做选择，尝试放一个右括号
        track.push_back(')');
        backtrack(left, right - 1);
        // 撤销选择
        track.pop_back();
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
        # 回溯过程中的路径
        self.track = ''
        # 记录所有合法的括号组合
        self.res = []

    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0: return self.res
        # 可用的左括号和右括号数量初始化为 n
        self.backtrack(n, n)
        return self.res

    # 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    def backtrack(self, left: int, right: int) -> None:
        # 若左括号剩下的多，说明不合法
        if right < left: return
        # 数量小于 0 肯定是不合法的
        if left < 0 or right < 0: return
        # 当所有括号都恰好用完时，得到一个合法的括号组合
        if left == 0 and right == 0: 
            self.res.append(self.track)
            return

        # 做选择，尝试放一个左括号
        self.track += '('
        self.backtrack(left - 1, right)
        # 撤消选择
        self.track = self.track[:-1]

        # 做选择，尝试放一个右括号
        self.track += ')'
        self.backtrack(left, right - 1)
        # 撤销选择
        self.track = self.track[:-1]
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        // 记录所有合法的括号组合
        List<String> res = new ArrayList<>();
        // 回溯过程中的路径
        StringBuilder track = new StringBuilder();
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    private void backtrack(int left, int right, StringBuilder track, List<String> res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        // 尝试放一个左括号
        // 选择
        track.append('(');
        backtrack(left - 1, right, track, res);
        // 撤消选择
        track.deleteCharAt(track.length() - 1);

        // 尝试放一个右括号
        // 选择
        track.append(')');
        backtrack(left, right - 1, track, res);
        // 撤消选择
        track.deleteCharAt(track.length() - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func generateParenthesis(n int) []string {
    var track string
    var res []string

    var backtrack func(left, right int)
    backtrack = func(left, right int) {
        // 若左括号剩下的多，说明不合法
        if right < left {
            return
        }
        // 数量小于 0 肯定是不合法的
        if left < 0 || right < 0 {
            return
        }
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if left == 0 && right == 0 {
            res = append(res, track)
            return
        }

        // 做选择，尝试放一个左括号
        track += "("
        backtrack(left-1, right)
        // 撤销选择
        track = track[:len(track)-1]

        // 做选择，尝试放一个右括号
        track += ")"
        backtrack(left, right-1)
        // 撤销选择
        track = track[:len(track)-1]
    }

    backtrack(n, n)
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var generateParenthesis = function(n) {
    let track = '';
    let res = [];

    const backtrack = (left, right) => {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left === 0 && right === 0) {
            res.push(track);
            return;
        }

        // 做选择，尝试放一个左括号
        track += '(';
        backtrack(left - 1, right);
        // 撤销选择
        track = track.slice(0, -1);

        // 做选择，尝试放一个右括号
        track += ')';
        backtrack(left, right - 1);
        // 撤销选择
        track = track.slice(0, -1);
    }

    backtrack(n, n);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_generate-parentheses"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_generate-parentheses"></div></div>
</details><hr /><br />

</div>
</details>
</div>

