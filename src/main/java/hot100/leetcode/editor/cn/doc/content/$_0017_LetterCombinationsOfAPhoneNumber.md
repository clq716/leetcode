<p>给定一个仅包含数字&nbsp;<code>2-9</code>&nbsp;的字符串，返回所有它能表示的字母组合。答案可以按 <strong>任意顺序</strong> 返回。</p>

<p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>

<p><img src="https://pic.leetcode.cn/1752723054-mfIHZs-image.png" style="width: 200px;" /></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>digits = "23"
<strong>输出：</strong>["ad","ae","af","bd","be","bf","cd","ce","cf"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>digits = "2"
<strong>输出：</strong>["a","b","c"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= digits.length &lt;= 4</code></li> 
 <li><code>digits[i]</code> 是范围 <code>['2', '9']</code> 的一个数字。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 回溯</details><br>

<div>👍 3289, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

你需要先看前文 [回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 和 [回溯算法团灭子集、排列、组合问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/)，然后看这道题就很简单了，无非是回溯算法的运用而已。

组合问题本质上就是遍历一棵回溯树，套用回溯算法代码框架即可。

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

#include <vector>
#include <string>
#include <unordered_map>

class Solution {
    // 每个数字到字母的映射
    std::unordered_map<char, std::string> mapping = {
        {'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"},
        {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}
    };

    std::vector<std::string> res;
    std::string sb;

public:
    std::vector<std::string> letterCombinations(std::string digits) {
        if (digits.empty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0);
        return res;
    }

    // 回溯算法主函数
    void backtrack(const std::string& digits, int start) {
        if (sb.size() == digits.size()) {
            // 到达回溯树底部
            res.push_back(sb);
            return;
        }

        // 回溯算法框架
        char digit = digits[start];
        for (char c : mapping[digit]) {
            // 做选择
            sb.push_back(c);
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            sb.pop_back();
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
    # 每个数字到字母的映射
    mapping = [
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    ]

    def __init__(self):
        self.res = []
        self.sb = []

    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return self.res
        # 从 digits[0] 开始进行回溯
        self.backtrack(digits, 0)
        return self.res

    # 回溯算法主函数
    def backtrack(self, digits: str, start: int) -> None:
        if len(self.sb) == len(digits):
            # 到达回溯树底部
            self.res.append(''.join(self.sb))
            return

        # 回溯算法框架
        digit = ord(digits[start]) - ord('0')
        for c in self.mapping[digit]:
            # 做选择
            self.sb.append(c)
            # 递归下一层回溯树
            self.backtrack(digits, start + 1)
            # 撤销选择
            self.sb.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 每个数字到字母的映射
    String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0);
        return res;
    }

    // 回溯算法主函数
    void backtrack(String digits, int start) {
        if (sb.length() == digits.length()) {
            // 到达回溯树底部
            res.add(sb.toString());
            return;
        }

        // 回溯算法框架
        int digit = digits.charAt(start) - '0';
        for (char c : mapping[digit].toCharArray()) {
            // 做选择
            sb.append(c);
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func letterCombinations(digits string) []string {
    if len(digits) == 0 {
        return []string{}
    }
    // 每个数字到字母的映射
    var mapping = []string{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",
    }
    var res []string
    // 从 digits[0] 开始进行回溯
    backtrack(digits, 0, "", &res, mapping)
    return res
}

// 回溯算法主函数
func backtrack(digits string, start int, combination string, res *[]string, mapping []string) {
    if len(combination) == len(digits) {
        // 到达回溯树底部
        *res = append(*res, combination)
        return
    }

    // 回溯算法框架
    digit := digits[start] - '0'
    for _, c := range mapping[digit] {
        // 做选择
        backtrack(digits, start+1, combination+string(c), res, mapping)
        // 递归下一层回溯树
        // Note: The following comment is not needed as there is no action taken for "undo the choice"
        // 撤销选择
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var letterCombinations = function(digits) {
    // 每个数字到字母的映射
    const mapping = [
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    ];

    let res = [];
    let sb = "";

    if (digits === "") {
        return res;
    }

    // 从 digits[0] 开始进行回溯
    // @visualize status(sb)
    function backtrack(digits, start) {
        // 回溯算法主函数
        if (sb.length === digits.length) {
            // 到达回溯树底部
            res.push(sb);
            return;
        }

        // 回溯算法框架
        let digit = digits.charCodeAt(start) - '0'.charCodeAt(0);
        for (let c of mapping[digit].split("")) {
            // 做选择
            // @visualize choose(c)
            sb += c;
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            // @visualize unchoose()
            sb = sb.slice(0, -1);
        }
    }

    backtrack(digits, 0);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_letter-combinations-of-a-phone-number"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_letter-combinations-of-a-phone-number"></div></div>
</details><hr /><br />

</div>
</details>
</div>

