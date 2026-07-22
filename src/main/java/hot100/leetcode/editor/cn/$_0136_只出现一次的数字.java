package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-22 15:25:14
 * RedmiBook, Fedora
 */
public class $_0136_只出现一次的数字 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int num : nums) ans ^= num;
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0136_只出现一次的数字().new Solution();
        // put your test code here
        
    }
}