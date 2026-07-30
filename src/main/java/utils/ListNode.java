package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public ListNode(String nodes) {
        nodes = nodes.replace('[', ' ').replace(']', ' ').trim();
        String[] sp = nodes.split(",");
        int[] arr;
        if (nodes.isEmpty()) {
            arr = new int[0];
        } else {
            arr = new int[sp.length];
            for (int i = 0; i < sp.length; i++) {
                arr[i] = Integer.parseInt(sp[i].trim());
            }
        }
        this(arr);
    }

    public ListNode(String nodes, int cycle) {
        this(nodes);
        ListNode last = this, cycleNode = this;
        while (last.next != null) {
            last = last.next;
        }
        if (cycle >= 0) {
            while (cycle-- > 0) {
                assert cycleNode != null;
                cycleNode = cycleNode.next;
            }
            last.next = cycleNode;
        }
    }

    public String toString() {
        List<Integer> list = new ArrayList<>();
        ListNode cur = this;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) break;
            list.add(cur.val);
            set.add(cur);
            cur = cur.next;
        }
        return "[length: " + list.size() + "], " + list.toString();
    }
}
