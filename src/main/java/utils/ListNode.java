package utils;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int... nodes) {
        ListNode cur = this;
        for (int n : nodes) {
            ListNode node = new ListNode(n);
            cur.next = node;
            cur = node;
        }
        if (next != null) {
            val = next.val;
            next = next.next;
        }
    }

    public String toString() {
        List<Integer> list = new ArrayList<>();
        ListNode cur = this;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list.toString();
    }
}
