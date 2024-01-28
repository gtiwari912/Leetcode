class Solution {
    public boolean isSubsequence(String s, String t) {
        return solve(s, t, 0,0);
    }
    
    public boolean solve(String s, String t, int one, int two){
        if(one==s.length()) return true;
        char charOne = s.charAt(one);
        for(int i = two; i<t.length(); i++){
            char charTwo = t.charAt(i);
            if(charTwo == charOne){
                return solve(s, t, one+1, i+1);
            }
        }
        return false;
    }
}