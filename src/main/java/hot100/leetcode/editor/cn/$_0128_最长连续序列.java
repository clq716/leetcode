package hot100.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static utils.Printer.print;

/**
 * 2026-07-22 09:30:29
 * RedmiBook, Fedora
 */
public class $_0128_最长连续序列 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            int ans = 0;
            //使用了3个hash集合，相比灵神的单个hashSet, 计算速度慢了很多
            //不必过度追求在1次循环中同时记录和比较结果，代码更复杂，反而执行效率更低
            Set<Integer> walked = new HashSet<>();
            Map<Integer, Integer> lowHigh = new HashMap<>(), highLow = new HashMap<>();
            for (int num : nums) {
                if (walked.contains(num)) continue;
                Integer low = highLow.get(num - 1);
                Integer high = lowHigh.get(num + 1);
                if (low == null) low = num;
                if (high == null) high = num;
                lowHigh.put(low, high);
                highLow.put(high, low);
                ans = Math.max(ans, high - low + 1);
                walked.add(num);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 灵神解法
     * 我一开始也想到这点，用HashSet来判断
     * 但是我是用的 向前和向后 remove 一个随机元素的方式，结果计算超时
     * 当时我想过在数组里遍历，但是没想到可以通过 contains continue 来过滤元素，下意识以为这样会出现 O(n^2) 的时间复杂度
     */
    class Solution1 {
        public int longestConsecutive(int[] nums) {
            Set<Integer> st = new HashSet<>();
            for (int num : nums) {
                st.add(num); // 把 nums 转成哈希集合
            }
            int m = st.size();

            int ans = 0;
            for (int x : st) { // 遍历哈希集合
                if (st.contains(x - 1)) { // 如果 x 不是序列的起点，直接跳过
                    continue;
                }
                // x 是序列的起点
                int y = x + 1;
                while (st.contains(y)) { // 不断查找下一个数是否在哈希集合中
                    y++;
                }
                // 循环结束后，y-1 是最后一个在哈希集合中的数
                ans = Math.max(ans, y - x); // 从 x 到 y-1 一共 y-x 个数
                if (ans * 2 >= m) {
                    break;
                }
            }
            return ans;
        }
    }
    
    static void main() {
        Solution solution = new $_0128_最长连续序列().new Solution();
        // put your test code here
        print(solution.longestConsecutive(new int[]{1,2,4,5,3,0,3,6,7}));
    }
}