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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = reverse(slow);
        ListNode left = head;
        // print(right);
        // print(left);
        while(right!=null){
            if(right.val != left.val)
                return false;
            right = right.next;
            left = left.next;
        }
        return true;
    }
    
    private void print(ListNode head){
        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println("");
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next==null)
            return head;
        ListNode prev = head;
        ListNode cur = head.next;
        prev.next = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}