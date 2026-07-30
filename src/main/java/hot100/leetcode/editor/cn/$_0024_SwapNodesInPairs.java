package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 24: 两两交换链表中的节点
 * RedmiBook, Fedora
 * 2026-07-30 16:44:46
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0024_SwapNodesInPairs {

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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode d1 = new ListNode();
            d1.next = head;
            ListNode pre = d1, left = head, right = head.next, next = right.next;
            while (left != null && right != null) {
                //交换
                pre.next = right;
                right.next = left;
                left.next = next;
                //移动
                pre = left;
                left = next;
                if (left != null) right = left.next;
                if (right != null) next = right.next;
            }
            return d1.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神迭代
    class Solution1 {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0, head); // 用哨兵节点简化代码逻辑
            ListNode node0 = dummy;
            ListNode node1 = head;
            while (node1 != null && node1.next != null) { // 至少有两个节点
                ListNode node2 = node1.next;
                ListNode node3 = node2.next;

                node0.next = node2; // 0 -> 2
                node2.next = node1; // 2 -> 1
                node1.next = node3; // 1 -> 3

                node0 = node1; // 下一轮交换，0 是 1
                node1 = node3; // 下一轮交换，1 是 3
            }
            return dummy.next; // 返回新链表的头节点
        }
    }

    //灵神递归
    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode node1 = head;
            ListNode node2 = head.next;
            ListNode node3 = node2.next;

            node1.next = swapPairs(node3); // 1 指向递归返回的链表头
            node2.next = node1; // 2 指向 1

            return node2; // 返回交换后的链表头节点
        }
    }

    static void main() {
        Solution solution = new $_0024_SwapNodesInPairs().new Solution();
        // put your test code here
        print(solution.swapPairs(new ListNode("[1,2,3,4]")));
    }
}