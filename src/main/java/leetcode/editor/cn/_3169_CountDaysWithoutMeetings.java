/**
<p>给你一个正整数 <code>days</code>，表示员工可工作的总天数（从第 1 天开始）。另给你一个二维数组 <code>meetings</code>，长度为 <code>n</code>，其中 <code>meetings[i] = [start_i, end_i]</code> 表示第 <code>i</code> 次会议的开始和结束天数（包含首尾）。</p>

<p>返回员工可工作且没有安排会议的天数。</p>

<p><strong>注意：</strong>会议时间可能会有重叠。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">days = 10, meetings = [[5,7],[1,3],[9,10]]</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<p>第 4 天和第 8 天没有安排会议。</p>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">days = 5, meetings = [[2,4],[1,3]]</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">1</span></p>

<p><strong>解释：</strong></p>

<p>第 5 天没有安排会议。</p>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">days = 6, meetings = [[1,6]]</span></p> 
</div>

<p><strong>输出：</strong>0</p>

<p><strong>解释：</strong></p>

<p>所有工作日都安排了会议。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= days &lt;= 10<sup>9</sup></code></li> 
 <li><code>1 &lt;= meetings.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>meetings[i].length == 2</code></li> 
 <li><code>1 &lt;= meetings[i][0] &lt;= meetings[i][1] &lt;= days</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>排序</li></div></div><br><div><li>👍 32</li><li>👎 0</li></div>
*/

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class _3169_CountDaysWithoutMeetings{
    public static void main(String[] args) {
        Solution solution = new _3169_CountDaysWithoutMeetings().new Solution();
        solution.countDays(5, new int[][]{{2,4},{1,3}});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDays(int days, int[][] meetings) {
//        int[] meetDays = new int[days + 1];
//        TreeMap<Integer, Integer> cnt = new TreeMap<>();
//        for (int[] meeting : meetings) {
////            meetDays[meeting[0]] = Math.max(meeting[1], meetDays[meeting[0]]);
//            cnt.put(meeting[0], Math.max(meeting[1], cnt.getOrDefault(meeting[0], 0)));
//        }
//        int ans = 0;
//        int nextMeetingEnd = 0;
//
//        while (true) {
//            Map.Entry<Integer, Integer> entry = cnt.higherEntry(nextMeetingEnd);
//            if (entry == null) break;
//            ans += (entry.getKey() - nextMeetingEnd - 1);
//            nextMeetingEnd = entry.getValue();
//        }
////
////        for (int i = 0; i < days + 1; i++) {
////            if (meetDays[i] == 0) {
////                if (i > nextMeetingEnd) ans++;
////            } else {
////                nextMeetingEnd = Math.max(meetDays[i], nextMeetingEnd);
////            }
////        }
//        return ans;
        Arrays.sort(meetings, Comparator.comparingInt(p -> p[0])); // 按照左端点从小到大排序
        int start = 1, end = 0; // 当前合并区间的左右端点
        for (int[] p : meetings) {
            if (p[0] > end) { // 不相交
                days -= end - start + 1; // 当前合并区间的长度
                start = p[0]; // 下一个合并区间的左端点
            }
            end = Math.max(end, p[1]);
        }
        days -= end - start + 1; // 最后一个合并区间的长度
        return days;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}