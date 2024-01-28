class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        char prev = ' ';
        for(char c: s.toCharArray()){
            if(c!=' ' && prev == ' '){
                count = 0;
            }
            if(c!=' ') count++;
            prev = c;
        }
        return count;
    }
}