//给你一个字符串 s ，如果该字符串的某个排列是 回文串 ，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "code"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "carerac"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 位运算 哈希表 字符串 👍 85 👎 0


package leetcode.editor.cn;
public class PalindromePermutation{
    public static void main(String[] args) {
       Solution solution = new PalindromePermutation().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean[] counts = new boolean[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a'] = !counts[ch - 'a'];
        }
        boolean hasTrue = false;
        for (boolean b : counts) {
            if (b) {
                if (hasTrue) return false;
                hasTrue = true;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}