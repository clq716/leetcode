/**
<p>给你一个整数&nbsp;<code>n</code>&nbsp;，如果你可以将&nbsp;<code>n</code>&nbsp;表示成若干个不同的三的幂之和，请你返回&nbsp;<code>true</code>&nbsp;，否则请返回 <code>false</code>&nbsp;。</p>

<p>对于一个整数 <code>y</code>&nbsp;，如果存在整数 <code>x</code>&nbsp;满足 <code>y == 3<sup>x</sup></code>&nbsp;，我们称这个整数 <code>y</code>&nbsp;是三的幂。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>n = 12
<b>输出：</b>true
<b>解释：</b>12 = 3<sup>1</sup> + 3<sup>2</sup>
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>n = 91
<b>输出：</b>true
<b>解释：</b>91 = 3<sup>0</sup> + 3<sup>2</sup> + 3<sup>4</sup>
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>n = 21
<b>输出：</b>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 10<sup>7</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 146</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;

import java.util.*;

public class _1780_CheckIfNumberIsASumOfPowersOfThree{
    public static void main(String[] args) {
        Solution solution = new _1780_CheckIfNumberIsASumOfPowersOfThree().new Solution();

        int i = 12;
        StringBuilder s = new StringBuilder();
        while (i > 0) {
            s.append(i % 3);
            i/=3;
        }
        System.out.println(s.reverse());

        System.out.println(solution.checkPowersOfThree(1));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n%3==2) return false;
            n/=3;
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}