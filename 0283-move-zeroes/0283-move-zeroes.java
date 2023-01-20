class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0) continue;
            else{
                nums[index] = nums[i];
                index++;
            }
        }
        
        for(int j = index; j<nums.length; j++){
            nums[j] = 0;
        }
        
    }
}