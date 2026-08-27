package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 3: 无重复字符的最长子串
 * RedmiBook, Fedora
 * 2026-08-27 16:39:53
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0003_LongestSubstringWithoutRepeatingCharacters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chs = s.toCharArray();
            int n = chs.length;
            boolean[] cnt = new boolean[128];
            int ans = 0;
            for (int l = 0, r = 0; r < n; r++) {
                //判断是否重复
                while (cnt[chs[r]]) {
                    //包含重复元素
                    //左端点向右移动
                    cnt[chs[l]] = false;
                    l++;
                }
                //更新答案
                ans = Math.max(ans, r-l+1);
                //划入新元素
                cnt[chs[r]] = true;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0003_LongestSubstringWithoutRepeatingCharacters().new Solution();
        // put your test code here
        
    }
}