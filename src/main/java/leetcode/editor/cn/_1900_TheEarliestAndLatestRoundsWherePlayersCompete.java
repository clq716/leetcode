//n 名运动员参与一场锦标赛，所有运动员站成一排，并根据 最开始的 站位从 1 到 n 编号（运动员 1 是这一排中的第一个运动员，运动员 2 是第二个运动员
//，依此类推）。 
//
// 锦标赛由多个回合组成（从回合 1 开始）。每一回合中，这一排从前往后数的第 i 名运动员需要与从后往前数的第 i 名运动员比拼，获胜者将会进入下一回合。如
//果当前回合中运动员数目为奇数，那么中间那位运动员将轮空晋级下一回合。 
//
// 
// 例如，当前回合中，运动员 1, 2, 4, 6, 7 站成一排 
// 
//
// 
// 运动员 1 需要和运动员 7 比拼 
// 运动员 2 需要和运动员 6 比拼 
// 运动员 4 轮空晋级下一回合 
// 
// 
//
//
// 每回合结束后，获胜者将会基于最开始分配给他们的原始顺序（升序）重新排成一排。 
//
// 编号为 firstPlayer 和 secondPlayer 的运动员是本场锦标赛中的最佳运动员。在他们开始比拼之前，完全可以战胜任何其他运动员。而任意两
//个其他运动员进行比拼时，其中任意一个都有获胜的可能，因此你可以 裁定 谁是这一回合的获胜者。 
//
// 给你三个整数 n、firstPlayer 和 secondPlayer 。返回一个由两个值组成的整数数组，分别表示两位最佳运动员在本场锦标赛中比拼的 最早
// 回合数和 最晚 回合数。 
//
// 
//
// 示例 1： 
//
// 输入：n = 11, firstPlayer = 2, secondPlayer = 4
//输出：[3,4]
//解释：
//一种能够产生最早回合数的情景是：
//回合 1：1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
//回合 2：2, 3, 4, 5, 6, 11
//回合 3：2, 3, 4
//一种能够产生最晚回合数的情景是：
//回合 1：1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
//回合 2：1, 2, 3, 4, 5, 6
//回合 3：1, 2, 4
//回合 4：2, 4
// 
//
// 示例 2： 
//
// 输入：n = 5, firstPlayer = 1, secondPlayer = 5
//输出：[1,1]
//解释：两名最佳运动员 1 和 5 将会在回合 1 进行比拼。
//不存在使他们在其他回合进行比拼的可能。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 28 
// 1 <= firstPlayer < secondPlayer <= n 
// 
//
// 👍 43 👎 0


package leetcode.editor.cn;
public class _1900_TheEarliestAndLatestRoundsWherePlayersCompete{
    public static void main(String[] args) {
       Solution solution = new _1900_TheEarliestAndLatestRoundsWherePlayersCompete().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            public int[] earliestAndLatest(int n, int first, int second) {
                if (first + second == n + 1) {
                    return new int[]{1, 1};
                }

                if (first + second > n + 1) {
                    int tmp = first;
                    first = n + 1 - second;
                    second = n + 1 - tmp;
                }

                int earliest = calcEarliestRounds(n, first, second);
                int latest = Math.min(32 - Integer.numberOfLeadingZeros(n - 1), n + 1 - second);
                return new int[]{earliest, latest};
            }

            private int calcEarliestRounds(int n, int first, int second) {
                int res = 1;

                if (first + second <= (n + 1) / 2) {
                    // 计算满足 first+second > ceil(n / 2^(k+1)) 的最小 k，推导过程见题解
                    int k = 32 - Integer.numberOfLeadingZeros((n - 1) / (first + second - 1)) - 1;
                    n = ((n - 1) >> k) + 1; // n = ceil(n / 2^k)
                    res += k;

                    if (second - first > 1) {
                        return res + 1;
                    }
                }

                // 情况 1 和情况 3 合并，情况 2 合并到最后的 return
                if (second - first == 1 || second > (n + 1) / 2 && second - first == 2) {
                    // 先把 n 变成 ceil(n/2)，然后计算需要多少次 ceil(n/2) 的操作才能把 n 变成偶数，推导过程见题解
                    // 这里把 (n+1)/2 和 n-1 合并，得到 (n+1)/2-1 = (n-1)/2
                    return res + 1 + Integer.numberOfTrailingZeros((n - 1) / 2);
                }

                if (second > (n + 1) / 2 && first % 2 == 0 && first + second == n) {
                    res++;
                }

                return res + 1;
            }

}
//leetcode submit region end(Prohibit modification and deletion)

}