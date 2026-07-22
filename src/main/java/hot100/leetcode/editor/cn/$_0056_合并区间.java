package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-22 20:51:02
 * Lenovo, Win11
 */
public class $_0056_合并区间 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<int[]> ans = new ArrayList<>();
            for (int i = 1; i < intervals.length; i++) {
                int[] pre = intervals[i-1];
                int[] interval = intervals[i];
                if (interval[0] > pre[1]) {
                    ans.add(pre);
                } else {
                    interval[0] = pre[0];
                    interval[1] = Math.max(interval[1], pre[1]);
                }
            }
            ans.add(intervals[intervals.length-1]);
            return ans.toArray(new int[0][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0056_合并区间().new Solution();
        // put your test code here
        
    }
}