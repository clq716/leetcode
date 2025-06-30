/**
<p>给你一个由 <code>n</code> 个整数组成的数组&nbsp;<code>nums</code> ，和一个目标值 <code>target</code> 。请你找出并返回满足下述全部条件且<strong>不重复</strong>的四元组&nbsp;<code>[nums[a], nums[b], nums[c], nums[d]]</code>&nbsp;（若两个四元组元素一一对应，则认为两个四元组重复）：</p>

<ul> 
 <li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li> 
 <li><code>a</code>、<code>b</code>、<code>c</code> 和 <code>d</code> <strong>互不相同</strong></li> 
 <li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li> 
</ul>

<p>你可以按 <strong>任意顺序</strong> 返回答案 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,0,-1,0,-2,2], target = 0
<strong>输出：</strong>[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,2,2,2,2], target = 8
<strong>输出：</strong>[[2,2,2,2]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 200</code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 2075</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018_FourSum{
    public static void main(String[] args) {
        Solution solution = new _0018_FourSum().new Solution();
        solution.fourSum(new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000},1000000000);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len-3; i++) {
            if ((long)nums[i] + (long)nums[i+1] + (long)nums[i+2] + (long)nums[i+3] > target) break;
            if ((long)nums[i] + (long)nums[len-3] + (long)nums[len-2] + (long)nums[len-1] < target) continue;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < len-2; j++) {
                long ij = (long)nums[i] + (long)nums[j];
                if (ij + (long)nums[j+1] + (long)nums[j+2] > target) break;
                if (ij + (long)nums[len-2] + (long)nums[len-1] < target) continue;
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                int m = j + 1;
                int n = len - 1;
                while (m < n) {
                    long ijmn = ij + (long)nums[m] + (long)nums[n];
                    if (ijmn == target) {
                        ans.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        do m++;
                        while (m < len - 1 && nums[m] == nums[m-1]);
                    } else if (ijmn < target) {
                        do m++;
                        while (m < len - 1 && nums[m] == nums[m-1]);
                    } else {
                        do n--;
                        while (nums[n] == nums[n+1]);
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}