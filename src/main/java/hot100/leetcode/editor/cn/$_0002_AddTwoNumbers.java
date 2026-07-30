package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 2: 两数相加
 * RedmiBook, Fedora
 * 2026-07-30 14:12:21
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0002_AddTwoNumbers {

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
    //没有创建新的链表，是在原链表基础上判断修改的
    //官方解法和灵神都是用新链表存储结果，代码更简洁
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int up = 0;
            ListNode h1 = l1, h2 = l2;
            while (l1 != null || l2 != null) {
                int n1 = l1 == null ? 0 : l1.val;
                int n2 = l2 == null ? 0 : l2.val;
                int v = n1 + n2 + up;
                if (v > 9) {
                    up = 1;
                    v -= 10;
                } else {
                    up = 0;
                }
                if (l1 != null) {
                    l1.val = v;
                    if (l2 == null && l1.next == null) {
                        if (up == 1) {
                            l1.next = new ListNode(1);
                        }
                        return h1;
                    }
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2.val = v;
                    if (l1 == null && l2.next == null) {
                        if (up == 1) {
                            l2.next = new ListNode(1);
                        }
                        return h2;
                    }
                    l2 = l2.next;
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //官方题解
    class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null, tail = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                int sum = n1 + n2 + carry;
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head;
        }
    }

    
    static void main() {
        Solution solution = new $_0002_AddTwoNumbers().new Solution();
        // put your test code here
//        print(solution.addTwoNumbers(new ListNode("[9]"), new ListNode("[9]")));
        print(solution.addTwoNumbers(new ListNode("[9,9,9,9,9,9,9]"), new ListNode("[9,9,9,9]")));

    }
}