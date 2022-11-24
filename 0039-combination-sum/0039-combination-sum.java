class Solution {
    
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans =new ArrayList<>();
        helper(candidates, target, new ArrayList<>());
        for(List<Integer> curList: ans) Collections.sort(curList);
        HashSet<List<Integer>> set =new HashSet<>();
        for(List<Integer> l : ans) set.add(l);
        ans = new ArrayList<>();
        for(List<Integer> l : set) ans.add(l);
        return ans;
    }
    
    
    public void helper(int[] arr, int target, List<Integer> list){
        if(target<0) return;
        if(target == 0){
            List<Integer> temp = new ArrayList<>();
            for(int ele: list) temp.add(ele);
            ans.add(temp);
            return;
        }
        
        for(int ele: arr){
            list.add(ele);
            helper(arr, target-ele, list);
            list.remove(list.size()-1);
        }
        
    }
}