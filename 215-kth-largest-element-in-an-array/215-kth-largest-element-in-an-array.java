class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums)
            pq.add(i);
        while(k-->0){
            if(k==0)
                return pq.poll();
            pq.poll();
        }
        
        
        return -1;
    }
}