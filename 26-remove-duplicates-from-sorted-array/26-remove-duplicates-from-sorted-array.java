class Solution {
    public int removeDuplicates(int[] nums) {
        int previous = -101;
        int now = 0;
        int n = nums.length;
        int val = 0;
        for(int i = 0; i<n; i++){
            int cur = nums[i];
            if(cur != previous){
                nums[now++] = cur;
                previous = cur;
                
                val++;
            }
        }
        
        
        return val;
    }
}