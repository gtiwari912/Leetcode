class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int leastSeen = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int cur: prices){
            leastSeen = Math.min(leastSeen, cur);
            maxProfit = Math.max(maxProfit, cur-leastSeen);
        }
        
        
        return maxProfit;
    }
}