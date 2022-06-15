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
    public int getDecimalValue(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        int num = 0;
        size--;
        // System.out.println("Size is:"+size);
        cur = head;
        while(cur != null){
            if(cur.val == 1){
                num += getNum(size);
            }
            cur = cur.next;
            size--;
        }
        
        return num;
    }
    
    private int getNum(int i){
        if(i==0)
            return 1;
        return 2 * getNum(i-1);
    }
}