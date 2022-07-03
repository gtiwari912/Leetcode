class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] ups = new int[n];
        int[] downs = new int[n];
        ups[n-1] = 1;
        downs[n-1]=1;
        for(int i= n-2; i>=0; i--){
            int cur = nums[i];
            for(int j = i+1; j<n; j++){
                if(nums[j]>cur){
                    ups[i] = Math.max(ups[i], 1 + downs[j]);
                }
                if(nums[j]<cur){
                    downs[i] = Math.max(downs[i], 1+ups[j]);
                }
            }
        }
        // System.out.println("UPS:"+Arrays.toString(ups));
        // System.out.println("DOWNS:"+Arrays.toString(downs));
        
        int ans = 0;
        for(int i= 0; i<n; i++){
            ans = Math.max(ans,  Math.max(ups[i], downs[i]) );
        }
        return ans;
    }
}