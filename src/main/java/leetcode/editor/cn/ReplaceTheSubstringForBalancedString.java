/**
<p>有一个只含有&nbsp;<code>'Q', 'W', 'E',&nbsp;'R'</code>&nbsp;四种字符，且长度为 <code>n</code>&nbsp;的字符串。</p>

<p>假如在该字符串中，这四个字符都恰好出现&nbsp;<code>n/4</code>&nbsp;次，那么它就是一个「平衡字符串」。</p>

<p>&nbsp;</p>

<p>给你一个这样的字符串 <code>s</code>，请通过「替换一个子串」的方式，使原字符串 <code>s</code> 变成一个「平衡字符串」。</p>

<p>你可以用和「待替换子串」长度相同的&nbsp;<strong>任何</strong> 其他字符串来完成替换。</p>

<p>请返回待替换子串的最小可能长度。</p>

<p>如果原字符串自身就是一个平衡字符串，则返回 <code>0</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "QWER"
<strong>输出：</strong>0
<strong>解释：</strong>s 已经是平衡的了。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "QQWE"
<strong>输出：</strong>1
<strong>解释：</strong>我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "QQQW"
<strong>输出：</strong>2
<strong>解释：</strong>我们可以把前面的 "QQ" 替换成 "ER"。 
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>s = "QQQQ"
<strong>输出：</strong>3
<strong>解释：</strong>我们可以替换后 3 个 'Q'，使 s = "QWER"。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10^5</code></li> 
 <li><code>s.length</code>&nbsp;是&nbsp;<code>4</code>&nbsp;的倍数</li> 
 <li><code>s</code>&nbsp;中只含有&nbsp;<code>'Q'</code>, <code>'W'</code>, <code>'E'</code>,&nbsp;<code>'R'</code>&nbsp;四种字符</li> 
</ul>

<div><div>Related Topics</div><div><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 326</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;
public class ReplaceTheSubstringForBalancedString{
    public static void main(String[] args) {
        Solution solution = new ReplaceTheSubstringForBalancedString().new Solution();
        //	测试结果:4
        //	期望结果:5
        solution.balancedString("WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int balancedString(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length, ans = n;
        int targetLen = n / 4;
        int[] qwer = new int[4];
        for (char ch : chs) qwer[idx(ch)]++;
        if (qwer[0] == qwer[1] && qwer[2] == qwer[3]) return 0;
        boolean[] find = new boolean[4];
        for (int i = 0; i < 4; i++) {
            qwer[i] = qwer[i] - targetLen;
            find[i] = qwer[i] > 0;
        }
        int[] cnt = new int[4];
        for (int l = 0, r = 0; r < n; r++) {
            int rid = idx(chs[r]);
            if (!find[rid]) continue;
            cnt[rid]++;
            while (cnt[rid] >= qwer[rid]) {
                int lid =  idx(chs[l]);
                if (!find[lid]) {
                    l++;
                    continue;
                }
                if (judge(find, cnt, qwer)) {
                    cnt[lid]--;
                    ans = Math.min(ans, r-l+1);
                    l++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    private boolean judge(boolean[] find, int[] cnt, int[] qwer) {
        for (int i = 0; i < 4; i++) if (find[i] && cnt[i] < qwer[i]) return false;
        return true;
    }

    private int idx(char ch) {
        switch (ch) {
            case 'Q': return 0;
            case 'W': return 1;
            case 'E': return 2;
            case 'R': return 3;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}