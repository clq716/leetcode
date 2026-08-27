<p>给你一个字符串 <code>s</code> 和一个字符串列表 <code>wordDict</code> 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 <code>s</code>&nbsp;则返回 <code>true</code>。</p>

<p><strong>注意：</strong>不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong> s = "leetcode", wordDict = ["leet", "code"]
<strong>输出:</strong> true
<strong>解释:</strong> 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入:</strong> s = "applepenapple", wordDict = ["apple", "pen"]
<strong>输出:</strong> true
<strong>解释:</strong> 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
&nbsp;    注意，你可以重复使用字典中的单词。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入:</strong> s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
<strong>输出:</strong> false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 300</code></li> 
 <li><code>1 &lt;= wordDict.length &lt;= 1000</code></li> 
 <li><code>1 &lt;= wordDict[i].length &lt;= 20</code></li> 
 <li><code>s</code> 和 <code>wordDict[i]</code> 仅由小写英文字母组成</li> 
 <li><code>wordDict</code> 中的所有字符串 <strong>互不相同</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字典树 | 记忆化 | 数组 | 哈希表 | 字符串 | 动态规划 | Brute-Force Search</details><br>

<div>👍 3007, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/dynamic-programming/word-break/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

关于动态规划的解题步骤和思维方法见前文 [动态规划核心套路](https://labuladong.online/algo/essential-technique/dynamic-programming-framework/) 和 [动态规划答疑篇](https://labuladong.online/algo/dynamic-programming/faq-summary/)，这里就不赘述了，直接说说状态转移方程怎么找。

让你判断 `s` 是否能被分解成 `wordDict` 中的单词，反过来想就是判断 `wordDict` 中的单词是否能拼出 `s`，那么暴力穷举的思路就是：

```js
function 拼凑(s, wordDict) {
    for (word in wordDict) {
        if (word 是 s 的前缀) {
            拼凑(去掉 word 前缀的 s, wordDict)
        }
    }
}
```

于是，我们可以定义一个 `dp` 函数：

```java
// 定义：返回 s[i..] 是否能够被 wordDict 拼出
boolean dp(String s, int i, List<String> wordDict)
```

解法框架就出来了：

```java
boolean dp(String s, int i, List<String> wordDict) {
    // 遍历所有单词，尝试匹配 s[i..] 的前缀
    for (String word : wordDict) {
        int len = word.length();
        String subStr = s.substring(i, i + len);
        if (subStr.equals(word)) {
            // s[i..] 的前缀被匹配，去尝试拼出 s[i+len..]
            if (dp(s, i + len, wordDict)) {
                // s[i..] 可以被拼出
                return true;
            }
        }
    }
    // s[i..] 无法被拼出
    return false;
}
```

索引 `i` 显然是「状态」，加个备忘录消除一下重叠子问题，自顶向下带备忘录的动态规划就 OK 了，当然你也可以改写成自底向上的动态规划。

**详细题解**：
  - [动态规划和回溯算法的思维转换](https://labuladong.online/algo/dynamic-programming/word-break/)

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
    // 备忘录
    vector<int> memo;

public:
    bool wordBreak(string s, vector<string>& wordDict) {
        // 备忘录，-1 代表未计算，0 代表 false，1 代表 true
        memo = vector<int>(s.length(), -1);
        // 根据函数定义，判断 s[0..] 是否能够被拼出
        return dp(s, 0, wordDict);
    }

    // 定义：返回 s[i..] 是否能够被 wordDict 拼出
    bool dp(string s, int i, vector<string>& wordDict) {
        // base case，整个 s 都被拼出来了
        if (i == s.length()) {
            return true;
        }
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 1 ? true : false;
        }
        // 遍历所有单词，尝试匹配 s[i..] 的前缀
        for (string word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) {
                continue;
            }
            string subStr = s.substr(i, len);
            if (subStr != word) {
                continue;
            }
            // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
            if (dp(s, i + len, wordDict)) {
                // s[i..] 可以被拼出，将结果记入备忘录
                memo[i] = 1;
                return true;
            }
        }
        // s[i..] 不能被拼出，结果记入备忘录
        memo[i] = 0;
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 备忘录
    memo = []

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # 备忘录，-1 代表未计算，0 代表 false，1 代表 true
        self.memo = [-1] * len(s)
        # 根据函数定义，判断 s[0..] 是否能够被拼出
        return self.dp(s, 0, wordDict)

    # 定义：返回 s[i..] 是否能够被 wordDict 拼出
    def dp(self, s: str, i: int, wordDict: List[str]) -> bool:
        # base case，整个 s 都被拼出来了
        if i == len(s):
            return True
        # 防止冗余计算
        if self.memo[i] != -1:
            return self.memo[i] == 1
        # 遍历所有单词，尝试匹配 s[i..] 的前缀
        for word in wordDict:
            length = len(word)
            if i + length > len(s):
                continue
            subStr = s[i:i + length]
            if subStr != word:
                continue
            # s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
            if self.dp(s, i + length, wordDict):
                # s[i..] 可以被拼出，将结果记入备忘录
                self.memo[i] = 1
                return True
        # s[i..] 不能被拼出，结果记入备忘录
        self.memo[i] = 0
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 备忘录
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        // 备忘录，-1 代表未计算，0 代表 false，1 代表 true
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        // 根据函数定义，判断 s[0..] 是否能够被拼出
        return dp(s, 0, wordDict);
    }

    // 定义：返回 s[i..] 是否能够被 wordDict 拼出
    boolean dp(String s, int i, List<String> wordDict) {
        // base case，整个 s 都被拼出来了
        if (i == s.length()) {
            return true;
        }
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 1 ? true : false;
        }
        // 遍历所有单词，尝试匹配 s[i..] 的前缀
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) {
                continue;
            }
            String subStr = s.substring(i, i + len);
            if (!subStr.equals(word)) {
                continue;
            }
            // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
            if (dp(s, i + len, wordDict)) {
                // s[i..] 可以被拼出，将结果记入备忘录
                memo[i] = 1;
                return true;
            }
        }
        // s[i..] 不能被拼出，结果记入备忘录
        memo[i] = 0;
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func wordBreak(s string, wordDict []string) bool {
    // 备忘录
    // 备忘录，-1 代表未计算，0 代表 false，1 代表 true
    memo := make([]int, len(s))
    for i := range memo {
        memo[i] = -1
    }
    // 根据函数定义，判断 s[0..] 是否能够被拼出
    return dp(s, 0, wordDict, memo)
}

// 定义：返回 s[i..] 是否能够被 wordDict 拼出
func dp(s string, i int, wordDict []string, memo []int) bool {
    // base case，整个 s 都被拼出来了
    if i == len(s) {
        return true
    }
    // 防止冗余计算
    if memo[i] != -1 {
        return memo[i] == 1
    }
    // 遍历所有单词，尝试匹配 s[i..] 的前缀
    for _, word := range wordDict {
        lenWord := len(word)
        if i+lenWord > len(s) {
            continue
        }
        subStr := s[i : i+lenWord]
        if subStr != word {
            continue
        }
        // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
        if dp(s, i+lenWord, wordDict, memo) {
            // s[i..] 可以被拼出，将结果记入备忘录
            memo[i] = 1
            return true
        }
    }
    // s[i..] 不能被拼出，结果记入备忘录
    memo[i] = 0
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var wordBreak = function(s, wordDict) {
    // 备忘录
    // 备忘录，-1 代表未计算，0 代表 false，1 代表 true
    let memo = new Array(s.length).fill(-1);

    // 根据函数定义，判断 s[0..] 是否能够被拼出
    // @visualize status(s.substring(i))
    var dp = function(s, i, wordDict) {
        // 定义：返回 s[i..] 是否能够被 wordDict 拼出
        // base case，整个 s 都被拼出来了
        if (i == s.length) {
            return true;
        }
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 1;
        }
        // 遍历所有单词，尝试匹配 s[i..] 的前缀
        for (let word of wordDict) {
            let len = word.length;
            if (i + len > s.length) {
                continue;
            }
            let subStr = s.substring(i, i + len);
            if (subStr !== word) {
                continue;
            }
            // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
            if (dp(s, i + len, wordDict)) {
                // s[i..] 可以被拼出，将结果记入备忘录
                memo[i] = 1;
                return true;
            }
        }
        // s[i..] 不能被拼出，结果记入备忘录
        memo[i] = 0;
        return false;
    };

    return dp(s, 0, wordDict);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_word-break"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_word-break"></div></div>
</details><hr /><br />

</div>
</details>
</div>

