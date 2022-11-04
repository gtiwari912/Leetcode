class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = n-2; i>=0; i--){
            int curElement = nums[i];
            for(int j = i+1; j<n; j++){
                int nextElement = nums[j];
                if(nextElement>curElement){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                // dp[i] = Math.max(dp[i], dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        int ans = 1;
        for(int i: dp) ans = Math.max(i, ans);
        return ans;
    }
}