class Solution {
    public int[] productExceptSelf(int[] nums) {
        System.gc();
        int product = 1;
        int n = nums.length;
        int[] output = new int[n];
        for(int i = 0; i<n; i++){
            output[i] = product;
            product = product * nums[i];
        }
        product = 1;
        for(int i = n-1; i>=0; i--){
            output[i] = output[i] * product;
            product = product * nums[i];
        }
        System.gc();
        return output;
    }
    
}