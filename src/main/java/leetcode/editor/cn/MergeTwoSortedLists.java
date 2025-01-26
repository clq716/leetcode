//<p>将两个升序链表合并为一个新的 <strong>升序</strong> 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。&nbsp;</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" /> 
//<pre>
//<strong>输入：</strong>l1 = [1,2,4], l2 = [1,3,4]
//<strong>输出：</strong>[1,1,2,3,4,4]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>l1 = [], l2 = []
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>l1 = [], l2 = [0]
//<strong>输出：</strong>[0]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>两个链表的节点数目范围是 <code>[0, 50]</code></li> 
// <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
// <li><code>l1</code> 和 <code>l2</code> 均按 <strong>非递减顺序</strong> 排列</li> 
//</ul>
//
//<div><li>👍 3605</li><li>👎 0</li></div>

package leetcode.editor.cn;

import lombok.val;

public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = solution.mergeTwoLists(list1, list2);
        int vali = result.val;
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            if (list2 == null) {
                return null;
            } else {
                return list2;
            }
        } else {
            if (list2 == null) {
                return list1;
            }
        }
        ListNode result, other;
        if (list1.val < list2.val) {
            result = new ListNode(list1.val, list1.next);
            other = list2;
        } else {
            result = new ListNode(list2.val, list2.next);
            other = list1;
        }
        ListNode tmp = result;
        do {
            if (tmp.next.val > other.val) {
                ListNode ne = tmp.next;
                tmp.next = other;
                other = ne;
            } else {
                tmp = tmp.next;
            }
        } while (tmp.next != null);
        tmp.next = other;
        return result;
    }
}
public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//leetcode submit region end(Prohibit modification and deletion)

}