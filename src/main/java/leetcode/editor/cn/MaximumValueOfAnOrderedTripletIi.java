//给你一个下标从 0 开始的整数数组 nums 。 
//
// 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 
//。 
//
// 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [12,6,1,2,7]
//输出：77
//解释：下标三元组 (0, 2, 4) 的值是 (nums[0] - nums[2]) * nums[4] = 77 。
//可以证明不存在值大于 77 的有序下标三元组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,10,3,4,19]
//输出：133
//解释：下标三元组 (1, 2, 4) 的值是 (nums[1] - nums[2]) * nums[4] = 133 。
//可以证明不存在值大于 133 的有序下标三元组。 
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：0
//解释：唯一的下标三元组 (0, 1, 2) 的值是一个负数，(nums[0] - nums[1]) * nums[2] = -3 。因此，答案是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// 👍 57 👎 0


package leetcode.editor.cn;
public class MaximumValueOfAnOrderedTripletIi{
    public static void main(String[] args) {
       Solution solution = new MaximumValueOfAnOrderedTripletIi().new Solution();
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] maxRight = new int[n];
        int maxR = 0;
        for (int l = 0, r = n-1; l < n; l++, r--) {
            maxR = Math.max(nums[r], maxR);
            maxRight[r] = maxR;
        }
        int maxL = nums[0];
        for (int i = 1; i < n-1; i++) {
            maxL = Math.max(nums[i-1], maxL);
            ans = Math.max(ans, (long) (maxL - nums[i]) * maxRight[i+1]);
        }
        //灵神有更好的实现方式，时间复杂度 O(2N) -> O(N), 空间复杂度 O(1)
        //遍历 K ，记录 i-j 的最大值。并进行相乘取最大值
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}