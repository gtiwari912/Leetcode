class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> ansSet = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<n; i++){
            int num1 = nums[i];
            int target = -num1;
            int start = i+1;
            int end = n-1;
            while(start<end){
                if(nums[start] + nums[end] == target){
                    ArrayList<Integer> now = new ArrayList<>();
                    now.add(num1);
                    now.add(nums[start]);
                    now.add(nums[end]);
                    ansSet.add(now);
                    start++; end--;
                }
                else if(nums[start] + nums[end] < target){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        
        for(List<Integer> now: ansSet)
            ans.add(now);
        
        return ans;
    }
}