//Given an unsorted integer array nums, find the smallest missing positive integ
//er. 
//
// 
// Example 1: 
// Input: nums = [1,2,0]
//Output: 3
// Example 2: 
// Input: nums = [3,4,-1,1]
//Output: 2
// Example 3: 
// Input: nums = [7,8,9,11,12]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 300 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
// Follow up: Could you implement an algorithm that runs in O(n) time and uses c
//onstant extra space? 
// Related Topics 数组 
// 👍 1027 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i]-1]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return  nums.length + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
