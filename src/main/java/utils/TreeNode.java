package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int... arr) {
        if (arr.length < 1) return;
        construct(this, 0, arr);
    }

    public TreeNode(String str) {
        this(Utils.toArray(str));
    }

    private TreeNode construct(TreeNode root, int i, int[] arr) {
        root.val = arr[i];
        int l = (i<<1) + 1;
        int r = l + 1;
        if (l < arr.length && arr[l] != Integer.MIN_VALUE) root.left = construct(new TreeNode(), l, arr);
        if (r < arr.length && arr[r] != Integer.MIN_VALUE) root.right = construct(new TreeNode(), r, arr);
        return root;
    }

    public String toString() {
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(this);
        LinkedList<String> list = new LinkedList<>();
        while (!deque.isEmpty()) {
            for (TreeNode node : deque) {
                if (node == null) list.offer(null);
                else list.offer(String.valueOf(node.val));
            }
            int c = deque.size();
            boolean allNull = true;
            while (c-->0) {
                TreeNode node = deque.poll();
                if (node == null) {
                    deque.offer(null);
                    deque.offer(null);
                } else {
                    allNull = false;
                    deque.offer(node.left);
                    deque.offer(node.right);
                }
            }
            if (allNull) break;
        }
        while (list.peekLast() == null) list.removeLast();
        return list.toString();
    }
}
