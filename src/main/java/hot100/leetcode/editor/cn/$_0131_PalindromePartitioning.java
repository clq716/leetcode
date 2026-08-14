package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 131: 分割回文串
 * RedmiBook, Fedora
 * 2026-08-14 10:23:30
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0131_PalindromePartitioning {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            char[] chars = s.toCharArray();
            List<List<String>> ans = new ArrayList<>();
            //经过测试，执行效率 ArrayList > ArrayDeque >>> LinkedList
            dfs(chars, 0, 0, new ArrayList<>(), ans);
            return ans;
        }

        private void dfs(char[] chars, int i, int j, List<String> path, List<List<String>> ans) {
            if (j == chars.length) {
                //找到了
                if (i == chars.length) {
                    ans.add(new ArrayList<>(path));
                }
                return;
            }
            if (recurse(chars, i, j)) {
                //选
                path.add(new String(chars, i, j+1-i));
                dfs(chars, j+1, j+1, path, ans);
                //恢复
                path.removeLast();
            }
            //不选
            dfs(chars, i, j+1, path, ans);
        }

        private boolean recurse(char[] chars, int i, int j) {
            while (i < j) {
                if (chars[i++] != chars[j--]) return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神选或不选的写法，和我的思路相同
    class Solution1 {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            List<String> path = new ArrayList<>();
            dfs(0, 0, s, path, ans);
            return ans;
        }

        // 现在 s 未被分割的部分为 [start, n-1]
        // 当前位于下标 i，讨论是否在 i 和 i+1 之间切一刀
        private void dfs(int i, int start, String s, List<String> path, List<List<String>> ans) {
            if (i == s.length()) { // s 分割完毕
                ans.add(new ArrayList<>(path)); // 复制 path
                return;
            }

            // 不分割
            if (i < s.length() - 1) { // i=n-1 时必须分割（这是最后一段），i<n-1 时才可以不分割
                dfs(i + 1, start, s, path, ans);
            }

            // 分割，那么得到子串 [start, i]
            if (isPalindrome(s, start, i)) { // 判断子串 [start, i] 是不是回文串
                path.add(s.substring(start, i + 1));
                // 现在 s 未被分割的部分为 [i+1, n-1]
                dfs(i + 1, i + 1, s, path, ans);
                path.removeLast(); // path.remove(path.size() - 1);
            }
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }

    //灵神枚举答案的写法，我之前喜欢这种思路
    class Solution2 {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            List<String> path = new ArrayList<>();
            dfs(0, s, path, ans);
            return ans;
        }

        // 现在 s 未被分割的部分为 [i, n-1]
        // 枚举下一刀切在哪
        private void dfs(int i, String s, List<String> path, List<List<String>> ans) {
            if (i == s.length()) { // s 分割完毕
                ans.add(new ArrayList<>(path)); // 复制 path
                return;
            }
            for (int j = i; j < s.length(); j++) { // 枚举子串的结束位置
                if (isPalindrome(s, i, j)) { // 判断 [i, j] 是不是回文串
                    path.add(s.substring(i, j + 1)); // 分割！
                    // 现在 s 未被分割的部分为 [j+1, n-1]
                    dfs(j + 1, s, path, ans);
                    path.removeLast(); // path.remove(path.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
    
    static void main() {
        Solution solution = new $_0131_PalindromePartitioning().new Solution();
        // put your test code here
        
    }
}