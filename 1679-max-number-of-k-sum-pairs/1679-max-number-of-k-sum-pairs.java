class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int curSum = nums[low] + nums[high];
            if(curSum==k){
                count++;
                low++;
                high--;
            }
            else if(curSum<k){
                low++;
            }
            else{
                high--;
            }
        }
        
        return count;
    }
}