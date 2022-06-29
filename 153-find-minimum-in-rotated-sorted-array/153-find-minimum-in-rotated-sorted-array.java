class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]<nums[0]){
                right = mid;
            }
            else if(nums[mid]>nums[n-1]){
                left = mid+1;
            }
            else{
                return nums[left];
            }
        }
        
        return nums[left];
        
    }
}