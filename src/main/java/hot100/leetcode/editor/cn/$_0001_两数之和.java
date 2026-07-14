package hot100.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 2026-07-14 16:06:43
 * RedmiBook, Fedora
 */
public class $_0001_两数之和 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                }
                map.put(target - nums[i], i);
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0001_两数之和().new Solution();
        // put your test code here
        
    }
}