//给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,3], head = [1,2,3,4,5] 
// 
//
// 输出： [4,5] 
//
// 解释： 
//
// 
//
// 移除数值为 1, 2 和 3 的节点。 
//
// 示例 2： 
//
// 
// 输入： nums = [1], head = [1,2,1,2,1,2] 
// 
//
// 输出： [2,2,2] 
//
// 解释： 
//
// 
//
// 移除数值为 1 的节点。 
//
// 示例 3： 
//
// 
// 输入： nums = [5], head = [1,2,3,4] 
// 
//
// 输出： [1,2,3,4] 
//
// 解释： 
//
// 
//
// 链表中不存在值为 5 的节点。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// nums 中的所有元素都是唯一的。 
// 链表中的节点数在 [1, 10⁵] 的范围内。 
// 1 <= Node.val <= 10⁵ 
// 输入保证链表中至少有一个值没有在 nums 中出现过。 
// 
//
// 👍 36 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class _3217_DeleteNodesFromLinkedListPresentInArray{
    public static void main(String[] args) {
       Solution solution = new _3217_DeleteNodesFromLinkedListPresentInArray().new Solution();
    }
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
    public ListNode modifiedList(int[] nums, ListNode head) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, num);
		}
		ListNode ans = new ListNode();
		ListNode tmp = ans;
		ListNode snap = tmp;
		while (head.next != null) {
			if (!map.containsKey(head.val)) {
				tmp.val = head.val;
				tmp.next = new ListNode();
				snap = tmp;
				tmp = tmp.next;
			}
			head = head.next;
		}
		if (!map.containsKey(head.val)) {
			tmp.val = head.val;
		} else {
			snap.next = null;
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}