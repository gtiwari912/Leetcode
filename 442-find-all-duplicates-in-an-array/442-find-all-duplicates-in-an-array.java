class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            int cur = Math.abs(nums[i]);
            if(nums[cur-1]>0){
                nums[cur-1] = 0 - nums[cur-1];
            }
            else{
                ans.add(cur);
            }
        }
        
        
        return ans;
    }
}