package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 56: 合并区间
 * RedmiBook, Fedora
 * 2026-08-27 15:54:28
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0056_MergeIntervals {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            List<int[]> ans = new ArrayList<>();
            int preEnd = -1;
            for (int[] interval : intervals) {
                // 找到下一个区间，初始化下一个区间
                if (interval[0] > preEnd) {
                    ans.add(new int[]{interval[0], interval[1]});
                    preEnd = interval[1];
                } else if (preEnd < interval[1]) {
                    //需要合并区间，把区间右端点更新
                    preEnd = interval[1];
                    ans.getLast()[1] = interval[1];
                }
            }
            return ans.toArray(new int[0][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0056_MergeIntervals().new Solution();
        // put your test code here
        print(solution.merge(Utils.toSquareArray("[[1,3],[2,6],[8,10],[15,18]]")));
    }
}