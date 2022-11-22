class Solution {
    public int numSquares(int n) {
        List<Integer> perfectSquares = new ArrayList<>();
        return solve(n, new HashMap<Integer, Integer>());
    }
    
    private int solve(int n, HashMap<Integer, Integer> map){
        if(n==0 || n==1) return n;
        
        if(map.containsKey(n))
            return map.get(n);
        int i = 1;
        int min = Integer.MAX_VALUE;
        while(i*i<=n){
            min = Math.min(1+solve(n-i*i, map), min);
            i++;
        }
        map.put(n, min);
        return min;
    }
}