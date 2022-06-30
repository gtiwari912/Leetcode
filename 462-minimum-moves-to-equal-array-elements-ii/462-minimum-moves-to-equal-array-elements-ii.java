class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n%2==1){
            int med = n/2;
            int median = nums[med];
            int dif = 0;
            for(int a: nums){
                dif += Math.abs(median - a);
            }
            return dif;
        }
        else{
            int med = n/2;
            int median = (nums[med]+nums[med-1])/2;
            int median2 = median + 1;
            int dif1 = 0;
            for(int a: nums)
                dif1 += Math.abs(median - a);
            int dif2 = 0;
            for(int a: nums)
                dif2 += Math.abs(median2 - a);
            return Math.min(dif1, dif2);
        }
    }
}