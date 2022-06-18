class Solution {
    public int maxProfit(int[] prices) {
        int prevLowest = prices[0];
        int ans = 0;
        for(int i = 1; i<prices.length; i++){
            int curEle = prices[i];
            ans = Math.max(ans, curEle - prevLowest);
            prevLowest = Math.min(prevLowest, curEle);
        }
        
        return ans;
    }
}