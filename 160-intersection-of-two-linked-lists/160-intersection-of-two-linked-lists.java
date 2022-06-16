/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            if(a==null){
                a=headB;
            }
            if(b==null)
                b=headA;
            if(a==b)
                return a;
            a = a.next;
            b = b.next;
        }
        
        return a;
    }
}