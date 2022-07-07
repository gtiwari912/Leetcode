class Solution {
    HashSet<String> memoSet;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length())
            return false;
        memoSet = new HashSet<>();
        return helper(s1, s2, s3, 0, 0, 0, true);
    }
    
    private boolean helper(String s1, String s2, String s3, int l, int r, int i, boolean goleft){
        String str = l+","+r+","+"i";
        if(memoSet.contains(str))
            return false;
        if(goleft){
            while(l<s1.length() || r<s2.length()){
                char lc = '*';
                char rc = '*';
                if(l<s1.length())
                    lc = s1.charAt(l);
                if(r<s2.length())
                    rc = s2.charAt(r);
                char target = s3.charAt(i);
                if(rc != target && lc!=target){
                    memoSet.add(str);
                    return false;
                }
                if(rc==target && lc!=target){
                    r++; i++;
                    continue;
                }
                if(lc==target && rc!=target){
                    l++; i++;
                    continue;
                }
                else{
                    boolean ans =  helper(s1, s2, s3, l+1, r, i+1, true) ||
                        helper(s1, s2, s3, l, r+1, i+1, true);
                    if(ans==false)
                        memoSet.add(str);
                    return ans;
                }
            }
            return true;
        }
        return false;
    }
}