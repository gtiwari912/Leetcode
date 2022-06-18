class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int firstSmallerIndex = -1;
        int firstSmallerElement = -1;
        for(int i = n-2; i>=0; i--){
            int curEle = nums[i];
            int forEle = nums[i+1];
            if(curEle<forEle){
                firstSmallerIndex = i;
                firstSmallerElement = nums[i];
                break;
            }
        }
        if(firstSmallerIndex==-1){
            reverse(nums, 0, n-1);
            return;
        }
        System.out.println("First Smaller index:"+firstSmallerIndex);
        
        int firstGreaterIndex = 0;
        int greaterEle = Integer.MAX_VALUE;
        for(int i = firstSmallerIndex+1; i<n; i++){
            int curEle = nums[i];
            if(curEle>firstSmallerElement && curEle<=greaterEle){
                greaterEle = curEle;
                firstGreaterIndex = i;
            }
        }
        System.out.println("First greater index: "+firstGreaterIndex);
        
        swap(nums, firstGreaterIndex, firstSmallerIndex);
        reverse(nums, firstSmallerIndex+1, n-1);
        
    }
    
    
    private void reverse(int[] nums, int start, int end){
        // int start = 0;
        // int end = nums.length-1;
        while(start<end){
            swap(nums, start, end);
            start++; end--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp  = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}