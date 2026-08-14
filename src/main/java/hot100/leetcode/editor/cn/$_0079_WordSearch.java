package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 79: 单词搜索
 * RedmiBook, Fedora
 * 2026-08-13 19:04:43
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0079_WordSearch {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //上下左右
        //int[][] DIR = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        public boolean exist(char[][] board, String word) {
            int rows = board.length, cols = board[0].length;
            char[] words = word.toCharArray();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (dfs(words, board, rows, cols, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[] words, char[][] board, int rows, int cols, int i, int row, int col) {
            boolean ans = false;
            if (board[row][col] == words[i]) {
                if (i == words.length-1) return true;
                //选
                char original = board[row][col];
                board[row][col] = 0;
                //找下一个, i+1
                if (row > 0) ans = dfs(words, board, rows, cols, i+1, row-1, col);//上
                if (row < rows - 1) ans = ans || dfs(words, board, rows, cols, i+1, row+1, col);//下
                if (col > 0) ans = ans || dfs(words, board, rows, cols, i+1, row, col-1);//左
                if (col < cols - 1) ans = ans || dfs(words, board, rows, cols, i+1, row, col + 1);//右
                board[row][col] = original;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神相同思路的写法1
    class Solution1 {
        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        public boolean exist(char[][] board, String word) {
            char[] w = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (dfs(i, j, 0, board, w)) {
                        return true; // 搜到了！
                    }
                }
            }
            return false; // 没搜到
        }

        private boolean dfs(int i, int j, int k, char[][] board, char[] word) {
            if (board[i][j] != word[k]) { // 匹配失败
                return false;
            }
            if (k == word.length - 1) { // 匹配成功！
                return true;
            }
            board[i][j] = 0; // 标记访问过
            for (int[] d : DIRS) {
                int x = i + d[0];
                int y = j + d[1]; // 相邻格子
                if (0 <= x && x < board.length && 0 <= y && y < board[x].length && dfs(x, y, k + 1, board, word)) {
                    return true; // 搜到了！
                }
            }
            board[i][j] = word[k]; // 恢复现场
            return false; // 没搜到
        }
    }

    //灵神针对本题的两个优化
    class Solution2 {
        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        public boolean exist(char[][] board, String word) {
            // 为了方便，直接用数组代替哈希表
            int[] cnt = new int[128];
            for (char[] row : board) {
                for (char c : row) {
                    cnt[c]++;
                }
            }

            // 优化一
            char[] w = word.toCharArray();
            int[] wordCnt = new int[128];
            for (char c : w) {
                if (++wordCnt[c] > cnt[c]) {
                    return false;
                }
            }

            // 优化二
            if (cnt[w[w.length - 1]] < cnt[w[0]]) {
                w = new StringBuilder(word).reverse().toString().toCharArray();
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (dfs(i, j, 0, board, w)) {
                        return true; // 搜到了！
                    }
                }
            }
            return false; // 没搜到
        }

        private boolean dfs(int i, int j, int k, char[][] board, char[] word) {
            if (board[i][j] != word[k]) { // 匹配失败
                return false;
            }
            if (k == word.length - 1) { // 匹配成功！
                return true;
            }
            board[i][j] = 0; // 标记访问过
            for (int[] d : DIRS) {
                int x = i + d[0];
                int y = j + d[1]; // 相邻格子
                if (0 <= x && x < board.length && 0 <= y && y < board[x].length && dfs(x, y, k + 1, board, word)) {
                    return true; // 搜到了！
                }
            }
            board[i][j] = word[k]; // 恢复现场
            return false; // 没搜到
        }
    }
    
    static void main() {
        Solution solution = new $_0079_WordSearch().new Solution();
        // put your test code here
        char[][] board = Utils.toSquareCharArray("[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]");
        print(solution.exist(board, "ABCCED"));
        print(solution.exist(board, "SEE"));
        print(solution.exist(board, "ABCB"));
        board = Utils.toSquareCharArray("[[\"a\"]]");
        print(solution.exist(board, "a"));
    }
}