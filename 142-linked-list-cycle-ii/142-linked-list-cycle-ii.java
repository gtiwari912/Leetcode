/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meetingPoint = null;
        while(fast!= null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                meetingPoint = slow;
                break;
            }
        }
        
        if(meetingPoint == null)
            return meetingPoint;
        
        ListNode cur = head;
        while(cur!=meetingPoint){
            cur = cur.next;
            meetingPoint = meetingPoint.next;
        }
        
        return cur;
    }
    
}