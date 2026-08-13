package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 17: 电话号码的字母组合
 * RedmiBook, Fedora
 * 2026-08-13 15:12:00
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0017_LetterCombinationsOfAPhoneNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char[][] phoneNumbers =  new char[][]{
                {'a', 'b', 'c'}, // 2
                {'d', 'e', 'f'}, // 3
                {'g', 'h', 'i'}, // 4
                {'j', 'k', 'l'}, // 5
                {'m', 'n', 'o'}, // 6
                {'p', 'q', 'r', 's'}, // 7
                {'t', 'u', 'v'}, // 8
                {'w', 'x', 'y', 'z'}, // 9
        };

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            dfs(ans, new char[digits.length()], 0, digits.toCharArray());
            return ans;
        }

        private void dfs(List<String> ans, char[] path, int i, char[] chars) {
            if (i == chars.length) {
                ans.add(new String(path));
                return;
            }
            //注意这里不需要循环 i
            char[] numbers = phoneNumbers[chars[i]-'2'];
            for (char number : numbers) {
                path[i] = number;
                dfs(ans, path, i + 1, chars);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0017_LetterCombinationsOfAPhoneNumber().new Solution();
        // put your test code here
        print(solution.letterCombinations("23"));
    }
}