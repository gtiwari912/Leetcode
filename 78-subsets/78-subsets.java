class Solution {
    List<List<Integer>> ans ;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>());
        return ans;
    }
    
    private void solve(int index, int[] nums, List<Integer> list){
        int n = nums.length;
        if(index==n){
            List<Integer> newList = new ArrayList<>();
            for(int cur: list)
                newList.add(cur);
            
            ans.add(newList);
            return;
        }
        list.add(nums[index]);
        solve(index+1, nums, list);
        list.remove(list.size()-1);
        solve(index+1, nums, list);
    }
}