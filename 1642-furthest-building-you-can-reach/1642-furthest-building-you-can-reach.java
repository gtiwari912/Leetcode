class Solution {
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<arr.length - 1; i++){
            int dif = arr[i+1] - arr[i];
            if(dif<=0)
                continue;
            if(dif<=bricks){
                pq.add(dif);
                bricks -= dif;
            }
            else{
                if(ladders>0){
                    if(!pq.isEmpty() && pq.peek()>dif){
                        int add = pq.poll();
                        bricks+=add;
                        bricks -= dif;
                        pq.add(dif);
                    }
                    ladders--;
                }
                else{
                    return i;
                }
            }
        }
        
        return arr.length - 1;
    }
}