<p>给你一个长度为 <code>n</code> 的链表，每个节点包含一个额外增加的随机指针 <code>random</code> ，该指针可以指向链表中的任何节点或空节点。</p>

<p>构造这个链表的&nbsp;<strong><a href="https://baike.baidu.com/item/深拷贝/22785317?fr=aladdin" target="_blank">深拷贝</a></strong>。&nbsp;深拷贝应该正好由 <code>n</code> 个 <strong>全新</strong> 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 <code>next</code> 指针和 <code>random</code> 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。<strong>复制链表中的指针都不应指向原链表中的节点 </strong>。</p>

<p>例如，如果原链表中有 <code>X</code> 和 <code>Y</code> 两个节点，其中 <code>X.random --&gt; Y</code> 。那么在复制链表中对应的两个节点 <code>x</code> 和 <code>y</code> ，同样有 <code>x.random --&gt; y</code> 。</p>

<p>返回复制链表的头节点。</p>

<p>用一个由&nbsp;<code>n</code>&nbsp;个节点组成的链表来表示输入/输出中的链表。每个节点用一个&nbsp;<code>[val, random_index]</code>&nbsp;表示：</p>

<ul> 
 <li><code>val</code>：一个表示&nbsp;<code>Node.val</code>&nbsp;的整数。</li> 
 <li><code>random_index</code>：随机指针指向的节点索引（范围从&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n-1</code>）；如果不指向任何节点，则为&nbsp;&nbsp;<code>null</code>&nbsp;。</li> 
</ul>

<p>你的代码 <strong>只</strong> 接受原链表的头节点 <code>head</code> 作为传入参数。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.cn/aliyun-lc-upload/uploads/2020/01/09/e1.png" style="height: 142px; width: 700px;" /></p>

<pre>
<strong>输入：</strong>head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
<strong>输出：</strong>[[7,null],[13,0],[11,4],[10,2],[1,0]]
</pre>

<p><strong class="example">示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.cn/aliyun-lc-upload/uploads/2020/01/09/e2.png" style="height: 114px; width: 700px;" /></p>

<pre>
<strong>输入：</strong>head = [[1,1],[2,1]]
<strong>输出：</strong>[[1,1],[2,1]]
</pre>

<p><strong class="example">示例 3：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.cn/aliyun-lc-upload/uploads/2020/01/09/e3.png" style="height: 122px; width: 700px;" /></strong></p>

<pre>
<strong>输入：</strong>head = [[3,null],[3,0],[3,null]]
<strong>输出：</strong>[[3,null],[3,0],[3,null]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 1000</code>
  <meta charset="UTF-8" /></li> 
 <li><code>-10<sup>4</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>4</sup></code></li> 
 <li><code>Node.random</code>&nbsp;为&nbsp;<code>null</code> 或指向链表中的节点。</li> 
</ul>

<p>&nbsp;</p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表</details><br>

<div>👍 1828, 👎 0<span style='float: right;'><a href='https://labuladong.online/zh/algo/intro/bug-report/' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/zh/algo/intro/jetbrains/' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/zh/algo/home/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多插件</a></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这道题目，就属于会者不难，难者不会的那类题，后面他还可以给你变出更多花样，比如克隆带随机指针的二叉树，你会不会？那再让你克隆图，你会不会？

**对于数据结构复制，甭管他怎么变，你就记住最简单的方式：一个哈希表 + 两次遍历**。

第一次遍历专门克隆节点，借助哈希表把原始节点和克隆节点的映射存储起来；第二次专门组装节点，照着原数据结构的样子，把克隆节点的指针组装起来。

题目如果让你克隆带随机指针的二叉树，或者克隆图，都是一样的，只不过是遍历的方式从 for 循环迭代遍历变成 `traverse` 递归函数遍历罢了。

**详细题解**：
  - [【练习】哈希表更多习题](https://labuladong.online/algo/problem-set/hash-table/)

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
    Node* copyRandomList(Node* head) {
        unordered_map<Node*, Node*> originToClone;
        // 第一次遍历，先把所有节点克隆出来
        for (Node* p = head; p != nullptr; p = p->next) {
            if (originToClone.find(p) == originToClone.end()) {
                originToClone[p] = new Node(p->val);
            }
        }
        // 第二次遍历，把克隆节点的结构连接好
        for (Node* p = head; p != nullptr; p = p->next) {
            if (p->next != nullptr) {
                originToClone[p]->next = originToClone[p->next];
            }
            if (p->random != nullptr) {
                originToClone[p]->random = originToClone[p->random];
            }
        }
        // 返回克隆之后的头结点
        return originToClone[head];
    }
};

// 用递归的方式进行遍历
class Solution2 {
public:
    Node* copyRandomList(Node* head) {
        traverse(head);
        return originToClone[head];
    }

private:
    // 记录 DFS 遍历过的节点，防止走回头路
    unordered_set<Node*> visited;
    // 记录原节点到克隆节点的映射
    unordered_map<Node*, Node*> originToClone;

    // DFS 图遍历框架
    void traverse(Node* node) {
        if (node == nullptr) {
            return;
        }
        if (visited.find(node) != visited.end()) {
            return;
        }
        // 前序位置，标记为已访问
        visited.insert(node);
        // 前序位置，克隆节点
        if (originToClone.find(node) == originToClone.end()) {
            originToClone[node] = new Node(node->val);
        }
        Node* cloneNode = originToClone[node];

        // 递归遍历邻居节点，并构建克隆图
        // 递归之后，邻居节点一定存在 originToClone 中

        traverse(node->next);
        cloneNode->next = originToClone[node->next];

        traverse(node->random);
        cloneNode->random = originToClone[node->random];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Node:
    def __init__(self, val=0, next=None, random=None):
        self.val = val
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        originToClone = {}
        # 第一次遍历，先把所有节点克隆出来
        p = head
        while p:
            if p not in originToClone:
                originToClone[p] = Node(p.val)
            p = p.next
        
        # 第二次遍历，把克隆节点的结构连接好
        p = head
        while p:
            if p.next:
                originToClone[p].next = originToClone[p.next]
            if p.random:
                originToClone[p].random = originToClone[p.random]
            p = p.next
        
        # 返回克隆之后的头结点
        return originToClone.get(head)

# 用递归的方式进行遍历
class Solution2:
    def __init__(self):
        # 记录 DFS 遍历过的节点，防止走回头路
        self.visited = set()
        # 记录原节点到克隆节点的映射
        self.originToClone = {}

    def copyRandomList(self, head: 'Node') -> 'Node':
        self.traverse(head)
        return self.originToClone.get(head)

    # DFS 图遍历框架
    def traverse(self, node: 'Node'):
        if not node:
            return
        if node in self.visited:
            return
        # 前序位置，标记为已访问
        self.visited.add(node)
        # 前序位置，克隆节点
        if node not in self.originToClone:
            self.originToClone[node] = Node(node.val)
        cloneNode = self.originToClone[node]

        # 递归遍历邻居节点，并构建克隆图
        # 递归之后，邻居节点一定存在 originToClone 中

        self.traverse(node.next)
        cloneNode.next = self.originToClone.get(node.next)

        self.traverse(node.random)
        cloneNode.random = self.originToClone.get(node.random)
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> originToClone = new HashMap<>();
        // 第一次遍历，先把所有节点克隆出来
        for (Node p = head; p != null; p = p.next) {
            if (!originToClone.containsKey(p)) {
                originToClone.put(p, new Node(p.val));
            }
        }
        // 第二次遍历，把克隆节点的结构连接好
        for (Node p = head; p != null; p = p.next) {
            if (p.next != null) {
                originToClone.get(p).next = originToClone.get(p.next);
            }
            if (p.random != null) {
                originToClone.get(p).random = originToClone.get(p.random);
            }
        }
        // 返回克隆之后的头结点
        return originToClone.get(head);
    }
}

// 用递归的方式进行遍历
class Solution2 {
    public Node copyRandomList(Node head) {
        traverse(head);
        return originToClone.get(head);
    }

    // 记录 DFS 遍历过的节点，防止走回头路
    HashSet<Node> visited = new HashSet<>();
    // 记录原节点到克隆节点的映射
    HashMap<Node, Node> originToClone = new HashMap<>();

    // DFS 图遍历框架
    void traverse(Node node) {
        if (node == null) {
            return;
        }
        if (visited.contains(node)) {
            return;
        }
        // 前序位置，标记为已访问
        visited.add(node);
        // 前序位置，克隆节点
        if (!originToClone.containsKey(node)) {
            originToClone.put(node, new Node(node.val));
        }
        Node cloneNode = originToClone.get(node);

        // 递归遍历邻居节点，并构建克隆图
        // 递归之后，邻居节点一定存在 originToClone 中

        traverse(node.next);
        cloneNode.next = originToClone.get(node.next);

        traverse(node.random);
        cloneNode.random = originToClone.get(node.random);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func copyRandomList(head *Node) *Node {
    originToClone := make(map[*Node]*Node)
    // 第一次遍历，先把所有节点克隆出来
    for p := head; p != nil; p = p.Next {
        if _, ok := originToClone[p]; !ok {
            originToClone[p] = &Node{Val: p.Val}
        }
    }
    // 第二次遍历，把克隆节点的结构连接好
    for p := head; p != nil; p = p.Next {
        if p.Next != nil {
            originToClone[p].Next = originToClone[p.Next]
        }
        if p.Random != nil {
            originToClone[p].Random = originToClone[p.Random]
        }
    }
    // 返回克隆之后的头结点
    return originToClone[head]
}

// 用递归的方式进行遍历
func copyRandomListRecursive(head *Node) *Node {
    // 记录 DFS 遍历过的节点，防止走回头路
    visited := make(map[*Node]bool)
    // 记录原节点到克隆节点的映射
    originToClone := make(map[*Node]*Node)
    traverse(head, visited, originToClone)
    return originToClone[head]
}

// DFS 图遍历框架
func traverse(node *Node, visited map[*Node]bool, originToClone map[*Node]*Node) {
    if node == nil {
        return
    }
    if visited[node] {
        return
    }
    // 前序位置，标记为已访问
    visited[node] = true
    // 前序位置，克隆节点
    if _, ok := originToClone[node]; !ok {
        originToClone[node] = &Node{Val: node.Val}
    }
    cloneNode := originToClone[node]

    // 递归遍历邻居节点，并构建克隆图
    // 递归之后，邻居节点一定存在 originToClone 中
    traverse(node.Next, visited, originToClone)
    cloneNode.Next = originToClone[node.Next]

    traverse(node.Random, visited, originToClone)
    cloneNode.Random = originToClone[node.Random]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var copyRandomList = function(head) {
    let originToClone = new Map();
    // 第一次遍历，先把所有节点克隆出来
    for (let p = head; p != null; p = p.next) {
        if (!originToClone.has(p)) {
            originToClone.set(p, new Node(p.val));
        }
    }
    // 第二次遍历，把克隆节点的结构连接好
    for (let p = head; p != null; p = p.next) {
        if (p.next != null) {
            originToClone.get(p).next = originToClone.get(p.next);
        }
        if (p.random != null) {
            originToClone.get(p).random = originToClone.get(p.random);
        }
    }
    // 返回克隆之后的头结点
    return originToClone.get(head);
};

// 用递归的方式进行遍历
var copyRandomList2 = function(head) {
    // 记录 DFS 遍历过的节点，防止走回头路
    let visited = new Set();
    // 记录原节点到克隆节点的映射
    let originToClone = new Map();

    // DFS 图遍历框架
    var traverse = function(node) {
        if (node == null) {
            return;
        }
        if (visited.has(node)) {
            return;
        }
        // 前序位置，标记为已访问
        visited.add(node);
        // 前序位置，克隆节点
        if (!originToClone.has(node)) {
            originToClone.set(node, new Node(node.val));
        }
        let cloneNode = originToClone.get(node);

        // 递归遍历邻居节点，并构建克隆图
        // 递归之后，邻居节点一定存在 originToClone 中

        traverse(node.next);
        cloneNode.next = originToClone.get(node.next);

        traverse(node.random);
        cloneNode.random = originToClone.get(node.random);
    }

    traverse(head);
    // 返回克隆之后的头结点
    return originToClone.get(head);
};
```

</div></div>
</div></div>

</div>
</details>
</div>

