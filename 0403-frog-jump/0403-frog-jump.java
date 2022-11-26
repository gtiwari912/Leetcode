class Solution {
    int[] stones;
    HashSet<Integer> set;
    HashMap<String, Boolean> dpMap = new HashMap<>();
    public boolean canCross(int[] stones) {
        if(stones.length<=1) return true;
        this.stones = stones;
        set = new HashSet<>();
        for(int st: stones) set.add(st);
        if(stones[1]-stones[0] != 1) return false;
        return solve(stones[1], 1);
    }
    
    private boolean solve(int curPosition, int prevJump){
        String key = curPosition+","+prevJump;
        if(dpMap.containsKey(key)) return dpMap.get(key);
        if(!set.contains(curPosition)) return false;
        int lastPos = stones[stones.length-1];
        if(curPosition == lastPos) return true;
        boolean case1;
        if(prevJump==1){
            case1 = false;
        }
        else{
            case1 = solve(curPosition+(prevJump-1), prevJump-1);
        }
        boolean case2 = solve(curPosition + prevJump, prevJump);
        boolean case3 = solve(curPosition+prevJump+1, prevJump+1);
        boolean ans;
        if( case1 || case2  || case3 )
           ans = true;
        else
           ans = false;
        
        dpMap.put(key, ans);
        return ans;
    }
}