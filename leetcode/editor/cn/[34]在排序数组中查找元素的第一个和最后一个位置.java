//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 957 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

//    public int[] searchRange(int[] nums, int target) {
//        if (nums.length == 0) {
//            return new int[]{-1, -1};
//        }
//
//        int[] result =  binarySearch(nums, target, 0, nums.length - 1);
//        System.out.println(result);
//        return result;
//    }
//
//    public int[]binarySearch(int[] arr, int target, int left, int right) {
//        if (left > right) {
//            return new int[]{-1, -1};
//        }
//
//        int mid = (left + right) / 2;
//
//        if (arr[mid] == target) {
//            int tmp = mid - 1;
//            int minIndex = mid;
//            int maxIndex = mid;
//            while (tmp >= 0 && arr[tmp] == target) {
//                minIndex = tmp;
//                tmp--;
//            }
//
//            tmp = mid + 1;
//            while (tmp < arr.length && arr[tmp] == target) {
//                maxIndex = tmp;
//                tmp++;
//            }
//            return new int[]{minIndex, maxIndex};
//        } else {
//            if (arr[mid] > target) {
//                return binarySearch(arr, target, left, mid - 1);
//            } else {
//                return binarySearch(arr, target, mid + 1, right);
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
