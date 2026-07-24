package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
/**
 * 239: 滑动窗口最大值
 * RedmiBook, Fedora
 * 2026-07-24 13:20:48
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0239_SlidingWindowMaximum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) deque.removeLast();
                deque.addLast(i);
                if (i < k - 1) continue;
                ans[i - k + 1] = nums[deque.getFirst()];
                if (deque.getFirst() <= (i - k + 1)) deque.removeFirst();
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 灵神解法
     */
    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n - k + 1]; // 窗口个数
            Deque<Integer> q = new ArrayDeque<>(); // 更快的写法见【Java 数组】

            for (int i = 0; i < n; i++) {
                // 1. 右边入
                while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                    q.removeLast(); // 维护 q 的单调性
                }
                q.addLast(i); // 注意保存的是下标，这样下面可以判断队首是否离开窗口

                // 2. 左边出
                int left = i - k + 1; // 窗口左端点
                if (q.getFirst() < left) { // 队首离开窗口
                    q.removeFirst();
                }

                // 3. 在窗口左端点处记录答案
                if (left >= 0) {
                    // 由于队首到队尾单调递减，所以窗口最大值就在队首
                    ans[left] = nums[q.getFirst()];
                }
            }

            return ans;
        }
    }

    /**
     * 第一版答案
     * 滑动窗口 + 计数器，执行效率比较低
     */
    class SolutionBackUp {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            TreeMap<Integer, Integer> cnt = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                cnt.merge(nums[i], 1, Integer::sum);
                if (i < k - 1) continue;
                ans[i - k + 1] = cnt.lastKey();
                int c = cnt.get(nums[i - k+ 1]);
                if (c == 1) cnt.remove(nums[i - k+ 1]);
                else cnt.put(nums[i - k+ 1], c - 1);
            }
            return ans;
        }
    }

    static void main() {
        Solution solution = new $_0239_SlidingWindowMaximum().new Solution();
        // put your test code here
        // print("[3,3,5,5,6,7] = " + Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        print("[1,-1] = " + Arrays.toString(solution.maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}