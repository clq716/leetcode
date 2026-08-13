package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 22: 括号生成
 * RedmiBook, Fedora
 * 2026-08-13 17:38:16
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0022_GenerateParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            char[] chars = new char[n << 1];
            dfs(chars, 0, 0, n, 0, ans);
            return ans;
        }

        /**
         * 遍历过程中
         * 如果右括号数量小于左括号数量，那么下一个可以是左括号或右括号
         * 如果右括号数量等于左括号数量，那么下一个只能是左括号
         * 如果右括号数量大于左括号数量，那就不合法，需要跳过
         * 当左括号数量 = n并且右括号数量 =n, 得到但结束
         */
        private void dfs(char[] chars, int countL, int countR, int n, int i, List<String> ans) {
            if (i == chars.length) {
                //可以不判断，固定会成立
//                if (countL == n && countR == n)
                    ans.add(new String(chars));
                return;
            }
            if (countL < n) {
                chars[i] = '(';
                dfs(chars, countL+1, countR, n, i+1, ans);
            }
            if (countR < n && countL > countR) {
                chars[i] = ')';
                dfs(chars, countL, countR+1, n, i+1, ans);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神选或不选的写法，和我一样，在遍历上用技巧省略了指针 i
    class Solution1 {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            char[] path = new char[n * 2]; // 所有括号长度都是一样的 2n
            dfs(0, 0, n, path, ans); // 一开始没有填括号
            return ans;
        }

        // 目前填了 left 个左括号，right 个右括号
        private void dfs(int left, int right, int n, char[] path, List<String> ans) {
            if (right == n) { // 填完 2n 个括号
                ans.add(new String(path));
                return;
            }
            if (left < n) { // 可以填左括号
                path[left + right] = '('; // 直接覆盖
                dfs(left + 1, right, n, path, ans);
            }
            if (right < left) { // 可以填右括号
                path[left + right] = ')'; // 直接覆盖
                dfs(left, right + 1, n, path, ans);
            }
        }
    }

    //灵神枚举选哪个的写法，对这个题来说会更复杂
    class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(0, 0, n, path, ans);
            return ans;
        }

        // 目前填了 i 个括号
        // 这 i 个括号中的左括号个数 - 右括号个数 = balance
        private void dfs(int i, int balance, int n, List<Integer> path, List<String> ans) {
            if (path.size() == n) {
                char[] s = new char[n * 2];
                Arrays.fill(s, ')');
                for (int j : path) {
                    s[j] = '(';
                }
                ans.add(new String(s));
                return;
            }
            // 枚举填 right=0,1,2,...,balance 个右括号
            for (int right = 0; right <= balance; right++) {
                // 先填 right 个右括号，然后填 1 个左括号，记录左括号的下标 i+right
                path.add(i + right);
                dfs(i + right + 1, balance - right + 1, n, path, ans);
                path.removeLast(); // path.remove(path.size() - 1);
            }
        }
    }


    static void main() {
        Solution solution = new $_0022_GenerateParentheses().new Solution();
        // put your test code here
        print(solution.generateParenthesis(3));
    }
}