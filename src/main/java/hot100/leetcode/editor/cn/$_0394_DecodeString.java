package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 394: 字符串解码
 * RedmiBook, Fedora
 * 2026-08-24 15:53:13
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0394_DecodeString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //我的单调栈写法
        public String decodeString(String s) {
            Deque<StringBuilder> strDeque = new ArrayDeque<>();
            Deque<Integer> numDeque = new ArrayDeque<>();
            strDeque.push(new StringBuilder());
            char[] chs = s.toCharArray();
            int multiple = 0;
            for (char ch : chs) {
                if (ch >= 'a' && ch <= 'z') {
                    strDeque.peek().append(ch);
                } else if (ch >= '0' && ch <= '9') {
                    multiple = multiple * 10 + (ch - '0');
                } else if (ch == '[') {
                    strDeque.push(new StringBuilder());
                    numDeque.push(multiple);
                    multiple = 0;
                } else if (ch == ']') {
                    StringBuilder builder = strDeque.pop();
                    strDeque.peek().repeat(builder, numDeque.pop());
                }
            }
            return strDeque.pop().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //我的递归写法，去年华为二面手撕的就是这道题
    class Solution1 {
        public String decodeString(String s) {
            return traverse(s.toCharArray()).toString();
        }
        int p = -1;
        private StringBuilder traverse(char[] chs) {
            StringBuilder preStr = new StringBuilder();
            int multiCount = 0;
            while (p < chs.length-1) {
                p++;
                if (chs[p] >= 'a' && chs[p] <= 'z') {
                    preStr.append(chs[p]);
                } else if (chs[p] >= '0' && chs[p] <= '9') {
                    multiCount = multiCount*10 + (chs[p] - '0');
                } else if (chs[p] == '[') {
                    StringBuilder s = traverse(chs);
                    while (multiCount-->0) preStr.append(s);
                    multiCount = 0;
                } else if (chs[p] == ']') {
                    return preStr;
                }
            }
            return preStr;
        }
    }
    //灵神的单调栈写法
    class Solution2 {
        private record Pair(String s, int k) {
        }

        public String decodeString(String s) {
            Deque<Pair> stack = new ArrayDeque<>(); // 用于模拟计算机的递归
            StringBuilder res = new StringBuilder();
            int k = 0;
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    res.append(c);
                } else if (Character.isDigit(c)) {
                    k = k * 10 + (c - '0');
                } else if (c == '[') {
                    // 模拟递归
                    // 在递归之前，把当前递归函数中的局部变量 res 和 k 保存到栈中
                    stack.push(new Pair(res.toString(), k));
                    // 递归，初始化 res 和 k
                    res.setLength(0);
                    k = 0;
                } else { // ']'
                    // 递归结束，从栈中恢复递归之前保存的局部变量
                    Pair p = stack.pop();
                    // 此时 res 是下层递归的返回值，将其重复 p.k 次，拼接到递归前的 p.s 之后
                    res = new StringBuilder(p.s).repeat(res, p.k);
                }
            }
            return res.toString();
        }
    }
    static void main() {
        Solution solution = new $_0394_DecodeString().new Solution();
        // put your test code here
        print(new $_0394_DecodeString().new Solution().decodeString("3[a]2[bc]"));
        print(new $_0394_DecodeString().new Solution().decodeString("3[a2[c]]"));
        print(new $_0394_DecodeString().new Solution().decodeString("2[abc]3[cd]ef"));
        print(new $_0394_DecodeString().new Solution().decodeString("abc3[cd]xyz"));
    }
}