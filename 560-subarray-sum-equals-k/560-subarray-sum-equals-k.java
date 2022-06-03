class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        int count = 0;
        map.put(0, 1);
        for(int i = 0; i<n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
            int req = prefixSum[i+1] - k;
            count += map.getOrDefault(req, 0);
            map.put(prefixSum[i+1], map.getOrDefault(prefixSum[i+1], 0)+1);
        }
        
        return count;
        
    }
}