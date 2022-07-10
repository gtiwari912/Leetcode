class Solution {
    HashMap<Integer, Integer> dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new HashMap<>();
        // Arrays.fill(dp, -1);
        int startFrom0 = solve(cost, 0, 0);
        int startFrom1 = solve(cost, 0, 1);
        return Math.min(startFrom0, startFrom1);
    }
    
    private int solve(int[] cost, int curVal, int curPos){
        
        if(curPos>=cost.length)
            return curVal;
        if(dp.containsKey(curPos))
            return curVal+dp.get(curPos);
        int cur = cost[curPos];
        int ans = Math.min(  solve(cost, curVal+cur, curPos+1) ,
                          solve(cost, curVal+cur, curPos+2 )
                       );
        dp.put(curPos, ans - curVal);
        return ans;
        
    }
}