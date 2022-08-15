class Solution {
    // BottomUp tabulation
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     if(n==1)
    //         return nums[0];
    //     int[] dp = new int[n];
    //     dp[0] = nums[0];
    //     dp[1] = Math.max(nums[0], nums[1]);
    //     for(int i = 2; i<n; i++){
    //         dp[i]  = Math.max(
    //             dp[i-2]+nums[i],
    //             dp[i-1]
    //         );
    //     }
    //     return dp[n-1];
    // }
    
    // TopDown 
    public int rob(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return rob(nums, dp, n-1);
    }
    
    private int rob(int[] nums, int[] dp, int i){
        if(dp[i] != -1)
            return dp[i];
        if(i==0) return nums[0];
        if(i==1) return Math.max(nums[0], nums[1]);
        return dp[i]  = Math.max(
            rob(nums, dp, i-2) + nums[i], 
            rob(nums, dp, i-1)
        );
    }
}
