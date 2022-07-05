class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }
        int ans = binSearch(prefixSum, 0, n-1, target);
        for(int i = 0;i<n; i++){
            int cur = prefixSum[i];
            ans = Math.min(ans, binSearch(prefixSum, i+1, n-1, cur + target));
        }
        
        return ans==Integer.MAX_VALUE? 0: ans;
           
        
    }
    
    private int binSearch(int[] nums, int low, int high, int target){
        if(low==high){
            if(nums[low] == target)
                return 1;
            return Integer.MAX_VALUE;
        }
        if(low>high){
            return Integer.MAX_VALUE;
        }
        // System.out.println("Searching:"+target+" l:"+low+" h:"+high);
        int start = low;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                low = mid;
                break;
            }
            if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        if(low>=nums.length)
            return Integer.MAX_VALUE;
        // System.out.println("Got at :"+low);
        
        return low -start + 1;
    }
}