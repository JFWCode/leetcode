//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 216 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int[] arr = new int[matrix.length * matrix[0].length];

        int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;

        int arrIndex = 0;
        while (left < right && top < bottom) {
            for (int col = left; col < right; col++) {
                arr[arrIndex++] = matrix[top][col];
            }
            top++;

            for (int row = top; row < bottom; row++) {
                arr[arrIndex++] = matrix[row][right-1];
            }
            right--;

            if (top < bottom && left < right) {
                for (int col = right - 1; col >= left; col--) {
                    arr[arrIndex++] = matrix[bottom-1][col];
                }
                bottom--;

                for (int row = bottom - 1; row >= top; row--) {
                    arr[arrIndex++] = matrix[row][left];
                }
                left++;
            }
        }

        return arr;
    }

    public static int[] spiralMatrixMethod1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int[] arr = new int[matrix.length * matrix[0].length];

        int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;

        int arrIndex = 0;
        while (left < right && top < bottom) {
            for (int col = left; col < right; col++) {
                arr[arrIndex++] = matrix[top][col];
            }
            top++;
            if (top == bottom) {
                break;
            }
            for (int row = top; row < bottom; row++) {
                arr[arrIndex++] = matrix[row][right-1];
            }
            right--;
            if (left == right) {
                break;
            }
            for (int col = right - 1; col >= left; col--) {
                arr[arrIndex++] = matrix[bottom-1][col];
            }
            bottom--;
            for (int row = bottom - 1; row >= top; row--) {
                arr[arrIndex++] = matrix[row][left];
            }
            left++;
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
