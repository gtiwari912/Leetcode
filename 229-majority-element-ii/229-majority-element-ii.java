class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int limit = 0;
        if(n%3==0){
            limit = n/3+1;
        }
        else{
            limit = n/3 + 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int cur: nums){
            map.put(cur, map.getOrDefault(cur, 0) +1);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int cur: map.keySet()){
            if(map.get(cur) >= limit)
                ans.add(cur);
        }
        
        
        return ans;
        
    }
}