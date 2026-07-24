package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
/**
 * 560: 和为 K 的子数组
 * RedmiBook, Fedora
 * 2026-07-24 10:43:24
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0560_SubarraySumEqualsK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int ans = 0, sum = 0;
            Map<Integer, Integer> cnt = new HashMap<>();
            //这行很关键，对于前缀和数组，pre[0] = 0, 所以肯定有一个0
            //这样写能节约很多逻辑，不然调整指针或者 +- 1 能把人逼疯
            cnt.put(0, 1);
            for (int num : nums) {
                sum += num;
                ans += cnt.getOrDefault(sum - k, 0);
                cnt.merge(sum, 1, Integer::sum);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 灵神解法
     * 在前缀和累计前维护hashMap, 避免会把自身也进行计数，并能省略掉 cnt.put(0, 1);
     */
    class Solution1 {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> cnt = new HashMap<>(nums.length, 1); // 预分配空间
            int s = 0;
            int ans = 0;
            for (int x : nums) {
                cnt.merge(s, 1, Integer::sum); // cnt[s]++
                s += x;
                ans += cnt.getOrDefault(s - k, 0);
            }
            return ans;
        }
    }
    
    static void main() {
        Solution solution = new $_0560_SubarraySumEqualsK().new Solution();
        // put your test code here
        print(solution.subarraySum(new int[]{-1,-1,1}, 0)); //1
        print(solution.subarraySum(new int[]{-1,-1,1}, 1)); //1
        print(solution.subarraySum(new int[]{1,1,1}, 2)); //2

    }
}