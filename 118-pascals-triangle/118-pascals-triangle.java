class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j<i+1; j++){
                if(j==0 || j==i){
                    list.add(1);
                }
                else{
                    list.add(
                        ans.get(ans.size()-1).get(j) +
                        ans.get(ans.size()-1).get(j-1)
                    );
                }
            }
            
            ans.add(list);
        }
        return ans;
    }
    
}