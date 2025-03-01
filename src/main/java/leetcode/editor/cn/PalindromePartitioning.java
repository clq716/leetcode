//<p>给你一个字符串 <code>s</code>，请你将<em> </em><code>s</code><em> </em>分割成一些子串，使每个子串都是 <strong><span data-keyword="palindrome-string">回文串</span></strong> 。返回 <code>s</code> 所有可能的分割方案。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "aab"
//<strong>输出：</strong>[["a","a","b"],["aa","b"]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "a"
//<strong>输出：</strong>[["a"]]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length &lt;= 16</code></li> 
// <li><code>s</code> 仅由小写英文字母组成</li> 
//</ul>
//
//<div><li>👍 1960</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        solution.partition("aab");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        char[] alpha_bytes = s.toCharArray();
        findCurse(alpha_bytes, 0, new ArrayList<>(), results);
        return results;
    }


    private void findCurse(char[] alpha_bytes, int n, List<String> findStrs, List<List<String>> results) {
        for (int j = n; j < alpha_bytes.length; j++) {
            if (judge(alpha_bytes, n, j)) {
                List<String> next = new ArrayList<>(findStrs);
                next.add(new String(alpha_bytes, n, j - n + 1));
                if (j == alpha_bytes.length - 1) {
                    results.add(next);
                } else {
                    findCurse(alpha_bytes, j + 1, next, results);
                }
            }
        }
    }

    private boolean judge(char[] alpha_bytes, int left, int right) {
        int size = right + left;
        for (int i = left; i * 2 < size; i++) {
            if (alpha_bytes[i] != alpha_bytes[size - i]) return false;
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}