package hot100.leetcode.editor.cn;

import java.util.*;
import utils.*;
import static utils.Printer.print;
/**
 * 215: 数组中的第K个最大元素
 * RedmiBook, Fedora
 * 2026-08-26 20:25:38
*/
@SuppressWarnings({"PrimitiveArrayArgumentToVarargsMethod", "RedundantSuppression"})
public class $_0215_KthLargestElementInAnArray {
//需要手写排序，没想出来，抄一遍答案
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //大根堆排序
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length, saveN = n;
            //建立大根堆
            buildMaxHeap(nums, n);
            //移除堆顶前k个元素
            for (int i = saveN-1; i >= saveN - k + 1; i--) {
                //把堆顶移除--放到数组后面并且堆的规模-1
                swap(nums, 0, --n);
                //从堆顶重新构建子树
                maxHeapify(nums, 0, n);
            }
            return nums[0];
        }

        private void buildMaxHeap(int[] nums, int n) {
            //从堆底部向堆顶构建最大堆
            for (int i = (n >> 1)-1; i >= 0; i--) maxHeapify(nums, i, n);
        }

        private void maxHeapify(int[] nums, int i, int n) {
            int l = (i << 1) + 1, r = (i << 1) + 2, largest = i;
            if (l < n && nums[l] > nums[largest]) largest = l;
            if (r < n && nums[r] > nums[largest]) largest = r;
            //堆顶大于两个子树的时候结束构建
            if (largest != i) {
                swap(nums, i, largest);
                //交换堆顶后，重新构建被交换的左子树或右子树
                maxHeapify(nums, largest, n);
            }
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    //灵神的快速排序解法
    class Solution1 {
        private static final Random rand = new Random();

        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            int targetIndex = n - k; // 第 k 大元素在升序数组中的下标是 n - k
            int left = 0;
            int right = n - 1; // 闭区间
            while (true) {
                int i = partition(nums, left, right);
                if (i == targetIndex) {
                    // 找到第 k 大元素
                    return nums[i];
                }
                if (i > targetIndex) {
                    // 第 k 大元素在 [left, i - 1] 中
                    right = i - 1;
                } else {
                    // 第 k 大元素在 [i + 1, right] 中
                    left = i + 1;
                }
            }
        }

        // 在子数组 [left, right] 中随机选择一个基准元素 pivot
        // 根据 pivot 重新排列子数组 [left, right]
        // 重新排列后，<= pivot 的元素都在 pivot 的左侧，>= pivot 的元素都在 pivot 的右侧
        // 返回 pivot 在重新排列后的 nums 中的下标
        // 特别地，如果子数组的所有元素都等于 pivot，我们会返回子数组的中心下标，避免退化
        private int partition(int[] nums, int left, int right) {
            // 1. 在子数组 [left, right] 中随机选择一个基准元素 pivot
            int i = left + rand.nextInt(right - left + 1);
            int pivot = nums[i];
            // 把 pivot 与子数组第一个元素交换，避免 pivot 干扰后续划分，从而简化实现逻辑
            swap(nums, i, left);

            // 2. 相向双指针遍历子数组 [left + 1, right]
            // 循环不变量：在循环过程中，子数组的数据分布始终如下图
            // [ pivot | <=pivot | 尚未遍历 | >=pivot ]
            //   ^                 ^     ^         ^
            //   left              i     j         right

            i = left + 1;
            int j = right;
            while (true) {
                while (i <= j && nums[i] < pivot) {
                    i++;
                }
                // 此时 nums[i] >= pivot

                while (i <= j && nums[j] > pivot) {
                    j--;
                }
                // 此时 nums[j] <= pivot

                if (i >= j) {
                    break;
                }

                // 维持循环不变量
                swap(nums, i, j);
                i++;
                j--;
            }

            // 循环结束后
            // [ pivot | <=pivot | >=pivot ]
            //   ^             ^   ^     ^
            //   left          j   i     right

            // 3. 把 pivot 与 nums[j] 交换，完成划分（partition）
            // 为什么与 j 交换？
            // 如果与 i 交换，可能会出现 i = right + 1 的情况，已经下标越界了，无法交换
            // 另一个原因是如果 nums[i] > pivot，交换会导致一个大于 pivot 的数出现在子数组最左边，不是有效划分
            // 与 j 交换，即使 j = left，交换也不会出错
            swap(nums, left, j);

            // 交换后
            // [ <=pivot | pivot | >=pivot ]
            //               ^
            //               j

            // 返回 pivot 的下标
            return j;
        }

        // 交换 nums[i] 与 nums[j]
        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    static void main() {
        Solution solution = new $_0215_KthLargestElementInAnArray().new Solution();
        // put your test code here
        print(solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        print(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));

    }
}