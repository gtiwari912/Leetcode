class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int m = queries.length;
        int[] ans = new int[m];
        for(int i = 0; i<m; i++) 
            ans[i]= solve(nums, queries[i]);
        return ans;
    }
    
    private int solve(int[] arr, int k){
        int sum  = 0;
        int count = 0;
        for(int i:  arr){
            if(sum>k) return count-1;
            sum += i;
            count++;
        }
        return sum>k? count-1: count;
    }
}