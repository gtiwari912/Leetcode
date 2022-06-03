class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;
        for(int cur: cardPoints)
            totalSum += cur;
        int winSize = n-k;
        int minWindow = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;
        int curSum = 0;
        while(high<winSize){
            curSum += cardPoints[high++];
        }
        high--;
        minWindow = Math.min(curSum, minWindow);
        while(high<n-1){
            high++;
            curSum += cardPoints[high];
            curSum -= cardPoints[low];
            low++;
            minWindow = Math.min(curSum, minWindow);
        }
        
        return totalSum - minWindow;
    }
}