package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 347: 前 K 个高频元素
 * RedmiBook, Fedora
 * 2026-08-26 21:43:22
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0347_TopKFrequentElements {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int num : nums) cnt.merge(num, 1, Integer::sum);
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            queue.addAll(cnt.entrySet());
            int[] ans = new int[k];
            while (k-->0) ans[k] = queue.poll().getKey();
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神桶排序的做法
    class Solution1 {
        public int[] topKFrequent(int[] nums, int k) {
            // 第一步：统计每个元素的出现次数
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : nums) {
                cnt.merge(x, 1, Integer::sum); // cnt[x]++
            }
            int maxCnt = Collections.max(cnt.values());

            // 第二步：把出现次数相同的元素，放到同一个桶中
            List<Integer>[] buckets = new ArrayList[maxCnt + 1];
            Arrays.setAll(buckets, _ -> new ArrayList<>());
            for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
                buckets[e.getValue()].add(e.getKey());
            }

            // 第三步：倒序遍历 buckets，把出现次数前 k 大的元素加入答案
            int[] ans = new int[k];
            int j = 0;
            for (int i = maxCnt; j < k; i--) {
                // 注意题目保证答案唯一，一定会出现某次循环结束后 j 恰好等于 k 的情况
                for (int x : buckets[i]) {
                    ans[j++] = x;
                }
            }
            return ans;
        }
    }
    
    static void main() {
        Solution solution = new $_0347_TopKFrequentElements().new Solution();
        // put your test code here
        
    }
}