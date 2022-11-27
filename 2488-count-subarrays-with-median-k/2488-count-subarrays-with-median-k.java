class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int idx = -1;
        for(int i = 0; i<n; i++){
            if(nums[i]>k) nums[i] = 1;
            else if(nums[i]<k) nums[i] = -1;
            else{
                nums[i] = 0;
                idx = i;
            }
        }
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = idx; i>=0; i--){
            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        sum = 0;
        for(int i = idx; i<n; i++){
            sum += nums[i];
            int req1 = 0-sum;
            int req2 = req1+1;
            ans += (map.getOrDefault(req1, 0) + map.getOrDefault(req2, 0));
        }
        
        
        return ans;
    }
}