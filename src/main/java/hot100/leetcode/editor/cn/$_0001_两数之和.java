package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;

/**
 * 2026-07-21 22:25:32
 * Lenovo, Win11
 */
public class $_0001_两数之和 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer ans = map.get(nums[i]);
                if (ans == null) {
                    map.put(target - nums[i], i);
                } else {
                    return new int[]{ans, i};
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0001_两数之和().new Solution();
        // put your test code here
		print("[0, 1] == " + Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}