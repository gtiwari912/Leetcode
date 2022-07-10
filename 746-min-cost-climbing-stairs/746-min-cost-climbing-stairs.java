class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int startFrom0 = solve(cost, 0, 0);
        int startFrom1 = solve(cost, 0, 1);
        return Math.min(startFrom0, startFrom1);
    }
    
    private int solve(int[] cost, int curVal, int curPos){
        
        if(curPos>=cost.length)
            return curVal;
        if(dp[curPos] != -1)
            return curVal+dp[curPos];
        int cur = cost[curPos];
        int ans = Math.min(  solve(cost, curVal+cur, curPos+1) ,
                          solve(cost, curVal+cur, curPos+2 )
                       );
        dp[curPos] = ans - curVal;
        return ans;
        
    }
}