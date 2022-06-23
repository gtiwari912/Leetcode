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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        int size = 0;
        ListNode cur = head;
        ListNode prev  = null;
        while(cur != null){
            prev = cur;
            cur = cur.next;
            size++;
        }
        prev.next = head;
        
        cur = head;
        k = k % size;
        int iter = size - k;
        while(iter-->0){
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
        return cur;
        
    }
}