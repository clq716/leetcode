package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 142: 环形链表 II
 * RedmiBook, Fedora
 * 2026-07-30 13:36:57
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0142_LinkedListCycleIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) break;
            }
            while (slow != null) {
                if (slow == head) return slow;
                slow = slow.next;
                head = head.next;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神解法，原理相同，更加简洁
    class Solution1 {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) { // 相遇
                    while (slow != head) { // 再走 a 步
                        slow = slow.next;
                        head = head.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }
    
    static void main() {
        Solution solution = new $_0142_LinkedListCycleIi().new Solution();
        // put your test code here
        print(solution.detectCycle(new ListNode("[3,2]", -1)));
    }
}