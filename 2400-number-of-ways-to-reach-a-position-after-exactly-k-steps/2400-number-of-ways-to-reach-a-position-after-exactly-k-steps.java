class Solution {
    int mod = 1000000000+7;
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[1001][1001];
        for(int[] arr: dp) for(int i = 0; i<arr.length; i++) arr[i] = -1;
        return recurse(Math.abs(endPos - startPos), k, dp);
    }
    private int recurse(int dist, int k, int[][] dp){
        dist = Math.abs(dist);
        if(k<0) return 0;
        if(dist>=k){
            return dist==k? 1: 0;
        }
        if(dp[dist][k] != -1) return dp[dist][k];
        return dp[dist][k] = (recurse(dist+1, k-1, dp) + recurse(dist-1, k-1, dp))%mod;
    }
}