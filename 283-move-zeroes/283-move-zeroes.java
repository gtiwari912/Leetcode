class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int now = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] != 0){
                nums[now++] = nums[i];
            }
        }
        
        for(int i = now; i<n; i++)
            nums[i] = 0;
    }
}