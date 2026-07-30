package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 160: 相交链表
 * RedmiBook, Fedora
 * 2026-07-30 09:37:36
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0160_IntersectionOfTwoLinkedLists {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    // 方法2：双指针，指针1 遍历完A后遍历B,指针2遍历完B后遍历A,二者相等的节点就是相交节点
    public class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode dummyA = new ListNode(-1), dummyB = new ListNode(-1);
            dummyA.next = headA;
            dummyB.next = headB;
            ListNode point1 = dummyA;
            ListNode point2 = dummyB;
            boolean turn1 = false, turn2 = false;
            while (point1 != point2) {
                point1 = point1.next;
                point2 = point2.next;
                if (point1 == null && !turn1) {
                    point1 = dummyB;
                    turn1 = true;
                }
                if (point2 == null && !turn2) {
                    point2 = dummyA;
                    turn2 = true;
                }
            }
            return point1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 灵神的方法1写法，更简洁
     * 不需要使用虚拟头节点
     * 为I什么不需要担心在A和B无限循环？
     * 因为灵神的非空判断是在 p = p.next 之前
     * 所以如果两者不相交，有以下两种情况：
     *  1. A和B长度相同，同时为null，此时循环结束
     *  2. A和B长度不同，此时一个为null,另一个不为null, 指针正常切换和遍历，遍历完两个链表后，还是会同时为null,然后循环结束。
     */
    class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA;
            ListNode q = headB;
            while (p != q) {
                p = p != null ? p.next : headB;
                q = q != null ? q.next : headA;
            }
            return p;
        }
    }
    /**
     * 方法1, 计算出A和B的长度，减去它们的差值，让他们从相同起点开始遍历，相同处就是相交点
     */
    public class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = 0, lengthB = 0;
            ListNode dummyA = new ListNode(-1), dummyB = new ListNode(-1);
            dummyA.next = headA;
            dummyB.next = headB;
            ListNode point = dummyA;
            while (point != null) {
                lengthA++;
                point = point.next;
            }
            point = dummyB;
            while (point != null) {
                lengthB++;
                point = point.next;
            }
            if (lengthA > lengthB) {
                for (int i = 0; i < lengthA - lengthB; i++) {
                    dummyA = dummyA.next;
                }
            } else if (lengthB > lengthA && headB != null) {
                for (int i = 0; i < lengthB - lengthA; i++) {
                    dummyB = dummyB.next;
                }
            }
            while (dummyA != dummyB) {
                dummyA = dummyA.next;
                //因为长度相同，dummyB 为 null 时 dummyA 也为null, 二者相等不会进入循环
                dummyB = dummyB.next;
            }
            return dummyA;
        }
    }

    static void main() {
        Solution solution = new $_0160_IntersectionOfTwoLinkedLists().new Solution();
        // put your test code here
        
    }
}