package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 139: 单词拆分
 * RedmiBook, Fedora
 * 2026-08-27 14:10:51
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0139_WordBreak {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            wordDict.sort((a,b)->b.length() - a.length());
            int[] MEMO = new int[s.length()+1];
            return dfs(s, wordDict, 0, s.length(), MEMO);
        }

        private boolean dfs(String s, List<String> wordDict, int p, int n, int[] MEMO) {
            if (p == n) return true;
            if (MEMO[p] != 0) return MEMO[p] == 1;
            for (String word : wordDict) {
                if (s.startsWith(word, p)) {
                    if (dfs(s, wordDict, p + word.length(), n, MEMO)) {
                        MEMO[p] = 1;
                        return true;
                    }
                }
            }
            MEMO[p] = -1;
            return false;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0139_WordBreak().new Solution();
        // put your test code here
        print(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
        print(solution.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}