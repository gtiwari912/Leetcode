class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int limit = n/3 + 1;
        if(n==1 || n==2){
            List<Integer> ans = new ArrayList<>();
            HashSet<Integer> ansSet = new HashSet<>();
            for(int cur: nums)
                ansSet.add(cur);
            for(int cur: ansSet)
                ans.add(cur);
            return ans;
        }
        Arrays.sort(nums);
        int count = 1;
        int prev = nums[0];
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<n; i++){
            int cur = nums[i];
            if(cur == prev){
                count++;
                if(count>=limit){
                    if(ans.isEmpty() || ans.get(ans.size()-1) != cur){
                        ans.add(cur);
                    }
                }
            }
            else{
                count = 1;
                prev = cur;
            }
        }
        
        return ans;
        
    }
}