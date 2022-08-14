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

// Dynamic Programming - Memorization/TopDown Approach; //Accepted
//Time: O(N)  Space: O(N) + O(N)
// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return recurse(n, dp);
//     }
    
//     private int recurse(int n, int[] dp){
//         if(n<=1) return 1;
//         if(dp[n] != -1) return dp[n];
//         return dp[n] = recurse(n-1, dp) + recurse(n-2, dp);
//     }
// }



// Dynamic Programming - Tabulation/BottumUp;
// Time: O(N) Space: O(N)
class Solution{
    public int climbStairs(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}























































