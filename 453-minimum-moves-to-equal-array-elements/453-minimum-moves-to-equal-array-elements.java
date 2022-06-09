class Solution {
    public int minMoves(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int cur: nums)
            min = Math.min(min, cur);
        int res = 0;
        for(int cur: nums)
            res += cur-min;
        
        
        return res;
    }
}