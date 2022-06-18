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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<ListNode> stack = new Stack<>();
        ListNode one = new ListNode();
        int iter = 1;
        ListNode cur = head;
        stack.add(cur);
        while(iter<right){
            if(iter==left){
                one = cur;
            }
            cur = cur.next;
            stack.add(cur);
            iter++;
        }
        System.out.println("Val of Cur:"+cur.val);
        int target = (right-left+1)/2;
        int status = 0;
        while(true){
            ListNode now = stack.pop();
            if(now==one || status>=target)
                break;
            int temp = now.val;
            now.val = one.val;
            one.val = temp;
            one = one.next;
            status++;
            System.out.println(head.val+"->"+head.next.val);
        }
        
        return head;
    }
}