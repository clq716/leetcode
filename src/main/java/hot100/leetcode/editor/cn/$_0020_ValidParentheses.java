package hot100.leetcode.editor.cn;

import java.util.*;  
import utils.*;  
import static utils.Printer.print;
 /**
 * 20: 有效的括号
 * Lenovo, Windows11
 * 2026-08-16 15:54:50
 */
 @SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0020_ValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> deque = new ArrayDeque<>();
            char[] chars = s.toCharArray();
			for (char aChar : chars) {
				if (aChar == ')' && deque.peekLast() != null && deque.peekLast() == '(') deque.removeLast();
				else if (aChar == ']' && deque.peekLast() != null && deque.peekLast() == '[') deque.removeLast();
				else if (aChar == '}' && deque.peekLast() != null && deque.peekLast() == '{') deque.removeLast();
				else deque.offer(aChar);
			}
            return deque.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

     //灵神解法
     class Solution1 {
         public boolean isValid(String s) {
             if (s.length() % 2 != 0) { // s 长度必须是偶数
                 return false;
             }
             Deque<Character> st = new ArrayDeque<>();
             for (char c : s.toCharArray()) {
                 if (c == '(') {
                     st.push(')'); // 入栈对应的右括号
                 } else if (c == '[') {
                     st.push(']');
                 } else if (c == '{') {
                     st.push('}');
                 } else if (st.isEmpty() || st.pop() != c) { // c 是右括号
                     return false; // 没有左括号，或者左括号类型不对
                 }
             }
             return st.isEmpty(); // 所有左括号必须匹配完毕
         }
     }
    
    static void main() {
        Solution solution = new $_0020_ValidParentheses().new Solution();
        // put your test code here
        
    }
}