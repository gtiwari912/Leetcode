class Solution {
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i= 0; i<arr.length-1; i++){
            int dif = arr[i+1] - arr[i];
            if(dif> 0)
                pq.add(dif);
            if(pq.size()>ladders){
                bricks -= pq.remove();
            }
            if(bricks<0)
                return i;
        }
        
        
        return arr.length - 1;
    }
}