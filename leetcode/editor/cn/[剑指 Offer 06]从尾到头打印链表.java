//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 128 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode tmp = head;
        int k = 0;

        while (tmp != null) {
            k++;
            tmp = tmp.next;
        }

        int[] arr = new int[k];
        tmp = head;

        while (tmp != null) {
            arr[k-1] = tmp.val;
            k--;
            tmp = tmp.next;
        }

        return arr;
    }

//    public int[] reversePrint(ListNode head) {
//        Stack<ListNode> stack = new Stack<ListNode>();
//        ListNode tmp = head;
//
//        while (tmp != null) {
//            stack.push(tmp);
//            tmp = tmp.next;
//        }
//
//        int size = stack.size();
//        int[] arr = new int[size];
//
//        for (int i = 0; i < size; i++) {
//            arr[i] = stack.pop().val;
//        }
//
//        return arr;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
