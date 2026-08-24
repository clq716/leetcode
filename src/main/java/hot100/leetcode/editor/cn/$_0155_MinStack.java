package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 155: 最小栈
 * RedmiBook, Fedora
 * 2026-08-24 15:30:06
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0155_MinStack {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        Deque<int[]> deque;

        //这个是抄的灵神答案，我没找到正确思路
        public MinStack() {
            deque = new ArrayDeque<>();
            deque.push(new int[]{0, Integer.MAX_VALUE});
        }
        
        public void push(int value) {
            deque.push(new int[]{value, Math.min(getMin(), value)});
        }
        
        public void pop() {
            deque.pop();
        }
        
        public int top() {
            return deque.peek()[0];
        }
        
        public int getMin() {
            return deque.peek()[1];
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(value);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        // put your test code here
        
    }
}