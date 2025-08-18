//给定一个长度为4的整数数组 cards 。你有 4 张卡片，每张卡片上都包含一个范围在 [1,9] 的数字。您应该使用运算符 ['+', '-', '*',
// '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式，以获得值24。 
//
// 你须遵守以下规则: 
//
// 
// 除法运算符 '/' 表示实数除法，而不是整数除法。 
// 
//
// 
// 例如， 4 /(1 - 2 / 3)= 4 /(1 / 3)= 12 。 
// 
// 
// 每个运算都在两个数字之间。特别是，不能使用 “-” 作为一元运算符。
// 
// 例如，如果 cards =[1,1,1,1] ，则表达式 “-1 -1 -1 -1” 是 不允许 的。 
// 
// 
// 你不能把数字串在一起
// 
// 例如，如果 cards =[1,2,1,2] ，则表达式 “12 + 12” 无效。 
// 
// 
//
//
// 如果可以得到这样的表达式，其计算结果为 24 ，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: cards = [4, 1, 8, 7]
//输出: true
//解释: (8-4) * (7-1) = 24
// 
//
// 示例 2: 
//
// 
//输入: cards = [1, 2, 1, 2]
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// cards.length == 4 
// 1 <= cards[i] <= 9 
// 
//
// 👍 503 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _679_Two4Game{
    public static void main(String[] args) {
       Solution solution = new _679_Two4Game().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
			private static final double EPS = 1e-9;

			public boolean judgePoint24(int[] cards) {
				List<Double> a = new ArrayList<>();
				for (int x : cards) {
					a.add((double) x);
				}
				return dfs(a);
			}

			private boolean dfs(List<Double> cards) {
				int n = cards.size();
				if (n == 1) {
					return Math.abs(cards.get(0) - 24) < EPS;
				}

				// 选两张牌 x=cards[i] 和 y=cards[j]
				for (int i = 0; i < n; i++) {
					double x = cards.get(i);
					for (int j = i + 1; j < n; j++) {
						double y = cards.get(j);

						// 六种情况：加减乘除，其中减和除都有两种不同的顺序
						List<Double> candidates = new ArrayList<>();
						candidates.add(x + y);
						candidates.add(x - y);
						candidates.add(y - x);
						candidates.add(x * y);
						if (Math.abs(y) > EPS) { // 保证分母不为 0
							candidates.add(x / y);
						}
						if (Math.abs(x) > EPS) { // 保证分母不为 0
							candidates.add(y / x);
						}

						List<Double> newCards = new ArrayList<>(cards);
						newCards.remove(j); // 删除 j
						for (double res : candidates) {
							newCards.set(i, res); // 覆盖 i
							if (dfs(newCards)) {
								return true;
							}
						}
					}
				}
				return false;
			}
}
//leetcode submit region end(Prohibit modification and deletion)

}