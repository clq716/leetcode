<p>给定两个整数数组&nbsp;<code>preorder</code> 和 <code>inorder</code>&nbsp;，其中&nbsp;<code>preorder</code> 是二叉树的<strong>先序遍历</strong>， <code>inorder</code>&nbsp;是同一棵树的<strong>中序遍历</strong>，请构造二叉树并返回其根节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="height: 302px; width: 277px;" /> 
<pre>
<strong>输入</strong><strong>:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
<strong>输出:</strong> [3,9,20,null,null,15,7]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> preorder = [-1], inorder = [-1]
<strong>输出:</strong> [-1]
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= preorder.length &lt;= 3000</code></li> 
 <li><code>inorder.length == preorder.length</code></li> 
 <li><code>-3000 &lt;= preorder[i], inorder[i] &lt;= 3000</code></li> 
 <li><code>preorder</code>&nbsp;和&nbsp;<code>inorder</code>&nbsp;均 <strong>无重复</strong> 元素</li> 
 <li><code>inorder</code>&nbsp;均出现在&nbsp;<code>preorder</code></li> 
 <li><code>preorder</code>&nbsp;<strong>保证</strong> 为二叉树的前序遍历序列</li> 
 <li><code>inorder</code>&nbsp;<strong>保证</strong> 为二叉树的中序遍历序列</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 数组 | 哈希表 | 分治 | 二叉树</details><br>

<div>👍 2776, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/binary-tree-part2/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

**构造二叉树，第一件事一定是找根节点，然后想办法构造左右子树**。

二叉树的前序和中序遍历结果的特点如下：

![](https://labuladong.online/algo/images/binary-tree-ii/1.jpeg)

前序遍历结果第一个就是根节点的值，然后再根据中序遍历结果确定左右子树的节点。

![](https://labuladong.online/algo/images/binary-tree-ii/4.jpeg)

结合这个图看代码辅助理解。

**详细题解**：
  - [二叉树心法（构造篇）](https://labuladong.online/algo/data-structure/binary-tree-part2/)
  - [【练习】用「分解问题」思维解题 I](https://labuladong.online/algo/problem-set/binary-tree-divide-i/)

</div>





<div id="solution">

## 解法代码

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java</button>
</div><div class="tab-content">
<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
    }

    // 定义：前序遍历数组为 preorder[preStart..preEnd]
    // 中序遍历数组为 inorder[inStart..inEnd]
    // 构造这个二叉树并返回该二叉树的根节点
    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);/**<extend up -200>![](https://labuladong.online/algo/images/binary-tree-ii/4.jpeg) */
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
```

</div></div>
</div></div>

</div>
</details>
</div>

