<p>给定一个&nbsp;<code>m x n</code> 二维字符网格&nbsp;<code>board</code> 和一个字符串单词&nbsp;<code>word</code> 。如果&nbsp;<code>word</code> 存在于网格中，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;" /> 
<pre>
<strong>输入：</strong>board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = "ABCCED"
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg" style="width: 322px; height: 242px;" /> 
<pre>
<strong>输入：</strong>board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = "SEE"
<strong>输出：</strong>true
</pre>

<p><strong>示例 3：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg" style="width: 322px; height: 242px;" /> 
<pre>
<strong>输入：</strong>board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = "ABCB"
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == board.length</code></li> 
 <li><code>n = board[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 6</code></li> 
 <li><code>1 &lt;= word.length &lt;= 15</code></li> 
 <li><code>board</code> 和 <code>word</code> 仅由大小写英文字母组成</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以使用搜索剪枝的技术来优化解决方案，使其在 <code>board</code> 更大的情况下可以更快解决问题？</p>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 数组 | 字符串 | 回溯 | 矩阵</details><br>

<div>👍 2218, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题和 [一文秒杀所有岛屿题目](https://labuladong.online/algo/frequency-interview/island-dfs-summary/) 中讲到的题目非常类似，用 DFS 算法暴力搜索就行了。

注意我们要对已经匹配过的字符做标记，比如用一个额外的 `visited` 布尔数组，或者使用其他方法标记 `board` 中已经匹配过的字符。

如果不做标记的话会出现错误的结果，比如这个测试用例：

```java
[["A","B","C","E"],
 ["S","F","C","S"],
 ["A","D","E","E"]]
```

你如果在其中搜索 `"ABCB"`，按道理不应该搜到，但如果你不对已经匹配过的字符做标记的话，算法可能匹配了第一行前三列的 `"ABC"` 之后又回头匹配了第二列的 `"B"`，导致出现错误的结果。

我就用加负号的方式标记已经匹配过的字符，来避免走回头路，具体看代码吧。

**详细题解**：
  - [【练习】回溯算法经典习题 I](https://labuladong.online/algo/problem-set/backtrack-i/)

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
    bool found = false;

public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size(), n = board[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, word, 0);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从 (i, j) 开始向四周搜索，试图匹配 word[p..]
    void dfs(vector<vector<char>>& board, int i, int j, string& word, int p) {
        if (p == word.length()) {
            // 整个 word 已经被匹配完，找到了一个答案
            found = true;
            return;
        }
        if (found) {
            // 已经找到了一个答案，不用再搜索了
            return;
        }
        int m = board.size(), n = board[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (board[i][j] != word[p]) {
            return;
        }

        // 已经匹配过的字符，我们给它添一个负号作为标记，避免走回头路
        board[i][j] = -board[i][j];
        // word[p] 被 board[i][j] 匹配，开始向四周搜索 word[p+1..]
        dfs(board, i + 1, j, word, p + 1);
        dfs(board, i, j + 1, word, p + 1);
        dfs(board, i - 1, j, word, p + 1);
        dfs(board, i, j - 1, word, p + 1);
        board[i][j] = -board[i][j];
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
        self.found = False

    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                self.dfs(board, i, j, word, 0)
                if self.found:
                    return True
        return False

    # 从 (i, j) 开始向四周搜索，试图匹配 word[p..]
    def dfs(self, board: List[List[str]], i: int, j: int, word: str, p: int):
        if p == len(word):
            # 整个 word 已经被匹配完，找到了一个答案
            self.found = True
            return
        if self.found:
            # 已经找到了一个答案，不用再搜索了
            return
        m, n = len(board), len(board[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            return
        if board[i][j] != word[p]:
            return

        # 已经匹配过的字符，我们用一个特殊字符标记，避免走回头路
        temp = board[i][j]
        board[i][j] = '#'
        # word[p] 被 board[i][j] 匹配，开始向四周搜索 word[p+1..]
        self.dfs(board, i + 1, j, word, p + 1)
        self.dfs(board, i, j + 1, word, p + 1)
        self.dfs(board, i - 1, j, word, p + 1)
        self.dfs(board, i, j - 1, word, p + 1)
        board[i][j] = temp
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {

    boolean found = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, word, 0);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从 (i, j) 开始向四周搜索，试图匹配 word[p..]
    void dfs(char[][] board, int i, int j, String word, int p) {
        if (p == word.length()) {
            // 整个 word 已经被匹配完，找到了一个答案
            found = true;
            return;
        }
        if (found) {
            // 已经找到了一个答案，不用再搜索了
            return;
        }
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (board[i][j] != word.charAt(p)) {
            return;
        }

        // 已经匹配过的字符，我们给它添一个负号作为标记，避免走回头路
        board[i][j] = (char)(-board[i][j]);
        // word[p] 被 board[i][j] 匹配，开始向四周搜索 word[p+1..]
        dfs(board, i + 1, j, word, p + 1);
        dfs(board, i, j + 1, word, p + 1);
        dfs(board, i - 1, j, word, p + 1);
        dfs(board, i, j - 1, word, p + 1);
        board[i][j] = (char)(-board[i][j]);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var found bool

func exist(board [][]byte, word string) bool {
    m := len(board)
    n := len(board[0])
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            found = false
            dfs(board, i, j, word, 0)
            if found {
                return true
            }
        }
    }
    return false
}

// 从 (i, j) 开始向四周搜索，试图匹配 word[p..]
func dfs(board [][]byte, i, j int, word string, p int) {
    if p == len(word) {
        // 整个 word 已经被匹配完，找到了一个答案
        found = true
        return
    }
    if found {
        // 已经找到了一个答案，不用再搜索了
        return
    }
    m, n := len(board), len(board[0])
    if i < 0 || j < 0 || i >= m || j >= n {
        return
    }
    if board[i][j] != word[p] {
        return
    }

    // 已经匹配过的字符，我们给它添一个负号作为标记，避免走回头路
    original := board[i][j]
    board[i][j] = '^' - board[i][j]
    // word[p] 被 board[i][j] 匹配，开始向四周搜索 word[p+1..]
    dfs(board, i + 1, j, word, p + 1)
    dfs(board, i, j + 1, word, p + 1)
    dfs(board, i - 1, j, word, p + 1)
    dfs(board, i, j - 1, word, p + 1)
    board[i][j] = original
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var exist = function(board, word) {
    let found = false;
    const m = board.length, n = board[0].length;

    // 从 (i, j) 开始向四周搜索，试图匹配 word[p..]
    const dfs = function(board, i, j, word, p) {
        if (p === word.length) {
            // 整个 word 已经被匹配完，找到了一个答案
            found = true;
            return;
        }
        if (found) {
            // 已经找到了一个答案，不用再搜索了
            return;
        }
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (board[i][j] !== word.charAt(p)) {
            return;
        }

        // 已经匹配过的字符，我们给它添一个负号作为标记，避免走回头路
        board[i][j] = String.fromCharCode(-board[i][j].charCodeAt(0));
        // word[p] 被 board[i][j] 匹配，开始向四周搜索 word[p+1..]
        dfs(board, i + 1, j, word, p + 1);
        dfs(board, i, j + 1, word, p + 1);
        dfs(board, i - 1, j, word, p + 1);
        dfs(board, i, j - 1, word, p + 1);
        board[i][j] = String.fromCharCode(-board[i][j].charCodeAt(0));
    };

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            dfs(board, i, j, word, 0);
            if (found) {
                return true;
            }
        }
    }
    return false;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_word-search"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_word-search"></div></div>
</details><hr /><br />

</div>
</details>
</div>

