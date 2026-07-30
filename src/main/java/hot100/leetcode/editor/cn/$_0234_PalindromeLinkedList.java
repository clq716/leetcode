package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 234: 回文链表
 * RedmiBook, Fedora
 * 2026-07-30 10:10:55
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0234_PalindromeLinkedList {

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
        public boolean isPalindrome(ListNode head) {
            if (head.next == null) {
                return true;
            }
            //找到中点
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //链表长度为奇数时，定位到中点后面的点
            if (fast != null) {
                if (fast.val != head.val) {
                    return false;
                }
                slow = slow.next;
            }
            if (head.next == slow) {
                return head.val == slow.val;
            }
            //反转slow后面的链表
            ListNode pre = null, cur = slow, next;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            //对比反转后的链表和头链表
            while (pre != null) {
                if (pre.val != head.val) {
                    return false;
                }
                pre = pre.next;
                head = head.next;
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 递归，头尾相互比较
     * > 2026/07/30 11:17:48
     * 解答成功:
     * 	执行耗时:25 ms,击败了5.72% 的Java用户
     * 	内存消耗:103 MB,击败了5.05% 的Java用户
     */
    class Solution1 {
        boolean ans = true;
        int maxDepth = 0;
        public boolean isPalindrome(ListNode head) {
            isPalindrome(head, head, 0);
            return ans;
        }

        private ListNode isPalindrome(ListNode left, ListNode right, int depth) {
            if (right == null) {
                maxDepth = depth;
                return left;
            }
            left = isPalindrome(left, right.next, depth+1);
            ans = ans && (left == null || left.val == right.val);
            if (depth<<1 <= maxDepth) {
                return null;
            }
            return left.next;
        }
    }

    //灵神的递归代码，是把左指针当作全局变量，来向下遍历，与“归”的右指针比较
    class Solution2 {
        private ListNode left;

        public boolean isPalindrome(ListNode head) {
            left = head;
            return isPal(head);
        }

        private boolean isPal(ListNode right) {
            // 「递」，先把 right 移到链表末尾
            if (right.next != null && !isPal(right.next)) {
                return false;
            }
            // 「归」的过程就是在从右到左遍历链表
            if (left.val != right.val) {
                return false;
            }
            left = left.next; // left 往右走
            return true; // 归，right 会往左走
        }
    }

    static void main() {
        Solution solution = new $_0234_PalindromeLinkedList().new Solution();
        // put your test code here
        print(solution.isPalindrome(new ListNode(8,0,7,1,7,7,9,7,5,2,9,1,7,3,7,0,6,5,1,7,7,9,3,8,1,5,7,7,8,4,0,9,3,7,3,4,5,7,4,8,8,5,8,9,8,5,8,8,4,7,5,4,3,7,3,9,0,4,8,7,7,5,1,8,3,9,7,7,1,5,6,0,7,3,7,1,9,2,5,7,9,7,7,1,7,0,8)));

    }
}