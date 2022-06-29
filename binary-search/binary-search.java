class Solution {
    //recursive approach;
    public int search(int[] nums, int target) {
        return binSearch(nums, 0, nums.length - 1, target);
    }
    
    private int binSearch(int[] nums, int left, int right, int target){
        if(left>right)
            return -1;
        int mid = (left+right)/2;
        if(nums[mid] == target)
            return mid;
        
        if(nums[mid]<target)
            return binSearch(nums, mid+1, right, target);
        if(nums[mid]>target)
            return binSearch(nums, left, mid-1, target);
        
        return -1;
    }
}