/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode  list = new ListNode(0);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            // int sum = stack1.pop() + stack2.pop() + list.val;
            int sum = list.val;
            if(!stack1.isEmpty())
                sum += stack1.pop();
            if(!stack2.isEmpty())
                sum += stack2.pop();
            int val = sum%10;
            int carry = sum/10;
            list.val = val;
            ListNode newHead = new ListNode(carry);
            newHead.next = list;
            list = newHead;
        }
        
        return list.val == 0? list.next: list;
    }
}