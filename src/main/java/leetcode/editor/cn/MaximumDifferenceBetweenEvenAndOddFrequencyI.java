//给你一个由小写英文字母组成的字符串 s 。 
//
// 请你找出字符串中两个字符 a1 和 a2 的出现频次之间的 最大 差值 diff = a1 - a2，这两个字符需要满足： 
//
// 
// a1 在字符串中出现 奇数次 。 
// a2 在字符串中出现 偶数次 。 
// 
//
// 返回 最大 差值。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "aaaaabbc" 
// 
//
// 输出：3 
//
// 解释： 
//
// 
// 字符 'a' 出现 奇数次 ，次数为 5 ；字符 'b' 出现 偶数次 ，次数为 2 。 
// 最大差值为 5 - 2 = 3 。 
// 
//
// 示例 2： 
//
// 
// 输入：s = "abcabcab" 
// 
//
// 输出：1 
//
// 解释： 
//
// 
// 字符 'a' 出现 奇数次 ，次数为 3 ；字符 'c' 出现 偶数次 ，次数为 2 。 
// 最大差值为 3 - 2 = 1 。 
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 100 
// s 仅由小写英文字母组成。 
// s 至少由一个出现奇数次的字符和一个出现偶数次的字符组成。 
// 
//
// 👍 10 👎 0


package leetcode.editor.cn;
public class MaximumDifferenceBetweenEvenAndOddFrequencyI{
    public static void main(String[] args) {
       Solution solution = new MaximumDifferenceBetweenEvenAndOddFrequencyI().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDifference(String s) {
        int ans = 0;
        char[] chs = s.toCharArray();
        int[] cnt = new int['z'+1];
        for (char ch : chs) cnt[ch]++;
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 'a'; i <= 'z'; i++) {
            if (cnt[i] == 0) continue;
            if (cnt[i] % 2 == 0) {
                min = Math.min(cnt[i], min);
            } else {
                max = Math.max(cnt[i], max);
            }
        }
        return max - min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}