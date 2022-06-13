class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        for(int i = t.size()-2; i>=0; i--){
            for(int j = 0; j<t.get(i).size(); j++){
                int curEle = t.get(i).get(j);
                t.get(i).set(j,
                            Math.min(
                                curEle + t.get(i+1).get(j),
                                curEle + t.get(i+1).get(j+1)
                                )
                            );
            }
        }
        
        return t.get(0).get(0);
    }
}