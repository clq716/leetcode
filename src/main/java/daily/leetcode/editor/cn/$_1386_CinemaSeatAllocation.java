package daily.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 1386: 安排电影院座位
 * RedmiBook, Fedora
 * 2026-08-19 13:33:39
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_1386_CinemaSeatAllocation {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
            int[] bytes = new int[]{0, 0, 0b1000_0000, 0b100_0000, 0b10_0000, 0b1_0000, 0b1000, 0b100, 0b10, 0b1, 0};
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] reserved : reservedSeats) {
                cnt.merge(reserved[0], bytes[reserved[1]], Integer::sum);
            }
            int ans = (n - cnt.size()) << 1;
            for (int seat : cnt.values()) {
                if ((seat & 0b1111_1111) == 0) ans += 2;
                else if ((seat & 0b11_1100) == 0 || (seat & 0b1111) == 0 || (seat & 0b1111_0000) == 0) ans += 1;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_1386_CinemaSeatAllocation().new Solution();
        // put your test code here
    }
}