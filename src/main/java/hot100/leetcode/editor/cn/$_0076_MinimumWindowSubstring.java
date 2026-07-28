package hot100.leetcode.editor.cn;

import java.util.*;

import static utils.Printer.print;

/**
 * 76: 最小覆盖子串
 * RedmiBook, Fedora
 * 2026-07-27 10:11:59
 */
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0076_MinimumWindowSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] tcnt = new int['z' + 1];
            for (char tc : t.toCharArray()) {
                tcnt[tc]++;
            }
            String ans = "";
            int[] scnt = new int['z' + 1];
            int ts = t.length(), ss = s.length();;
            char[] schs = s.toCharArray();
            for (int l = 0, r = 0; r < ss; r++) {
                //右端移入
                scnt[schs[r]]++;
                if (r < ts - 1 || !find(tcnt, scnt)) {
                    continue;
                }
                //左端移出
                while (find(tcnt, scnt)) {
                    scnt[schs[l]]--;
                    l++;
                }
                //更新答案
                if (ans.isEmpty() || (r-l+2)<ans.length()) {
                    ans = new String(schs, l-1, r-l+2);
                }
            }
            return ans;
        }

        private boolean find(int[] tcnt, int[] scnt) {
            for (int i = 'A'; i <= 'Z'; i++) {
                if (tcnt[i] == 0) continue;
                if (tcnt[i] > scnt[i]) return false;
            }
            for (int i = 'a'; i <= 'z'; i++) {
                if (tcnt[i] == 0) continue;
                if (tcnt[i] > scnt[i]) return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神相同思路解法，O(52*(m+n))
    class Solution1 {
        public String minWindow(String S, String t) {
            int[] cntS = new int[128]; // s 子串字母的出现次数
            int[] cntT = new int[128]; // t 中字母的出现次数
            for (char c : t.toCharArray()) {
                cntT[c]++;
            }

            char[] s = S.toCharArray();
            int m = s.length;
            int ansLeft = -1;
            int ansRight = m;
            int left = 0;

            for (int right = 0; right < m; right++) { // 移动子串右端点
                cntS[s[right]]++; // 右端点字母移入子串
                while (isCovered(cntS, cntT)) { // 涵盖
                    if (right - left < ansRight - ansLeft) { // 找到更短的子串
                        ansLeft = left; // 记录此时的左右端点
                        ansRight = right;
                    }
                    cntS[s[left]]--; // 左端点字母移出子串
                    left++;
                }
            }

            return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
        }

        private boolean isCovered(int[] cntS, int[] cntT) {
            for (int i = 'A'; i <= 'Z'; i++) {
                if (cntS[i] < cntT[i]) {
                    return false;
                }
            }
            for (int i = 'a'; i <= 'z'; i++) {
                if (cntS[i] < cntT[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    //灵神 O(m+n) 解法
    class Solution2 {
        public String minWindow(String S, String t) {
            int[] diff = new int[128]; // 窗口每种字母个数 - t 每种字母个数
            int kinds = 0;
            for (char c : t.toCharArray()) {
                if (diff[c] == 0) {
                    kinds++; // 统计 t 有多少个不同的字母
                }
                diff[c]--;
            }

            char[] s = S.toCharArray();
            int m = s.length;
            int ansLeft = -1;
            int ansRight = m;
            int geCnt = 0; // 窗口内有 geCnt 种字母的出现次数 >= t 中相应字母的出现次数
            int left = 0;

            for (int right = 0; right < m; right++) { // 移动子串右端点
                char c = s[right]; // 右端点字母
                diff[c]++; // 右端点字母移入子串
                if (diff[c] == 0) { // 原来窗口内 c 的出现次数比 t 的少，现在一样多
                    geCnt++; // 从 < 变成 >=
                }

                while (geCnt == kinds) { // 涵盖：所有字母的出现次数都是 >=
                    if (right - left < ansRight - ansLeft) { // 找到更短的子串
                        ansLeft = left; // 记录此时的左右端点
                        ansRight = right;
                    }

                    char x = s[left]; // 左端点字母
                    if (diff[x] == 0) {
                        // x 移出窗口之前，检查出现次数，
                        // 如果窗口内 x 的出现次数和 t 一样，
                        // 那么 x 移出窗口后，窗口内 x 的出现次数比 t 的少
                        geCnt--; // 从 >= 变成 <
                    }
                    diff[x]--; // 左端点字母移出子串
                    left++;
                }
            }

            return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
        }
    }

    static void main() {
        Solution solution = new $_0076_MinimumWindowSubstring().new Solution();
        // put your test code here
        print(solution.minWindow("a", "aa"));
    }
}