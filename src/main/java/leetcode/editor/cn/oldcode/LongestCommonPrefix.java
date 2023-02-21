//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package leetcode.editor.cn.oldcode;

public class LongestCommonPrefix{
    public static void main(String[] args) {
       Solution solution = new LongestCommonPrefix().new Solution();
       String[] strarrya = {"aa","a"};
       String str = solution.longestCommonPrefix(strarrya);
       String str1=str;
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String dupStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (dupStr.length() == 0 || strs[i].length()==0) {
                return "";
            }
            if (dupStr.length() > strs[i].length()) {
                dupStr = dupStr.substring(0, strs[i].length());
            }
            for (int j = 0; j <dupStr.length(); j++) {
                if (strs[i].charAt(j) != dupStr.charAt(j)) {
                    dupStr = dupStr.substring(0,j);
                    break;
                }
            }
        }
        return dupStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}