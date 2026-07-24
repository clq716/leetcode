package hot100.leetcode.editor.cn;

import java.util.*;
import static utils.Printer.print;
 /**
 * 2026-07-23 13:34:02
 * RedmiBook, Fedora
 */
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0438_找到字符串中所有字母异位词 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int ps = p.length(), ss = s.length();;
            if (ps > ss) return ans;
            int[] scnt = new int[26], pcnt = new int[26];
            char[] pchs = p.toCharArray(), schs = s.toCharArray();
            //提前对其左侧部分窗口
            for (int i = 0; i < ps; i++) {
                scnt[schs[i] - 'a']++;
                pcnt[pchs[i] - 'a']++;
            }
            for (int i = ps; i < ss; i++) {
                if (equals(scnt, pcnt)) ans.add(i - ps);
                scnt[schs[i] - 'a']++;
                scnt[schs[i-ps] - 'a']--;
            }
            if (equals(scnt, pcnt)) ans.add(ss - ps);
            return ans;
        }

        //Arrays.equals 多加了非空和长度判断，所以手动实现了一下
        private boolean equals(int[] scnt, int[] pcnt) {
            for (int j = 0; j < 26; j++) if (scnt[j] != pcnt[j]) return false;
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

     //灵神定长滑窗
     class Solution1 {
         public List<Integer> findAnagrams(String s, String p) {
             // 统计 p 的每种字母的出现次数
             int[] cntP = new int[26];
             for (char c : p.toCharArray()) {
                 cntP[c - 'a']++; // 统计 p 的字母
             }

             List<Integer> ans = new ArrayList<>();
             int[] cntS = new int[26]; // 统计 s 的长为 p.length() 的子串 t 的每种字母的出现次数
             for (int right = 0; right < s.length(); right++) {
                 cntS[s.charAt(right) - 'a']++; // 右端点字母进入窗口
                 int left = right - p.length() + 1;
                 if (left < 0) { // 窗口长度不足 p.length()
                     continue;
                 }
                 if (Arrays.equals(cntS, cntP)) { // t 和 p 的每种字母的出现次数都相同
                     ans.add(left); // t 左端点下标加入答案
                 }
                 cntS[s.charAt(left) - 'a']--; // 左端点字母离开窗口
             }
             return ans;
         }
     }

    static void main() {
        Solution solution = new $_0438_找到字符串中所有字母异位词().new Solution();
        // put your test code here
        print(solution.findAnagrams("abab", "ab"));
    }
}