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
    public ListNode partition(ListNode head, int x) {
        ListNode one = new ListNode(-1);
        ListNode cur = head;
        ListNode curOne = one;
        while(cur != null){
            if(cur.val <x){
                curOne.next = new ListNode(cur.val);
                curOne = curOne.next;
            }
            cur = cur.next;
        }

        ListNode two = new ListNode(-1);
        ListNode curTwo = two;
        cur = head;
        while(cur != null){
            if(cur.val >=x){
                curTwo.next = new ListNode(cur.val);
                curTwo = curTwo.next;
            }
            cur = cur.next;
        }
        // printNode(two);
        return join(one.next, two.next);
    }
    
    private ListNode join(ListNode one, ListNode two){
        if(one ==null)
            return two;
        ListNode ans = one;
        ListNode cur = one;
        while(cur.next != null) 
            cur = cur.next;
        cur.next = two;
        return one;
    }
    
    private void printNode(ListNode cur){
        while(cur != null){
            System.out.print(cur.val+"->");
            cur = cur.next;
        }
        System.out.println();
    }
}