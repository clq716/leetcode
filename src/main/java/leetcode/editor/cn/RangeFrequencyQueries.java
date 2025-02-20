//请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。 
//
// 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。 
//
// 请你实现 RangeFreqQuery 类： 
//
// 
// RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。 
// int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频
//率 。 
// 
//
// 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续
//元素。 
//
// 
//
// 示例 1： 
//
// 输入：
//["RangeFreqQuery", "query", "query"]
//[[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
//输出：
//[null, 1, 2]
//
//解释：
//RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 
//33, 22, 12, 34, 56]);
//rangeFreqQuery.query(1, 2, 4); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
//rangeFreqQuery.query(0, 11, 33); // 返回 2 。33 在整个子数组中出现 2 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁵ 
// 1 <= arr[i], value <= 10⁴ 
// 0 <= left <= right < arr.length 
// 调用 query 不超过 10⁵ 次。 
// 
//
// Related Topics 设计 线段树 数组 哈希表 二分查找 👍 103 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFrequencyQueries{
    public static void main(String[] args) {
        RangeFreqQuery solution = new RangeFrequencyQueries().new RangeFreqQuery(new int[]{1,1,1,2,2});
        int r1 = solution.query(0,1,2);
        int r2 = solution.query(0,11,33);
        System.out.println("r1:" + r1 + ";r2:"+r2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class RangeFreqQuery {

        private final Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> indexes = map.computeIfAbsent(arr[i], k -> new ArrayList<>());
            indexes.add(i);
        }
        this.map = map;
    }
    
    public int query(int left, int right, int value) {
        List<Integer> indexes = map.get(value);



        int left_pos = slowFind(indexes, left, true);
        int right_pos = slowFind(indexes, right, false);
        int size = indexes.size();
        for (int i = 0; i < size; i++) {
            int v = indexes.get(i);
            if (v == left) {
                left_pos = i;
                break;
            } else if (v > left) {
                left_pos = i - 1;
                break;
            } else {
                if (i==size-1) {
                    left_pos = size;
                    break;
                }
            }
        }
        for (int i = size-1; i > -1; i--) {
            int v = indexes.get(i);
            if (v == right) {
                right_pos = i;
                break;
            } else if (v < right) {
                right_pos = Math.min(size-1, i+1);
                break;
            } else {
                if (i==0) {
                    left_pos = -1;
                    break;
                }
            }
        }
        if (left_pos == -1 && right_pos == -1) return 0;
        return right_pos - left_pos + 1 ;
    }

        private int slowFind(List<Integer> list, int target, boolean left) {
        int idx = 0;
        if (!left) {
            for (int i = 0; i < list.size(); i++) {
                int v = list.get(i);
                if (v > target) {
                    return i-1;
                }
            }
        } else {
            for (int i = list.size() - 1; i > 0; i--) {
                int v = list.get(i);
                if (v < target) {
                    return i+1;
                }
            }
        }
        return idx;
        }

    //二分查找
        private int find(List<Integer> list, int target, boolean left) {
            int l = 0;
            int r = list.size() - 1;
            while (true) {
                if (r - l <= 1) {
                    return left ? l : r;
                }
                int middle = (l+r)/2;
                int pos_val = list.get(middle);
                if (pos_val > target) {
                    r = middle;
                } else if (pos_val < target) {
                    l = middle;
                } else {
                    return middle;
                }
            }
        }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}