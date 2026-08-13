<p>给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。</p>

<p><a href="https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin" target="_blank">百度百科</a>中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（<strong>一个节点也可以是它自己的祖先</strong>）。”</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" /> 
<pre>
<strong>输入：</strong>root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
<strong>输出：</strong>3
<strong>解释：</strong>节点 <span><code>5 </code></span>和节点 <span><code>1 </code></span>的最近公共祖先是节点 <span><code>3 。</code></span>
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" /> 
<pre>
<strong>输入：</strong>root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
<strong>输出：</strong>5
<strong>解释：</strong>节点 <span><code>5 </code></span>和节点 <span><code>4 </code></span>的最近公共祖先是节点 <span><code>5 。</code></span>因为根据定义最近公共祖先节点可以为节点本身。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1,2], p = 1, q = 2
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数目在范围 <code>[2, 10<sup>5</sup>]</code> 内。</li> 
 <li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li> 
 <li>所有 <code>Node.val</code> <code>互不相同</code> 。</li> 
 <li><code>p != q</code></li> 
 <li><code>p</code> 和 <code>q</code> 均存在于给定的二叉树中。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树 | 最近公共祖先 | Binary Lifting</details><br>

<div>👍 3274, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/lowest-common-ancestor-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

经典问题了，先给出递归函数的定义：给该函数输入三个参数 `root`，`p`，`q`，它会返回一个节点：

情况 1，如果 `p` 和 `q` 都在以 `root` 为根的树中，函数返回的即使 `p` 和 `q` 的最近公共祖先节点。

情况 2，那如果 `p` 和 `q` 都不在以 `root` 为根的树中怎么办呢？函数理所当然地返回 `null` 呗。

情况 3，那如果 `p` 和 `q` 只有一个存在于 `root` 为根的树中呢？函数就会返回那个节点。

根据这个定义，分情况讨论：

情况 1，如果 `p` 和 `q` 都在以 `root` 为根的树中，那么 `left` 和 `right` 一定分别是 `p` 和 `q`（从 base case 看出来的）。

情况 2，如果 `p` 和 `q` 都不在以 `root` 为根的树中，直接返回 `null`。

情况 3，如果 `p` 和 `q` 只有一个存在于 `root` 为根的树中，函数返回该节点。

**详细题解**：
  - [拓展：最近公共祖先系列解题框架](https://labuladong.online/algo/practice-in-action/lowest-common-ancestor-summary/)

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
    // 用一个外部变量来记录是否已经找到 LCA 节点
    TreeNode* lca = nullptr; // [!code ++]

    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        return find(root, p->val, q->val);
    }

    TreeNode* find(TreeNode* root, int val1, int val2) {
        if (root == nullptr) {
            return nullptr;
        }
        // 如果已经找到 LCA 节点，直接返回
        // [!code ++:4]
        if (lca != nullptr) {
            return nullptr;
        }

        if (root->val == val1 || root->val == val2) {
            return root;
        }
        TreeNode* left = find(root->left, val1, val2);
        TreeNode* right = find(root->right, val1, val2);
        if (left != nullptr && right != nullptr) {
            // 当前节点是 LCA 节点，记录下来
            lca = root; // [!code ++]
            return root;
        }
        
        return left != nullptr ? left : right;
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
        # 用一个外部变量来记录是否已经找到 LCA 节点
        self.lca = None # [!code ++]

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.find(root, p.val, q.val)

    def find(self, root: 'TreeNode', val1: int, val2: int) -> 'TreeNode':
        if root is None:
            return None
        # 如果已经找到 LCA 节点，直接返回
        # [!code ++:4]
        if self.lca is not None:
            return None

        if root.val == val1 or root.val == val2:
            return root
        left = self.find(root.left, val1, val2)
        right = self.find(root.right, val1, val2)
        if left is not None and right is not None:
            # 当前节点是 LCA 节点，记录下来
            self.lca = root # [!code ++]
            return root
        
        return left if left is not None else right
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 用一个外部变量来记录是否已经找到 LCA 节点
    TreeNode lca = null; // [!code ++]

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        // 如果已经找到 LCA 节点，直接返回
        // [!code ++:4]
        if (lca != null) {
            return null;
        }

        if (root.val == val1 || root.val == val2) {
            return root;
        }
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);
        if (left != null && right != null) {
            // 当前节点是 LCA 节点，记录下来
            lca = root; // [!code ++]
            return root;
        }
        
        return left != null ? left : right;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
    // 用一个外部变量来记录是否已经找到 LCA 节点
    var lca *TreeNode // [!code ++]
    return find(root, p.Val, q.Val, lca)
}

func find(root *TreeNode, val1, val2 int, lca *TreeNode) *TreeNode {
    if root == nil {
        return nil
    }
    // 如果已经找到 LCA 节点，直接返回
    // [!code ++:4]
    if lca != nil {
        return nil
    }

    if root.Val == val1 || root.Val == val2 {
        return root
    }
    left := find(root.Left, val1, val2, lca)
    right := find(root.Right, val1, val2, lca)
    if left != nil && right != nil {
        // 当前节点是 LCA 节点，记录下来
        lca = root // [!code ++]
        return root
    }
    if left != nil {
        return left
    }
    return right
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var lowestCommonAncestor = function(root, p, q) {
    // 用一个外部变量来记录是否已经找到 LCA 节点
    let lca = null; // [!code ++]

    let find = function(root, val1, val2) {
        if (root == null) {
            return null;
        }
        // 如果已经找到 LCA 节点，直接返回
        // [!code ++:4]
        if (lca != null) {
            return null;
        }

        if (root.val == val1 || root.val == val2) {
            return root;
        }
        let left = find(root.left, val1, val2);
        let right = find(root.right, val1, val2);
        if (left != null && right != null) {
            // 当前节点是 LCA 节点，记录下来
            lca = root; // [!code ++]
            return root;
        }
        
        return left != null ? left : right;
    }

    return find(root, p.val, q.val);
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_lowest-common-ancestor-of-a-binary-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_lowest-common-ancestor-of-a-binary-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

