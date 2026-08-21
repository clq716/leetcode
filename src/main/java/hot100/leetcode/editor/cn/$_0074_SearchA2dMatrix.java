package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 74: 搜索二维矩阵
 * RedmiBook, Fedora
 * 2026-08-14 16:21:05
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0074_SearchA2dMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //二分每一行第一个数字
            int rows = matrix.length, mid;
            int top = 0, bottom = rows - 1;
            //top 大于等于target的第一个行数
            while (top <= bottom) {
                mid = top + (bottom - top) / 2;
                if (matrix[mid][0] <= target) top = mid + 1;
                else bottom = mid - 1;
            }
            if (bottom < 0) return false;
            int left = 0, right = matrix[bottom].length - 1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (matrix[bottom][mid] <= target) left = mid + 1;
                else right = mid - 1;
            }
            if (right < 0) return false;
            return matrix[bottom][right] == target;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    static void main() {
        Solution solution = new $_0074_SearchA2dMatrix().new Solution();
        // put your test code here
        int[][] arr = Utils.toSquareArray("[[1]]");
        print(solution.searchMatrix(arr, 1)); // true
        arr = Utils.toSquareArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
        print(solution.searchMatrix(arr, 3)); // true
    }
}