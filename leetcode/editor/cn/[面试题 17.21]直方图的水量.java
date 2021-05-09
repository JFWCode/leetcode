//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 238 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        return water1(height);
    }

    // best solution
    public static int water1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int left = 1;
        int right = arr.length - 2;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int water = 0;

        while (left <= right) {
            if (leftMax <= rightMax) {
                water += Math.max(leftMax - arr[left], 0);
                leftMax = Math.max(leftMax, arr[left]);
                left += 1;
            } else {
                water += Math.max(rightMax - arr[right], 0);
                rightMax = Math.max(rightMax, arr[right]);
                right -= 1;
            }
        }

        return water;
    }

    public static int water2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int water = 0;
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];

        leftMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        for (int i = 1; i < arr.length - 1; i++) {
            water += Math.max(0, Math.min(leftMax[i - 1], rightMax[i + 1]) - arr[i]);
        }

        return water;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
