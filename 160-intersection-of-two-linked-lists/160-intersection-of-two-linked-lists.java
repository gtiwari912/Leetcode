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
        ListNode llA = headA;
        ListNode llB = headB;
        int llAsize = 0;
        int llBsize = 0;
        while(llA != null){
            llA = llA.next;
            llAsize++;
        }
        while(llB != null){
            llB = llB.next;
            llBsize++;
        }
        int diff = Math.abs(llAsize - llBsize);
        if(llAsize>llBsize){
            llA = headA;
            llB = headB;
            while(diff-->0){
                llA = llA.next;
            }
        }
        else{
            llA = headA;
            llB = headB;
            while(diff-->0){
                llB = llB.next;
            }
        }
        
        while(llA != null){
            if(llA == llB)
                return llA;
            llA = llA.next;
            llB = llB.next;
        }
        return null;
    }
}