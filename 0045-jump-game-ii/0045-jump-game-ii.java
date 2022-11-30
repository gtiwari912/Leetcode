class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i<n; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(dp[j]!=Integer.MAX_VALUE && j+nums[j]>=i)
                    dp[i] = Math.min(dp[i], dp[j]+1);
            }
        }
        
        return dp[n-1];
        
    }
}