class MyQueue {
    Stack<Integer> s1, s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.add(x);
    }
    
    public int pop() {
        while(s1.size()>1){
            s2.add(s1.pop());
        }
        int ans = s1.pop();
        while(!s2.isEmpty()) s1.add(s2.pop());
        return ans;
    }
    
    public int peek() {
        while(s1.size()>1){
            s2.add(s1.pop());
        }
        int ans = s1.pop();
        s1.add(ans);
        while(!s2.isEmpty()) s1.add(s2.pop());
        return ans;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */