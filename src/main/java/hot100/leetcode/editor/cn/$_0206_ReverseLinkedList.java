package hot100.leetcode.editor.cn;

import java.util.*;
import utils.ListNode;
import static utils.Printer.print;
/**
 * 206: 反转链表
 * RedmiBook, Fedora
 * 2026-07-28 13:31:23
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0206_ReverseLinkedList {

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
     * 迭代方式
     * public ListNode reverseList(ListNode head) {
     *             if (head == null) return null;
     *             ListNode next = head.next;
     *             head.next = null;
     *             while (next != null) {
     *                 ListNode tmp = next.next;
     *                 next.next = head;
     *                 head = next;
     *                 next = tmp;
     *             }
     *             return head;
     *         }
     */

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            ListNode next = head.next;
            head.next = null;
            while (next != null) {
                ListNode tmp = next.next;
                next.next = head;
                head = next;
                next = tmp;
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神递归
    class Solution1 {
        // 首先「递」到链表末尾，把末尾节点作为新链表的头节点 revHead
        // 然后在「归」的过程中，把经过的节点依次插在新链表的末尾（尾插法）
        public ListNode reverseList(ListNode head) {
            // 判断 head == null 是为了兼容一开始链表就是空的情况
            if (head == null || head.next == null) {
                return head; // 链表末尾，即下面的 revHead
            }
            ListNode revHead = reverseList(head.next); // 「递」到链表末尾，拿到新链表的头节点
            ListNode tail = head.next; // 在「归」的过程中，head.next 就是新链表的末尾
            tail.next = head; // 把 head 插在新链表的末尾
            head.next = null; // 如果不写这行，新链表的末尾两个节点成环，这俩节点互相指向对方
            return revHead;
        }
    }

    //灵神迭代
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode nxt = cur.next;
                cur.next = pre; // 把 cur 插在 pre 链表的前面（头插法）
                pre = cur;
                cur = nxt;
            }
            return pre;
        }
    }

    static void main() {
        Solution solution = new $_0206_ReverseLinkedList().new Solution();
        Solution1 solution1 = new $_0206_ReverseLinkedList().new Solution1();
        Solution2 solution2 = new $_0206_ReverseLinkedList().new Solution2();
        // put your test code here
        ListNode node = new ListNode(1,2,3,4,5);
        print(solution.reverseList(node));
        print(solution1.reverseList(node));
        print(solution2.reverseList(node));
    }
}