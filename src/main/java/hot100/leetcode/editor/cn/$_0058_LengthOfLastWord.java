package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 58: 最后一个单词的长度
 * RedmiBook, Fedora
 * 2026-08-27 17:00:08
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0058_LengthOfLastWord {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            char[] chs = s.toCharArray();
            int n = chs.length;
            int r = -1;
            for (int i = n-1; i >= 0; i--) {
                if (chs[i] == ' ') {
                    if (r != -1) return r-i;
                } else if (r == -1) {
                    r = i;
                }
            }
            return r == -1 ? s.length() : r+1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0058_LengthOfLastWord().new Solution();
        // put your test code here
        print(solution.lengthOfLastWord("a "));
    }
}