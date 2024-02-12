class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for(int i = 1; i<nums.length; i++){
            if(count == 0){
                count = 1;
                major = nums[i];
            }
            else if(nums[i] == major) count++;
            else count--;
        }
        return major;
    }
}