/**
<p>我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。</p>

<p>如果一个数的每位数字被旋转以后仍然还是一个数字，&nbsp;则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。</p>

<p>现在我们有一个正整数&nbsp;<code>N</code>, 计算从&nbsp;<code>1</code> 到&nbsp;<code>N</code> 中有多少个数&nbsp;X 是好数？</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入:</strong> 10
<strong>输出:</strong> 4
<strong>解释:</strong> 
在[1, 10]中有四个好数： 2, 5, 6, 9。
注意 1 和 10 不是好数, 因为他们在旋转之后不变。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>N&nbsp;的取值范围是&nbsp;<code>[1, 10000]</code>。</li> 
</ul>

<div><div>Related Topics</div><div><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 240</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;

import java.util.Arrays;

public class _0788_RotatedDigits{
    public static void main(String[] args) {
        Solution solution = new _0788_RotatedDigits().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static int[] DIFFS = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};


    public int rotatedDigits(int n) {
        char[] s = Integer.toString(n).toCharArray();
        int[][] memo = new int[s.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, true, s, memo);
    }

    private int dfs(int i, int hasDiff, boolean isLimit, char[] s, int[][] memo) {
        if (i == s.length) {
            return hasDiff; // 只有包含 2/5/6/9 才算一个好数
        }
        if (!isLimit && memo[i][hasDiff] >= 0) {
            return memo[i][hasDiff];
        }
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; d++) { // 枚举要填入的数字 d
            if (DIFFS[d] != -1) { // d 不是 3/4/7
                res += dfs(i + 1, hasDiff | DIFFS[d], isLimit && d == up, s, memo);
            }
        }
        if (!isLimit) {
            memo[i][hasDiff] = res;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}