//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// 👍 1277 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle{
    public static void main(String[] args) {
       Solution solution = new _118_PascalsTriangle().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = ans.get(i-1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 1; j < i; j++) {
                current.add(pre.get(j-1)+pre.get(j));
            }
            current.add(1);
            ans.add(current);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}