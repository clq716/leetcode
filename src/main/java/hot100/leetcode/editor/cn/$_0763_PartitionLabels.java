package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 763: 划分字母区间
 * RedmiBook, Fedora
 * 2026-08-24 14:50:48
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0763_PartitionLabels {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //看了提示里的统计字母最右位置，才想出了解法
        //贪心很多都是枚举左，比较右
        public List<Integer> partitionLabels(String s) {
            int[] maxRight = new int['z'+1];
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                maxRight[chs[i]] = i;
            }
            List<Integer> ans = new ArrayList<>();
            int l = 0, maxR = 0;
            for (int r = 0; r < chs.length; r++) {
                maxR = Math.max(maxR, maxRight[chs[r]]);
                if (r == maxR) {
                    ans.add(r-l+1);
                    l = r+1;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    //灵神解法
    class Solution1 {
        public List<Integer> partitionLabels(String S) {
            char[] s = S.toCharArray();
            int n = s.length;
            int[] last = new int[26];
            for (int i = 0; i < n; i++) {
                last[s[i] - 'a'] = i; // 每个字母最后出现的下标
            }

            List<Integer> ans = new ArrayList<>();
            int start = 0, end = 0;
            for (int i = 0; i < n; i++) {
                end = Math.max(end, last[s[i] - 'a']); // 更新当前区间右端点的最大值
                if (end == i) { // 当前区间合并完毕
                    ans.add(end - start + 1); // 区间长度加入答案
                    start = end + 1; // 下一个区间的左端点
                }
            }
            return ans;
        }
    }

    
    static void main() {
        Solution solution = new $_0763_PartitionLabels().new Solution();
        // put your test code here
        print(solution.partitionLabels("qvmwtmzzse"));
    }
}