class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n][m];
        for(int[] arr: dp)
            for(int i = 0; i<arr.length; i++)
                arr[i] = -1;
        return lcs(text1, text2, 0, 0);
    }
    
    
    private int lcs(String s1, String s2, int x, int y){
        if(x==s1.length() || y == s2.length())
            return 0;
        if(dp[x][y] != -1) 
            return dp[x][y];
        if(s1.charAt(x) == s2.charAt(y))
            return dp[x][y] =  1 + lcs(s1, s2, x+1, y+1);
        return dp[x][y] =  Math.max(
            lcs(s1, s2, x+1, y),
            lcs(s1, s2, x, y+1)
        );
    }
}