package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 51: N 皇后
 * RedmiBook, Fedora
 * 2026-08-14 13:43:24
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0051_NQueens {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 我的思路偏模拟，没有像灵神转化成另一个问题
     * 每一行只会有1个皇后，
     * 去遍历每一行合法的皇后位置，找到的话，记录，递归进入下一行，没找到继续找
     * 判断是否合法，只需要向上面三个方向遍历，看是否存在皇后
     */
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            char[][] board = new char[n][n];
            for (char[] row : board) Arrays.fill(row, '.');
            dfs(ans, 0, board);
            return ans;
        }
        private void dfs(List<List<String>> ans, int row, char[][] board) {
            if (row == board.length) {
                //更新答案
                List<String> list = new ArrayList<>(board.length);
                for (char[] chars : board) list.add(new String(chars));
                ans.add(list);
                return;
            }
            //遍历一行的每个位置
            for (int j = 0; j < board.length; j++) {
                if (rightQueen(board, row, j)) {
                    //合法女王
                    board[row][j] = 'Q';
                    //查找下一行
                    dfs(ans, row+1, board);
                    //恢复
                    board[row][j] = '.';
                }
            }
        }
        //向上的三个方向
        int[][] UPS = new int[][]{{-1,-1},{-1,0},{-1,1}};
        //查找上方的路径是否有女王
        private boolean rightQueen(char[][] board, int i, int j) {
            for (int[] up : UPS) {
                int x = i + up[0];
                int y = j + up[1];
                while (x >= 0 && x < board.length && y >= 0 && y < board.length) {
                    if (board[x][y] == 'Q') return false;
                    x += up[0];
                    y += up[1];
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神用的全排列的思路
    class Solution1 {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            int[] queens = new int[n]; // 皇后放在 (r,queens[r])
            boolean[] col = new boolean[n];
            boolean[] diag1 = new boolean[n * 2 - 1];
            boolean[] diag2 = new boolean[n * 2 - 1];
            dfs(0, queens, col, diag1, diag2, ans);
            return ans;
        }

        private void dfs(int r, int[] queens, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> ans) {
            int n = col.length;
            if (r == n) {
                List<String> board = new ArrayList<>(n); // 预分配空间
                for (int c : queens) {
                    char[] row = new char[n];
                    Arrays.fill(row, '.');
                    row[c] = 'Q';
                    board.add(new String(row));
                }
                ans.add(board);
                return;
            }
            // 在 (r,c) 放皇后
            for (int c = 0; c < n; c++) {
                int rc = r - c + n - 1;
                if (!col[c] && !diag1[r + c] && !diag2[rc]) { // 判断能否放皇后
                    queens[r] = c; // 直接覆盖，无需恢复现场
                    col[c] = diag1[r + c] = diag2[rc] = true; // 皇后占用了 c 列和两条斜线
                    dfs(r + 1, queens, col, diag1, diag2, ans);
                    col[c] = diag1[r + c] = diag2[rc] = false; // 恢复现场
                }
            }
        }
    }

    
    static void main() {
        Solution solution = new $_0051_NQueens().new Solution();
        // put your test code here
        print(solution.solveNQueens(4));
    }
}