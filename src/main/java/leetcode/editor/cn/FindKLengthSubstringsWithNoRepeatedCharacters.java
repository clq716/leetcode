/**
<p>给你一个字符串&nbsp;<code>S</code>，找出所有长度为&nbsp;<code>K</code>&nbsp;且不含重复字符的子串，请你返回全部满足要求的子串的&nbsp;<strong>数目</strong>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>S = "havefunonleetcode", K = 5
<strong>输出：</strong>6
<strong>解释：</strong>
这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>S = "home", K = 5
<strong>输出：</strong>0
<strong>解释：</strong>
注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol> 
 <li><code>1 &lt;= S.length &lt;= 10^4</code></li> 
 <li><code>S</code> 中的所有字符均为小写英文字母</li> 
 <li><code>1 &lt;= K &lt;= 10^4</code></li> 
</ol>

<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 66</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FindKLengthSubstringsWithNoRepeatedCharacters{
    public static void main(String[] args) {
        Solution solution = new FindKLengthSubstringsWithNoRepeatedCharacters().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) return 0;
        int ans = 0;
        //可以用数组记录字符出现次数而不必用map
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
            if (i < k - 1) continue;
            if (cnt.size() == k) ans++;
            int left = cnt.get(s.charAt(i-k+1));
            if (left == 1) cnt.remove(s.charAt(i-k+1));
            else cnt.put(s.charAt(i-k+1), left-1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}