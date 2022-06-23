class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for(int i: nums){
            if(i==0){
                cur=0;
            }
            else{
                cur++;
                max = Math.max(max, cur);
            }
        }
        
        
        return max;
    }
}