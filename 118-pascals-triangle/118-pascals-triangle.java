class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for(int j = 1; j<=i-1; j++){
                int curNum = ans.get(ans.size()-1).get(j-1) + ans.get(ans.size()-1).get(j);
                now.add(curNum);
            }
            if(i!=0)
                now.add(1);
            ans.add(now);
        }
        
        
        return ans;
    }
}