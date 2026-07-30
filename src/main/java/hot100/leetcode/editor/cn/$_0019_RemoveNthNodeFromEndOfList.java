package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 19: 删除链表的倒数第 N 个结点
 * RedmiBook, Fedora
 * 2026-07-30 16:31:40
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0019_RemoveNthNodeFromEndOfList {

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0), slow = dummy, fast = dummy;
            dummy.next = head;
            while (n-->0) {
                fast = fast.next;
            }
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0019_RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here
        print(solution.removeNthFromEnd(new ListNode("[1,2,3,4,5]"), 2));
    }
}