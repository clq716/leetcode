/**
<p>给你一个整数&nbsp;<code>eventTime</code>&nbsp;表示一个活动的总时长，这个活动开始于&nbsp;<code>t = 0</code>&nbsp;，结束于&nbsp;<code>t = eventTime</code>&nbsp;。</p>

<p>同时给你两个长度为 <code>n</code>&nbsp;的整数数组&nbsp;<code>startTime</code> 和&nbsp;<code>endTime</code>&nbsp;。它们表示这次活动中 <code>n</code>&nbsp;个时间&nbsp;<strong>没有重叠</strong>&nbsp;的会议，其中第&nbsp;<code>i</code>&nbsp;个会议的时间为&nbsp;<code>[startTime[i], endTime[i]]</code>&nbsp;。</p>

<p>你可以重新安排 <strong>至多</strong>&nbsp;<code>k</code>&nbsp;个会议，安排的规则是将会议时间平移，且保持原来的 <strong>会议时长</strong>&nbsp;，你的目的是移动会议后 <strong>最大化</strong>&nbsp;相邻两个会议之间的 <strong>最长</strong> 连续空余时间。</p>

<p>移动前后所有会议之间的 <strong>相对</strong>&nbsp;顺序需要保持不变，而且会议时间也需要保持互不重叠。</p>

<p>请你返回重新安排会议以后，可以得到的 <strong>最大</strong>&nbsp;空余时间。</p>

<p><b>注意</b>，会议 <strong>不能</strong>&nbsp;安排到整个活动的时间以外。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>2</span></p>

<p><strong>解释：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/12/21/example0_rescheduled.png" style="width: 375px; height: 123px;" /></p>

<p>将&nbsp;<code>[1, 2]</code>&nbsp;的会议安排到&nbsp;<code>[2, 3]</code>&nbsp;，得到空余时间&nbsp;<code>[0, 2]</code>&nbsp;。</p>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>6</span></p>

<p><strong>解释：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/12/21/example1_rescheduled.png" style="width: 375px; height: 125px;" /></p>

<p>将&nbsp;<code>[2, 4]</code>&nbsp;的会议安排到&nbsp;<code>[1, 3]</code>&nbsp;，得到空余时间&nbsp;<code>[3, 9]</code>&nbsp;。</p>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>0</span></p>

<p><strong>解释：</strong></p>

<p>活动中的所有时间都被会议安排满了。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= eventTime &lt;= 10<sup>9</sup></code></li> 
 <li><code>n == startTime.length == endTime.length</code></li> 
 <li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= k &lt;= n</code></li> 
 <li><code>0 &lt;= startTime[i] &lt; endTime[i] &lt;= eventTime</code></li> 
 <li><code>endTime[i] &lt;= startTime[i + 1]</code> 其中&nbsp;<code>i</code>&nbsp;在范围&nbsp;<code>[0, n - 2]</code>&nbsp;之间。</li> 
</ul>

<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>滑动窗口</li></div></div><br><div><li>👍 49</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;
public class _3439_RescheduleMeetingsForMaximumFreeTimeI{
    public static void main(String[] args) {
        Solution solution = new _3439_RescheduleMeetingsForMaximumFreeTimeI().new Solution();
        System.out.printf(""+solution.maxFreeTime(62,1,new int[]{0,2,3,8,26}, new int[]{2,3,6,17,31}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] free = new int[n + 1];
        free[0] = startTime[0]; // 最左边的空余时间段
        for (int i = 1; i < n; i++) {
            free[i] = startTime[i] - endTime[i - 1]; // 中间的空余时间段
        }
        free[n] = eventTime - endTime[n - 1]; // 最右边的空余时间段

        // 套定长滑窗模板（窗口长为 k+1）
        int ans = 0;
        int s = 0;
        for (int i = 0; i <= n; i++) {
            s += free[i];
            if (i < k) {
                continue;
            }
            ans = Math.max(ans, s);
            s -= free[i - k];
        }
        return ans;

//        int n = startTime.length;
//        int ans = 0, cnt = 0;
//        for (int l = 0, r = 0; r <= n; r++) {
//            if (r == 0) {
//                if (startTime[0] > 0) {
//                    cnt += startTime[0];
//                    k--;
//                }
//            } else {
//                cnt += ((r == n ? eventTime : startTime[r]) - endTime[r-1]);
//                if (k > 0) {
//                    k--;
//                } else {
//                    if (l == 0) {
//                        if (startTime[0] > 0) cnt -= startTime[0];
//                    } else {
//                        cnt -= (startTime[l] - endTime[l-1]);
//                    }
//                    ans = Math.max(ans, cnt);
//                    l++;
//                }
//            }
//        }
//        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}