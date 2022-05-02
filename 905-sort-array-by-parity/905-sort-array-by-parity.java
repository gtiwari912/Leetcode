class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<high){
            if(nums[low]%2==1){
                swap(nums, low, high);
                high--;
            }
            else{
                low++;
            }
        }
        
        return nums;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 3 1 2 4
// 4 1 2 3
// 4 