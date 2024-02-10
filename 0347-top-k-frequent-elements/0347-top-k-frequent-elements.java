class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i,0)+1);
        int[][] arr = new int[map.size()][2];
        int idx = 0;
        System.out.println(map.size());
        for(int key: map.keySet()){
            arr[idx] = new int[2];
            arr[idx][0]= key;
            arr[idx][1] = map.get(key);
            idx++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int[] a: arr) pq.add(a);
        int[] ans = new int[k];
        idx = 0;
        while(k-->0){
            ans[idx++] = pq.remove()[0];
        }
        return ans;
    }
}