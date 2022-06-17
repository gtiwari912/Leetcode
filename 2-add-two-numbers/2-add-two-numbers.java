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
        int carry = 0;
        ListNode ans = new ListNode();
        ListNode finalAns = ans;
        while(l1 != null && l2!= null){
            ans.next = new ListNode();
            ans = ans.next;
            int sum = l1.val + l2.val + carry;
            int val = sum%10;
            ans.val = val;
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            // ans.next = new ListNode();
            // ans = ans.next;
            
        }
        // ans.next = new ListNode();
        // ans = ans.next;
        carry = fillRemaining(l1, ans, carry);
        carry = fillRemaining(l2, ans, carry);
        while(ans.next != null){
            ans = ans.next;
        }
        
        if(carry>0){
            ans.next = new ListNode();
            ans = ans.next;
            ans.val = carry;
        }
        return finalAns.next;
    }
    
    private int fillRemaining(ListNode l1, ListNode ans, int carry){
        while(l1 != null){
            ans.next = new ListNode();
            ans = ans.next;
            int sum = l1.val + carry;
            carry = sum/10;
            int val = sum % 10;
            ans.val = val;
            // ans.next = new ListNode();
            // ans = ans.next;
            l1 = l1.next;
        }
        return carry;
    }
//   c:  1 1 1
//     9,9,9,9,9,9,9
//     9,9,9,9
// ---------------------
//     8 9 9
    
//Exp  8,9,9,9,0,0,0,1
    
}