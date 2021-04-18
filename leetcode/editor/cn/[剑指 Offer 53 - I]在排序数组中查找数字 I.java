//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 117 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        List<Integer> arrayList = binarySearch(nums, target, 0, nums.length - 1);
        return arrayList.size();
    }

    public List<Integer> binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            List<Integer> list = new ArrayList<>();

            int tmp = mid - 1;
            while (tmp >= 0 && arr[tmp] == target) {
                list.add(tmp);
                tmp--;
            }

            list.add(mid);

            tmp = mid + 1;
            while (tmp < arr.length && arr[tmp] == target) {
                list.add(tmp);
                tmp++;
            }
            return list;
        } else {
            if (arr[mid] > target) {
                return binarySearch(arr, target, left, mid - 1);
            } else {
                return binarySearch(arr, target, mid + 1, right);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
