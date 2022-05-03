class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums){
            maxHeap.add(num);
            minHeap.add(num);
        }
        
        int low = 0;
        int high = n-1;
        
        while(low<n){
            int curElement = nums[low];
            int curPopped = minHeap.remove();
            if(curElement != curPopped){
                break;
            }
            low++;
        }
        
        while(high>-1){
            int curElement = nums[high];
            int curPopped = maxHeap.remove();
            if(curElement != curPopped){
                break;
            }
            high--;
        }
        
        return Math.max(0, high-low+1);
        
    }
}

// 2,6,4,8,10,9,15
// 0 1 2 3 4  5  6