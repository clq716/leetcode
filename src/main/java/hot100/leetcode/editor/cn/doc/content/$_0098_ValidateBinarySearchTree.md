<p>给你一个二叉树的根节点 <code>root</code> ，判断其是否是一个有效的二叉搜索树。</p>

<p><strong>有效</strong> 二叉搜索树定义如下：</p>

<ul> 
 <li>节点的左<span data-keyword="subtree">子树</span>只包含<strong>&nbsp;严格小于 </strong>当前节点的数。</li> 
 <li>节点的右子树只包含 <strong>严格大于</strong> 当前节点的数。</li> 
 <li>所有左子树和右子树自身必须也是二叉搜索树。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg" style="width: 302px; height: 182px;" /> 
<pre>
<strong>输入：</strong>root = [2,1,3]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg" style="width: 422px; height: 292px;" /> 
<pre>
<strong>输入：</strong>root = [5,1,4,null,null,3,6]
<strong>输出：</strong>false
<strong>解释：</strong>根节点的值是 5 ，但是右子节点的值是 4 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数目范围在<code>[1, 10<sup>4</sup>]</code> 内</li> 
 <li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>

<div>👍 2800, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part2/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

初学者做这题很容易有误区：BST 不是左小右大么，那我只要检查 `root.val > root.left.val` 且 `root.val < root.right.val` 不就行了？

这样是不对的，因为 BST 左小右大的特性是指 `root.val` 要比左子树的所有节点都更大，要比右子树的所有节点都小，你只检查左右两个子节点当然是不够的。

正确解法是通过使用辅助函数，增加函数参数列表，在参数中携带额外信息，将这种约束传递给子树的所有节点，这也是二叉搜索树算法的一个小技巧吧。

**详细题解**：
  - [二叉搜索树心法（基操篇）](https://labuladong.online/algo/data-structure/bst-part2/)

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
    bool isValidBST(TreeNode* root) {
        return _isValidBST(root, nullptr, nullptr);
    }

    // 定义：该函数返回 root 为根的子树的所有节点是否满足 max->val > root->val > min->val
    bool _isValidBST(TreeNode* root, TreeNode* min, TreeNode* max) {
        // base case
        if (root == nullptr) return true;
        // 若 root->val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != nullptr && root->val <= min->val) return false;
        if (max != nullptr && root->val >= max->val) return false;
        // 根据定义，限定左子树的最大值是 root->val，右子树的最小值是 root->val
        return _isValidBST(root->left, min, root) 
            && _isValidBST(root->right, root, max);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self._isValidBST(root, None, None)

    # 定义：该函数返回 root 为根的子树的所有节点是否满足 max.val > root.val > min.val
    def _isValidBST(self, root: TreeNode, min: TreeNode, max: TreeNode) -> bool:
        # base case
        if root is None:
            return True
        # 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if min is not None and root.val <= min.val:
            return False
        if max is not None and root.val >= max.val:
            return False
        # 根据定义，限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return self._isValidBST(root.left, min, root) and self._isValidBST(root.right, root, max)
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    // 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func isValidBST(root *TreeNode) bool {
    return _isValidBST(root, nil, nil)
}

// 定义：该函数返回 root 为根的子树的所有节点是否满足 max.Val > root.Val > min.Val
func _isValidBST(root *TreeNode, min, max *TreeNode) bool {
    // base case
    if root == nil {
        return true
    }
    // 若 root.Val 不符合 max 和 min 的限制，说明不是合法 BST
    if min != nil && root.Val <= min.Val {
        return false
    }
    if max != nil && root.Val >= max.Val {
        return false
    }
    // 根据定义，限定左子树的最大值是 root.Val，右子树的最小值是 root.Val
    return _isValidBST(root.Left, min, root) && _isValidBST(root.Right, root, max)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var isValidBST = function(root) {
    return _isValidBST(root, null, null);
};

// 定义：该函数返回 root 为根的子树的所有节点是否满足 max.val > root.val > min.val
var _isValidBST = function(root, min, max) {
    // base case
    if (root === null) return true;
    // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
    if (min !== null && root.val <= min.val) return false;
    if (max !== null && root.val >= max.val) return false;
    // 根据定义，限定左子树的最大值是 root.val，右子树的最小值是 root.val
    return _isValidBST(root.left, min, root) 
        && _isValidBST(root.right, root, max);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_validate-binary-search-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_validate-binary-search-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

