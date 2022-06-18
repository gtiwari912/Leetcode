/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node back = head;
        Node front = head.next;
        while(true){
            Node temp = new Node(back.val);
            back.next = temp;
            temp.next = front;
            if(front == null)
                break;
            front = front.next;
            back = back.next.next;
            
        }
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        back = head;
        while(back != null){
            if(back.random != null)
                back.next.random = back.random.next; 
            back = back.next.next;
        }
        System.out.println("Reached here");
        Node ans = head.next;
        
        back = head;
        front = head.next.next;
        while(front != null){
            Node mid = back.next;
            back.next = front;
            mid.next = front.next;
            front = front.next.next;
            back = back.next;
        }
        back.next = null;
        return ans;
    }
}