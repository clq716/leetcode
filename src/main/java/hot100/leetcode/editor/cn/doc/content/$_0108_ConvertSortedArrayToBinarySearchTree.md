<p>给你一个整数数组 <code>nums</code> ，其中元素已经按 <strong>升序</strong> 排列，请你将其转换为一棵 <span data-keyword="height-balanced">平衡</span> 二叉搜索树。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg" style="width: 302px; height: 222px;" /> 
<pre>
<strong>输入：</strong>nums = [-10,-3,0,5,9]
<strong>输出：</strong>[0,-3,9,-10,null,5]
<strong>解释：</strong>[0,-10,5,null,-3,null,9] 也将被视为正确答案：
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg" style="width: 302px; height: 222px;" />
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree.jpg" style="width: 342px; height: 142px;" /> 
<pre>
<strong>输入：</strong>nums = [1,3]
<strong>输出：</strong>[3,1]
<strong>解释：</strong>[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> 按 <strong>严格递增</strong> 顺序排列</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 二叉搜索树 | 数组 | 分治 | 二叉树</details><br>

<div>👍 1826, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维模式。

二叉树的构建问题遵循固定的套路，构造整棵树可以分解成：先构造根节点，然后构建左右子树。

一个有序数组对于 BST 来说就是中序遍历结果，根节点在数组中心，数组左侧是左子树元素，右侧是右子树元素。

**详细题解**：
  - [【练习】二叉搜索树经典例题 II](https://labuladong.online/algo/problem-set/bst2/)

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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return build(nums, 0, nums.size() - 1);
    }

    // 将闭区间 [left, right] 中的元素转化成 BST，返回根节点
    TreeNode* build(vector<int>& nums, int left, int right) {
        if (left > right) {
            // 区间为空
            return nullptr;
        }
        // 构造根节点
        // BST 节点左小右大，中间的元素就是根节点
        int mid = (left + right) / 2;
        TreeNode* root = new TreeNode(nums[mid]);
        // 递归构建左子树
        root->left = build(nums, left, mid - 1);
        // 递归构造右子树
        root->right = build(nums, mid + 1, right);

        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def sortedArrayToBST(self, nums):
        return self.build(nums, 0, len(nums) - 1)

    # 将闭区间 [left, right] 中的元素转化成 BST，返回根节点
    def build(self, nums, left, right):
        if left > right:
            # 区间为空
            return None
        # 构造根节点
        # BST 节点左小右大，中间的元素就是根节点
        mid = (left + right) // 2
        root = TreeNode(nums[mid])
        # 递归构建左子树
        root.left = self.build(nums, left, mid - 1)
        # 递归构造右子树
        root.right = self.build(nums, mid + 1, right)

        return root
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    // 将闭区间 [left, right] 中的元素转化成 BST，返回根节点
    TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            // 区间为空
            return null;
        }
        // 构造根节点
        // BST 节点左小右大，中间的元素就是根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归构建左子树
        root.left = build(nums, left, mid - 1);
        // 递归构造右子树
        root.right = build(nums, mid + 1, right);

        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func sortedArrayToBST(nums []int) *TreeNode {
    return build(nums, 0, len(nums)-1)
}

// 将闭区间 [left, right] 中的元素转化成 BST，返回根节点
func build(nums []int, left, right int) *TreeNode {
    if left > right {
        // 区间为空
        return nil
    }
    // 构造根节点
    // BST 节点左小右大，中间的元素就是根节点
    mid := (left + right) / 2
    root := &TreeNode{Val: nums[mid]}
    // 递归构建左子树
    root.Left = build(nums, left, mid-1)
    // 递归构造右子树
    root.Right = build(nums, mid+1, right)

    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var sortedArrayToBST = function(nums) {
    // 将闭区间 [left, right] 中的元素转化成 BST，返回根节点
    function build(nums, left, right) {
        if (left > right) {
            // 区间为空
            return null;
        }
        // 构造根节点
        // BST 节点左小右大，中间的元素就是根节点
        let mid = Math.floor((left + right) / 2);
        let root = new TreeNode(nums[mid]);
        // 递归构建左子树
        root.left = build(nums, left, mid - 1);
        // 递归构造右子树
        root.right = build(nums, mid + 1, right);

        return root;
    }

    return build(nums, 0, nums.length - 1);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_convert-sorted-array-to-binary-search-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_convert-sorted-array-to-binary-search-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

