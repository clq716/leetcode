/**
<p>给你字符串 <code>s</code> 和整数 <code>k</code> 。</p>

<p>请返回字符串 <code>s</code> 中长度为 <code>k</code> 的单个子字符串中可能包含的最大元音字母数。</p>

<p>英文中的 <strong>元音字母 </strong>为（<code>a</code>, <code>e</code>, <code>i</code>, <code>o</code>, <code>u</code>）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "abciiidef", k = 3
<strong>输出：</strong>3
<strong>解释：</strong>子字符串 "iii" 包含 3 个元音字母。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = "aeiou", k = 2
<strong>输出：</strong>2
<strong>解释：</strong>任意长度为 2 的子字符串都包含 2 个元音字母。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = "leetcode", k = 3
<strong>输出：</strong>2
<strong>解释：</strong>"lee"、"eet" 和 "ode" 都包含 2 个元音字母。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = "rhythms", k = 4
<strong>输出：</strong>0
<strong>解释：</strong>字符串 s 中不含任何元音字母。
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>s = "tryhard", k = 4
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10^5</code></li> 
 <li><code>s</code> 由小写英文字母组成</li> 
 <li><code>1 &lt;= k &lt;= s.length</code></li> 
</ul>

<div><div>Related Topics</div><div><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 158</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;
public class MaximumNumberOfVowelsInASubstringOfGivenLength{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfVowelsInASubstringOfGivenLength().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxVowels(String s, int k) {
        boolean[] yy = new boolean[26];
        yy[0] = true;
        yy[4] = true;
        yy[8] = true;
        yy[14] = true;
        yy[20] = true;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (yy[s.charAt(i)-'a']) ans++;
        }
        int max = ans;
        for (int i = k; i < s.length(); i++) {
            if (ans==k) return k;
            if (yy[s.charAt(i)-'a']) ans++;
            if (yy[s.charAt(i-k)-'a']) ans--;
            max = Math.max(ans, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}