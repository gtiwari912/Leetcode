// Pure recursion - TLE;
// class Solution {
//     int count = 0;
//     public int climbStairs(int n) {
//         recurse(n);
//         return count;
//     }
    
//     private void recurse(int n){
//         if(n<=1)
//         {
//             count++;
//             return;
//         }
//         recurse(n-1);
//         recurse(n-2);
//     }
// }

// Dynamic Programming - Memorization/TopDown Approach;
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recurse(n, dp);
    }
    
    private int recurse(int n, int[] dp){
        if(n<=1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = recurse(n-1, dp) + recurse(n-2, dp);
    }
}