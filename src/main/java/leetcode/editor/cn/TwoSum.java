//<p>给定一个整数数组 <code>nums</code>&nbsp;和一个整数目标值 <code>target</code>，请你在该数组中找出 <strong>和为目标值 </strong><em><code>target</code></em>&nbsp; 的那&nbsp;<strong>两个</strong>&nbsp;整数，并返回它们的数组下标。</p>
//
//<p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。</p>
//
//<p>你可以按任意顺序返回答案。</p>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [2,7,11,15], target = 9
//<strong>输出：</strong>[0,1]
//<strong>解释：</strong>因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//</pre>
//
//<p><strong class="example">示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [3,2,4], target = 6
//<strong>输出：</strong>[1,2]
//</pre>
//
//<p><strong class="example">示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [3,3], target = 6
//<strong>输出：</strong>[0,1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
// <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li> 
// <li><strong>只会存在一个有效答案</strong></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>你可以想出一个时间复杂度小于 <code>O(n<sup>2</sup>)</code> 的算法吗？</p>
//
//<div><li>👍 17500</li><li>👎 0</li></div>

package leetcode.editor.cn;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TwoSum{
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] i = solution.twoSum(new int[]{3,2,7,5}, 9);
        log.info(Arrays.toString(i));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[1] = i;
                result[0] = map.get(nums[i]);
            }
            map.put(target - nums[i], i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}