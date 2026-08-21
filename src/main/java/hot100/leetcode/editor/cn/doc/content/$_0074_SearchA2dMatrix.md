<p>给你一个满足下述两条属性的 <code>m x n</code> 整数矩阵：</p>

<ul> 
 <li>每行中的整数从左到右按非严格递增顺序排列。</li> 
 <li>每行的第一个整数大于前一行的最后一个整数。</li> 
</ul>

<p>给你一个整数 <code>target</code> ，如果 <code>target</code> 在矩阵中，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>你必须编写一个时间复杂度为 <code>O(log(m * n))</code> 的解决方案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat.jpg" style="width: 322px; height: 242px;" /> 
<pre>
<strong>输入：</strong>matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.cn/aliyun-lc-upload/uploads/2020/11/25/mat2.jpg" style="width: 322px; height: 242px;" /> 
<pre>
<strong>输入：</strong>matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == matrix.length</code></li> 
 <li><code>n == matrix[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 100</code></li> 
 <li><code>-10<sup>4</sup> &lt;= matrix[i][j], target &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 矩阵</details><br>

<div>👍 1177, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

只要知道二维数组的的行数 `m` 和列数 `n`，二维数组的坐标 `(i, j)` 可以映射成一维的 `index = i * n + j`；反过来也可以通过一维 `index` 反解出二维坐标 `i = index / n, j = index % n`。

我们在前文 [二分搜索框架详解](https://labuladong.online/algo/essential-technique/binary-search-framework/) 详细讲解了二分搜索的几种框架，本题可以实现一个 `get` 函数把二维数组 `matrix` 的元素访问抽象成在一维数组中访问元素，然后直接施展最基本的二分搜索即可。

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
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = matrix[0].size();
        // 把二维数组映射到一维
        int left = 0, right = m * n - 1;
        // 前文讲的标准的二分搜索框架
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(get(matrix, mid) == target)
                return true;
            else if (get(matrix, mid) < target)
                left = mid + 1;
            else if (get(matrix, mid) > target)
                right = mid - 1;
        }
        return false;
    }

    // 通过一维坐标访问二维数组中的元素
    int get(vector<vector<int>>& matrix, int index) {
        int m = matrix.size(), n = matrix[0].size();
        // 计算二维中的横纵坐标
        int i = index / n, j = index % n;
        return matrix[i][j];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def searchMatrix(self, matrix, target):
        m = len(matrix)
        n = len(matrix[0])
        # 把二维数组映射到一维
        left = 0
        right = m * n - 1
        # 前文讲的标准的二分搜索框架
        while left <= right:
            mid = left + (right - left) // 2
            if self.get(matrix, mid) == target:
                return True
            elif self.get(matrix, mid) < target:
                left = mid + 1
            else:
                right = mid - 1
        return False

    # 通过一维坐标访问二维数组中的元素
    def get(self, matrix, index):
        m = len(matrix)
        n = len(matrix[0])
        # 计算二维中的横纵坐标
        i = index // n
        j = index % n
        return matrix[i][j]
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 把二维数组映射到一维
        int left = 0, right = m * n - 1;
        // 前文讲的标准的二分搜索框架
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(get(matrix, mid) == target)
                return true;
            else if (get(matrix, mid) < target)
                left = mid + 1;
            else if (get(matrix, mid) > target)
                right = mid - 1;
        }
        return false;
    }

    // 通过一维坐标访问二维数组中的元素
    int get(int[][] matrix, int index) {
        int m = matrix.length, n = matrix[0].length;
        // 计算二维中的横纵坐标
        int i = index / n, j = index % n;
        return matrix[i][j];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func searchMatrix(matrix [][]int, target int) bool {
    n := len(matrix[0])
    // 把二维数组映射到一维
    left, right := 0, len(matrix)*n-1
    // 前文讲的标准的二分搜索框架
    for left <= right {
        mid := left + (right-left)/2
        if get(matrix, mid) == target {
            return true
        } else if get(matrix, mid) < target {
            left = mid + 1
        } else if get(matrix, mid) > target {
            right = mid - 1
        }
    }
    return false
}

// 通过一维坐标访问二维数组中的元素
func get(matrix [][]int, index int) int {
    n := len(matrix[0])
    // 计算二维中的横纵坐标
    i, j := index/n, index%n
    return matrix[i][j]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var searchMatrix = function(matrix, target) {
    const m = matrix.length, n = matrix[0].length;
    // 把二维数组映射到一维
    let left = 0, right = m * n - 1;
    // 前文讲的标准的二分搜索框架
    while(left <= right) {
        let mid = left + Math.floor((right - left) / 2);
        if(get(matrix, mid) === target)
            return true;
        else if (get(matrix, mid) < target)
            left = mid + 1;
        else if (get(matrix, mid) > target)
            right = mid - 1;
    }
    return false;

    // 通过一维坐标访问二维数组中的元素
    function get(matrix, index) {
        // 计算二维中的横纵坐标
        let i = Math.floor(index / n), j = index % n;
        return matrix[i][j];
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_search-a-2d-matrix"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_search-a-2d-matrix"></div></div>
</details><hr /><br />

</div>
</details>
</div>

