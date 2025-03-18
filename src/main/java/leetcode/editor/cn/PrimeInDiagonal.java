/**
<p>给你一个下标从 <strong>0</strong> 开始的二维整数数组 <code>nums</code> 。</p>

<p>返回位于 <code>nums</code> 至少一条 <strong>对角线</strong> 上的最大 <strong>质数</strong> 。如果任一对角线上均不存在质数，返回<em> 0 。</em></p>

<p>注意：</p>

<ul> 
 <li>如果某个整数大于 <code>1</code> ，且不存在除 <code>1</code> 和自身之外的正整数因子，则认为该整数是一个质数。</li> 
 <li>如果存在整数 <code>i</code> ，使得&nbsp;<code>nums[i][i] = val</code> 或者&nbsp;<code>nums[i][nums.length - i - 1]= val</code> ，则认为整数 <code>val</code> 位于 <code>nums</code> 的一条对角线上。</li> 
</ul>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/03/06/screenshot-2023-03-06-at-45648-pm.png" style="width: 181px; height: 121px;" /></p>

<p>在上图中，一条对角线是 <strong>[1,5,9]</strong> ，而另一条对角线是<strong> [3,5,7]</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [[1,2,3],[5,6,7],[9,10,11]]
<strong>输出：</strong>11
<strong>解释：</strong>数字 1、3、6、9 和 11 是所有 "位于至少一条对角线上" 的数字。由于 11 是最大的质数，故返回 11 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [[1,2,3],[5,17,7],[9,11,10]]
<strong>输出：</strong>17
<strong>解释：</strong>数字 1、3、9、10 和 17 是所有满足"位于至少一条对角线上"的数字。由于 17 是最大的质数，故返回 17 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 300</code></li> 
 <li><code>nums.length == nums<sub>i</sub>.length</code></li> 
 <li><code>1 &lt;= nums<span style="">[i][j]</span>&nbsp;&lt;= 4*10<sup>6</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>矩阵</li><li>数论</li></div></div><br><div><li>👍 42</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;
public class PrimeInDiagonal{
    public static void main(String[] args) {
        int[][] ints = new int[3][3];
        ints[0][0] = 1;
        ints[0][1] = 2;
        ints[0][2] = 3;
        ints[1][0] = 5;
        ints[1][1] = 6;
        ints[1][2] = 7;
        ints[2][0] = 9;
        ints[2][1] = 10;
        ints[2][2] = 11;

        Solution solution = new PrimeInDiagonal().new Solution();
        solution.diagonalPrime(ints);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int diagonalPrime(int[][] nums) {
        int len = nums.length;
        int max = 0;
        //优化一: 底部向上重复遍历了，可以去除
        for (int i = 0; i < len; i++) {
            int left_top = nums[i][i];
            int right_top = nums[i][len-i-1];
//            int left_bottom = nums[len-i-1][i];
//            int right_bottom = nums[len-i-1][len-i-1];
            if (left_top > max && zhishu(left_top)) max = left_top;
            if (right_top > max && zhishu(right_top)) max = right_top;
//            if (left_bottom > max && zhishu(left_bottom)) max = left_bottom;
//            if (right_bottom > max && zhishu(right_bottom)) max = right_bottom;
        }
        return max;
    }
    private boolean zhishu(int num) {
        //优化二: 判断质数从 [2, 根号N] 就可以
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return num > 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}