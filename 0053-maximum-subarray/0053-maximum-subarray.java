class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i: nums){
            curSum += i;
            maxSum = Math.max(curSum, maxSum);
            if(curSum<0) curSum = 0;
        }
        return maxSum;
    }
}