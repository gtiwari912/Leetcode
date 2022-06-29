class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int left = 0;
        int right = n-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[mid+1]){
                right= mid;
            }
            else{
                left = mid+1;
            }
        }
        
        
        return left;
    }
}

// 1,2,3,1
//     l r
//     m