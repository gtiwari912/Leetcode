class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return ans;
    }
    
    
    public void helper(int[] nums, int curIndex, List<Integer> list){
        int n = nums.length;
        if(curIndex==n){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int element: list) temp.add(element);
            ans.add(temp);
            return;
        }
        int curElement = nums[curIndex];
        list.add(curElement); //pick;
        helper(nums, curIndex+1, list);
        list.remove( list.size() -1 );
        helper(nums, curIndex+1, list);
    }
}