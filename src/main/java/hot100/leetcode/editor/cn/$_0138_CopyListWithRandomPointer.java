package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 138: 随机链表的复制
 * RedmiBook, Fedora
 * 2026-07-30 17:14:28
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0138_CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /*
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    */

    class Solution {
        public Node copyRandomList(Node head) {
            Node dummy = new Node(0), original = head, copy = dummy;
            Map<Node, Node> map = new HashMap<>();
            while (original != null) {
                copy.next = new Node(original.val);
                copy = copy.next;
                map.put(original, copy);
                original = original.next;
            }
            copy = dummy.next;
            while (head != null) {
                if (head.random != null) {
                    copy.random = map.get(head.random);
                }
                copy = copy.next;
                head = head.next;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神不用hash表的巧妙解法
    class Solution1 {
        public Node copyRandomList(Node head) {
            // 复制每个节点，把新节点直接插到原节点的后面
            for (Node cur = head; cur != null; cur = cur.next.next) {
                Node node = new Node(cur.val);
                node.next = cur.next;
                cur.next = node;
            }

            // 遍历交错链表中的原链表节点
            for (Node cur = head; cur != null; cur = cur.next.next) {
                if (cur.random != null) {
                    // 要复制的 random 是 cur.random 的下一个节点
                    // 6666666666
                    cur.next.random = cur.random.next;
                }
            }

            // 把交错链表分离成两个链表
            Node dummy = new Node(0);
            Node tail = dummy;
            for (Node cur = head; cur != null; cur = cur.next, tail = tail.next) {
                Node copy = cur.next; // 新节点
                tail.next = copy; // 把新节点插在 tail 的后面，构建新的链表
                cur.next = copy.next; // 恢复原节点的 next
            }

            return dummy.next;
        }
    }
    static void main() {
        Solution solution = new $_0138_CopyListWithRandomPointer().new Solution();
        // put your test code here
        
    }
}