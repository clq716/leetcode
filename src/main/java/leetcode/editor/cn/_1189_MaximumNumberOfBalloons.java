/**
<p>给你一个字符串&nbsp;<code>text</code>，你需要使用 <code>text</code> 中的字母来拼凑尽可能多的单词&nbsp;<strong>"balloon"（气球）</strong>。</p>

<p>字符串&nbsp;<code>text</code> 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词&nbsp;<strong>"balloon"</strong>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.cn/aliyun-lc-upload/uploads/2019/09/14/1536_ex1_upd.jpeg" style="height: 35px; width: 154px;" /></strong></p>

<pre>
<strong>输入：</strong>text = "nlaebolko"
<strong>输出：</strong>1
</pre>

<p><strong class="example">示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.cn/aliyun-lc-upload/uploads/2019/09/14/1536_ex2_upd.jpeg" style="height: 35px; width: 233px;" /></strong></p>

<pre>
<strong>输入：</strong>text = "loonbalxballpoon"
<strong>输出：</strong>2
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>text = "leetcode"
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= text.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>text</code>&nbsp;全部由小写英文字母组成</li> 
</ul>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题与&nbsp;<a href="https://leetcode.cn/problems/rearrange-characters-to-make-target-string/">2287. 重排字符形成目标字符串</a>&nbsp;相同。</p>

<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>计数</li></div></div><br><div><li>👍 161</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;
public class _1189_MaximumNumberOfBalloons{
    public static void main(String[] args) {
        Solution solution = new _1189_MaximumNumberOfBalloons().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int['z'+1];
        for (char ch : text.toCharArray()) {
            cnt[ch]++;
        }
        int result = cnt['b'];
        result = Math.min(cnt['a'], result);
        result = Math.min(cnt['n'], result);
        result = Math.min(cnt['l']/2, result);
        result = Math.min(cnt['o']/2, result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}