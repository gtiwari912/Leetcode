class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean isEven;
    int size = 0;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        isEven = true;
    }
    
    public void addNum(int num) {
        size++;
        if(!minHeap.isEmpty() && num<minHeap.peek()) maxHeap.add(num);
        else{
            minHeap.add(num);
        }
        if(maxHeap.size()>minHeap.size()){
            minHeap.add(maxHeap.remove());
        }
        else if(minHeap.size()-maxHeap.size() >=2){
            maxHeap.add(minHeap.remove());
        }
        // System.out.println(maxHeap+" "+minHeap+" S: "+size);
    }
    
    public double findMedian() {
        if(size%2==1){
            return (double) minHeap.peek();
        }
        else{
            return ((double)(minHeap.peek()+maxHeap.peek()))/2d;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */