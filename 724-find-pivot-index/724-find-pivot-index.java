class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int sum = 0;
        for(int i = 0; i<n; i++){
            leftSum[i] = sum; 
            sum += nums[i];
        }
        
        int[] rightSum = new int[n];
        sum = 0;
        for(int i= n-1; i>=0; i--){
            rightSum[i] = sum; 
            sum += nums[i];
        }
        
        for(int i= 0; i<n; i++){
            if(leftSum[i] == rightSum[i])
                return i;
        }
        
        return -1;
    }
}