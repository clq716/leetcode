<p>给你一个字符串 <code>s</code>，请你将<em> </em><code>s</code><em> </em>分割成一些 <span data-keyword="substring-nonempty">子串</span>，使每个子串都是 <strong><span data-keyword="palindrome-string">回文串</span></strong> 。返回 <code>s</code> 所有可能的分割方案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aab"
<strong>输出：</strong>[["a","a","b"],["aa","b"]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a"
<strong>输出：</strong>[["a"]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 16</code></li> 
 <li><code>s</code> 仅由小写英文字母组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划 | 回溯</details><br>

<div>👍 2244, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题是经典的回溯算法，完全遵循 [回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 中讲到的算法框架，和 [一文秒杀所有排列组合子集问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/) 有异曲同工之妙。

我们就按照最直接粗暴的方式思考就行了：

从 `s` 的头部开始暴力穷举，如果发现 `s[0..i]` 是一个回文子串，那么我们就可以把 `s` 切分为 `s[0..i]` 和 `s[i+1..]`，然后我们去尝试把 `s[i+1..]` 去暴力切分成多个回文子串即可。

> PS: 至于如何判断一个字符串是否是回文串，我在 [数组双指针技巧汇总](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中的左右指针部分有讲解，很简单。

**把这个思路抽象成回溯树，树枝上是每次从头部穷举切分出的子串，节点上是待切分的剩余字符串**：

![](https://labuladong.online/algo/images/brief-extra/131.jpeg)

只有树枝上的子串是回文串时才能继续往下走，最后如果能够走到空串节点，就说明整个 `s` 完成了切分，也就是得到了一个合法的答案。

只要套用回溯算法框架，按照上述规则遍历整棵回溯树即可找到所有合法切分，直接看代码吧。

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
    vector<vector<string>> res;
    vector<string> track;

public:
    vector<vector<string>> partition(string s) {
        backtrack(s, 0);
        return res;
    }

    // 回溯算法框架
    void backtrack(string s, int start) {
        if (start == s.length()) {
            // base case，走到叶子节点
            // 即整个 s 被成功分割为若干个回文子串，记下答案
            res.push_back(track);
        }
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) {
                // s[start..i] 不是回文串，不能分割
                continue;
            }
            // s[start..i] 是一个回文串，可以进行分割
            // 做选择，把 s[start..i] 放入路径列表中
            track.push_back(s.substr(start, i - start + 1));
            // 进入回溯树的下一层，继续切分 s[i+1..]
            backtrack(s, i + 1);
            // 撤销选择
            track.pop_back();
        }
    }

    // 用双指针技巧判断 s[lo..hi] 是否是一个回文串
    bool isPalindrome(string s, int lo, int hi) {
        while (lo < hi) {
            if (s[lo] != s[hi]) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
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
        self.track = []

    def partition(self, s: str) -> List[List[str]]:
        self.backtrack(s, 0)
        return self.res

    # 回溯算法框架
    def backtrack(self, s: str, start: int):
        if start == len(s):
            # base case，走到叶子节点
            # 即整个 s 被成功分割为若干个回文子串，记下答案
            self.res.append(list(self.track))
        for i in range(start, len(s)):
            if not self.isPalindrome(s, start, i):
                # s[start..i] 不是回文串，不能分割
                continue # <extend up -200>![](https://labuladong.online/algo/images/brief-extra/131.jpeg) #
            # s[start..i] 是一个回文串，可以进行分割
            # 做选择，把 s[start..i] 放入路径列表中
            self.track.append(s[start:i + 1])
            # 进入回溯树的下一层，继续切分 s[i+1..]
            self.backtrack(s, i + 1)
            # 撤销选择
            self.track.pop()

    # 用双指针技巧判断 s[lo..hi] 是否是一个回文串
    def isPalindrome(self, s: str, lo: int, hi: int) -> bool:
        while lo < hi:
            if s[lo] != s[hi]:
                return False
            lo += 1
            hi -= 1
        return True
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    // 回溯算法框架
    void backtrack(String s, int start) {
        if (start == s.length()) {
            // base case，走到叶子节点
            // 即整个 s 被成功分割为若干个回文子串，记下答案
            res.add(new ArrayList<String>(track));
        }
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) {
                // s[start..i] 不是回文串，不能分割
                continue;/**<extend up -200>![](https://labuladong.online/algo/images/brief-extra/131.jpeg) */
            }
            // s[start..i] 是一个回文串，可以进行分割
            // 做选择，把 s[start..i] 放入路径列表中
            track.addLast(s.substring(start, i + 1));
            // 进入回溯树的下一层，继续切分 s[i+1..]
            backtrack(s, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    // 用双指针技巧判断 s[lo..hi] 是否是一个回文串
    boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func partition(s string) [][]string {
    var res [][]string
    var track []string
    backtrack(s, 0, &track, &res)
    return res
}

// 回溯算法框架
func backtrack(s string, start int, track *[]string, res *[][]string) {
    if start == len(s) {
        // base case，走到叶子节点
        // 即整个 s 被成功分割为若干个回文子串，记下答案
        tmp := make([]string, len(*track))
        copy(tmp, *track)
        *res = append(*res, tmp)
        return
    }
    for i := start; i < len(s); i++ {
        if !isPalindrome(s, start, i) {
            // s[start..i] 不是回文串，不能分割
            continue
        }
        // s[start..i] 是一个回文串，可以进行分割
        // 做选择，把 s[start..i] 放入路径列表中
        *track = append(*track, s[start:i+1])
        // 进入回溯树的下一层，继续切分 s[i+1..]
        backtrack(s, i+1, track, res)
        // 撤销选择
        *track = (*track)[:len(*track)-1]
    }
}

// 用双指针技巧判断 s[lo..hi] 是否是一个回文串
func isPalindrome(s string, lo, hi int) bool {
    for lo < hi {
        if s[lo] != s[hi] {
            return false
        }
        lo++
        hi--
    }
    return true
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var partition = function(s) {
    let res = [];
    let track = [];

    var backtrack = function(s, start) {
        // 回溯算法框架
        if (start == s.length) {
            // base case，走到叶子节点
            // 即整个 s 被成功分割为若干个回文子串，记下答案
            res.push([...track]);
            return;
        }
        for (let i = start; i < s.length; i++) {
            if (!isPalindrome(s, start, i)) {
                // s[start..i] 不是回文串，不能分割
                continue;
            }
            // s[start..i] 是一个回文串，可以进行分割
            // 做选择，把 s[start..i] 放入路径列表中
            track.push(s.substring(start, i + 1));
            // 进入回溯树的下一层，继续切分 s[i+1..]
            backtrack(s, i + 1);
            // 撤销选择
            track.pop();
        }
    };

    // 用双指针技巧判断 s[lo..hi] 是否是一个回文串
    var isPalindrome = function(s, lo, hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    };

    backtrack(s, 0);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_palindrome-partitioning"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_palindrome-partitioning"></div></div>
</details><hr /><br />

</div>
</details>
</div>

