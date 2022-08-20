class Solution {
    int[] dp;
    int[] dp2;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        dp = new int[n];
        dp2 = new int[n];
        Arrays.fill(dp, -1);
        Arrays.fill(dp2, -1);
        int one = rob(nums, n-1, true);
        int two = rob(nums, n-2, false);
        // System.out.println("One: "+one+" Two: "+two);
        return Math.max(one,two);
    }
    
    private int rob(int[] nums, int i, boolean robbedLast){
        int n = nums.length;
        if(i<0) return 0;
        if(i==0)
            return robbedLast? 0: nums[0];
        if(robbedLast && dp[i] != -1) return dp[i];
        if(!robbedLast && dp2[i] != -1) return dp2[i];
        int ans = Math.max(
            rob(nums, i-1, robbedLast),
            nums[i] + rob(nums, i-2, robbedLast)
        );
        if(robbedLast) dp[i] = ans;
        else dp2[i] = ans;
        return ans;
    }
}