<p>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4]
<strong>输出：</strong>[2,1,4,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1]
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点的数目在范围 <code>[0, 100]</code> 内</li> 
 <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>

<div>👍 2650, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题不难，常规方法就是维护多个指针，遍历一遍链表顺便把每两个节点翻转。不过迭代的思路虽然直接，但细节问题会比较多，写起来麻烦。

所以我直接用递归的方式来写，只要搞明白递归函数的定义，然后利用这个定义就可以完成这道题。

其实前文 [如何 `k` 个一组反转链表](https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/) 中讲过的 [✨25. K 个一组翻转链表](/problems/reverse-nodes-in-k-group/) 就是这道题的进阶版，你可以去做一做。

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
public: // Ensure that swapPairs is public
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode* first = head;
        ListNode* second = head->next;
        ListNode* others = head->next->next;
        // 先把前两个元素翻转
        second->next = first;
        // 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first->next = swapPairs(others);
        // 现在整个链表都成功翻转了，返回新的头结点
        return second;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
# 返回翻转后的链表头结点
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        first = head
        second = head.next
        others = head.next.next
        # 先把前两个元素翻转
        second.next = first
        # 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first.next = self.swapPairs(others)
        # 现在整个链表都成功翻转了，返回新的头结点
        return second
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode others = head.next.next;
        // 先把前两个元素翻转
        second.next = first;
        // 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first.next = swapPairs(others);
        // 现在整个链表都成功翻转了，返回新的头结点
        return second;/**<extend up -200>![](https://labuladong.online/algo/images/kgroup/7.jpg) */
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func swapPairs(head *ListNode) *ListNode {
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    if head == nil || head.Next == nil {
        return head
    }
    first := head
    second := head.Next
    others := head.Next.Next
    // 先把前两个元素翻转
    second.Next = first
    // 利用递归定义，将剩下的链表节点两两翻转，接到后面
    first.Next = swapPairs(others)
    // 现在整个链表都成功翻转了，返回新的头结点
    return second
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
// 返回翻转后的链表头结点
var swapPairs = function(head) {
    if (head === null || head.next === null) {
        return head;
    }
    let first = head;
    let second = head.next;
    let others = head.next.next;
    // 先把前两个元素翻转
    second.next = first;
    // 利用递归定义，将剩下的链表节点两两翻转，接到后面
    first.next = swapPairs(others);
    // 现在整个链表都成功翻转了，返回新的头结点
    return second;
    // ![](https://labuladong.online/algo/images/kgroup/7.jpg) // This line is a comment with a picture reference which is not valid in this context.
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_swap-nodes-in-pairs"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_swap-nodes-in-pairs"></div></div>
</details><hr /><br />

</div>
</details>
</div>

