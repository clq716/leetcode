//给定正整数 n ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。 
//
// 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 10
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// 👍 203 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _869_ReorderedPowerOf2{
    public static void main(String[] args) {
       Solution solution = new _869_ReorderedPowerOf2().new Solution();
       solution.reorderedPowerOf2(1000000000);
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean reorderedPowerOf2(int n) {
        if (n == 1) return true;
        String str = "" + n;
        char[] queue = str.toCharArray();
        Arrays.sort(queue);
        int len = str.length();
        int bottom = 1;
        while (len-->1) bottom *= 10;
        int top = bottom >= 10_0000_0000 ? Integer.MAX_VALUE : (bottom * 10);
        int i = 1;
        while (i < bottom) i <<= 1;
        while (i < top && i > 0) {
            char[] iQ = (""+i).toCharArray();
            Arrays.sort(iQ);
            boolean res = true;
            for (int j = 0; j < queue.length; j++) {
                res = (queue[j] == iQ[j]);
                if (!res) break;
            }
            if (res) return true;
            i <<= 1;
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}