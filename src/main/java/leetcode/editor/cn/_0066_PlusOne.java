/**
<p>给定一个表示 <strong>大整数</strong> 的整数数组 <code>digits</code>，其中 <code>digits[i]</code> 是整数的第 <code>i</code> 位数字。这些数字按从左到右，从最高位到最低位排列。这个大整数不包含任何前导 <code>0</code>。</p>

<p>将大整数加 1，并返回结果的数字数组。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>digits = [1,2,3]
<strong>输出：</strong>[1,2,4]
<strong>解释：</strong>输入数组表示数字 123。
加 1 后得到 123 + 1 = 124。
因此，结果应该是 [1,2,4]。
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>digits = [4,3,2,1]
<strong>输出：</strong>[4,3,2,2]
<strong>解释：</strong>输入数组表示数字 4321。
加 1 后得到 4321 + 1 = 4322。
因此，结果应该是 [4,3,2,2]。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>digits = [9]
<strong>输出：</strong>[1,0]
<strong>解释：</strong>输入数组表示数字 9。
加 1 得到了 9 + 1 = 10。
因此，结果应该是 [1,0]。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= digits.length &lt;= 100</code></li> 
 <li><code>0 &lt;= digits[i] &lt;= 9</code></li> 
 <li><code>digits</code>&nbsp;不包含任何前导 <code>0</code>。</li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>数学</li></div></div><br><div><li>👍 1558</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;

import java.util.Arrays;

public class _0066_PlusOne{
    public static void main(String[] args) {
        Solution solution = new _0066_PlusOne().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    int[] result = new int[digits.length+1];
                    Arrays.fill(result, 0);
                    result[0] = 1;
                    return result;
                }
            }
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}