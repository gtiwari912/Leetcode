class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int n = s.length();
        int start = -1;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(end<n){
            char curChar = s.charAt(end);
            int lastOccourence = map.getOrDefault(curChar, -1);
            start = Math.max(lastOccourence, start);
            max = Math.max(max, end - start);
            map.put(curChar, end);
            end++;
        }
        
        return max;
    }
}