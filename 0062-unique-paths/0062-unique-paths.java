class Solution {
    int lastRow;
    int lastCol;
    HashMap<String, Integer> map;
    public int uniquePaths(int m, int n) {
        lastRow = m;
        lastCol = n;
        map = new HashMap<>();
        return solve(1,1);
    }
    
    public int solve(int x, int y){
        String curPos = x+","+y;
        if(map.containsKey(curPos)) return map.get(curPos);
        if(x==lastRow && y==lastCol)
            return 1;
        if(x>lastRow || y>lastCol) return 0;
        int ans = solve(x, y+1) + solve(x+1, y);
        map.put(curPos, ans);
        return ans;
    }
}