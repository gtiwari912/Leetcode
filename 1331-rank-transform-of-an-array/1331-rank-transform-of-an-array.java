class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: arr) pq.add(i);
        HashMap<Integer, Integer> map = new HashMap<>();
        int iter = 1;
        while(!pq.isEmpty()){
            int cur = pq.remove();
            if(!map.containsKey(cur)){
                map.put(cur, iter);
                iter++;
            }
        }
        int n = arr.length;
        int[] ranks = new int[n];
        for(int i = 0; i<n; i++) ranks[i] = map.get(arr[i]);
        return ranks;
    }
}