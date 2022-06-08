class Solution {
    public int removePalindromeSub(String s) {
        if(isPalindrome(s))
            return 1;
        else
            return 2;
    }
    boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;
        while(start<end){
            char startChar = s.charAt(start++);
            char endChar = s.charAt(end--);
            if(startChar == endChar)
                continue;
            else
                return false;
        }
        return true;
    }
}