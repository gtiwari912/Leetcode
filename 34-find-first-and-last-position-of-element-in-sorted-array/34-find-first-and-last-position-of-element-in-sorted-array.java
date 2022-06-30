class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int n = nums.length;
        if(n==0){
            return ans;
        }
        if(n==1){
            if(nums[0] == target){
                ans[0] = 0; ans[1] = 0;
                return ans;
            }
            return ans;
        }
        int one = findFirst(nums, 0, n-1, target);
        int two = findLast(nums, 0, n-1, target);
        ans[0] = one;
        ans[1] = two;
        return ans;
    }
    
    private int findFirst(int[] nums, int left, int right, int target){
        if(left==right){
            if(nums[right] == target)
                return right;
            return -1;
        }
        int mid = (left+right)/2;
        if(nums[mid]>=target){
            return findFirst(nums, left, mid, target);
        }
        else{
            return findFirst(nums, mid+1, right, target);
        }
    }
    
    private int findLast(int[] nums, int left, int right, int target){
        if(left==right){
            if(nums[right] == target)
                return right;
            return -1;
        }
        int mid = (left+right)/2 + 1;
        if(nums[mid]<=target){
            return findLast(nums, mid, right, target);
        }
        else{
            return  findLast(nums, left, mid-1, target);
        }
    }
}