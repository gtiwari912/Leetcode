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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)
            return head;
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            size++;
        }
        if(size<k)
            return head;
        
        
        //creating dummy;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        
        
        ListNode prev = dummy;
        cur = head;
        dummy.next = null;
        ListNode next = cur.next;
        int i = 0;
        while(i<k && cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        
        if(next != null){
            ListNode further = reverseKGroup(next, k);
            add(prev, further);
        }
        else{
            add(prev, null);
        }
        
        return prev;
        
    }
    
    private ListNode add(ListNode headA, ListNode headB){
        ListNode ans = headA;
        while(headA.next.val != -1){
            headA = headA.next;
        }
        headA.next = headB;
        while(headA.next != null && headA.next.val != -1){
            headA = headA.next;
        }
        headA.next = null;
        return ans;
    }
}