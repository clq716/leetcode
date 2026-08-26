package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 739: 每日温度
 * RedmiBook, Fedora
 * 2026-08-26 19:54:07
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0739_DailyTemperatures {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> temperDeque = new ArrayDeque<>();
            Deque<Integer> indexDeque = new ArrayDeque<>();
            int[] ans = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                int temprature = temperatures[i];
                while (!temperDeque.isEmpty() &&  temprature > temperDeque.peek()) {
                    //如果下一个温度大于栈顶的温度，移除栈顶，比较下标，一直到栈为空或者小于等于栈顶的元素
                    temperDeque.pop();
                    int preIndex = indexDeque.pop();
                    ans[preIndex] = i - preIndex;
                }
                //如果下一个温度小于等于栈顶的温度，把他放到栈顶
                temperDeque.push(temprature);
                indexDeque.push(i);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神从左到右的解法，直接在栈中存储下标，更加简洁
    class Solution1 {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] ans = new int[n];
            Deque<Integer> st = new ArrayDeque<>(); // todolist
            for (int i = 0; i < n; i++) {
                int t = temperatures[i];
                while (!st.isEmpty() && t > temperatures[st.peek()]) {
                    int j = st.pop();
                    ans[j] = i - j;
                }
                st.push(i);
            }
            return ans;
        }
    }

    static void main() {
        Solution solution = new $_0739_DailyTemperatures().new Solution();
        // put your test code here
        print(solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }
}