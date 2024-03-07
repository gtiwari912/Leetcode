class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int count = 0;
        int min = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        for(int i = 0; i<min; i++){
            if(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) count++;
            else{
                break;
            }
        }
        int ans= 0;
        ans += (s1.length() - count);
        ans += (s2.length() - count);
        ans += (s3.length() - count);
        if(count == 0) return -1;
        if(ans == 0 ) return 0;
        return ans;
        
        
    }
}