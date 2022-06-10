class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int largestLength = 0;
        String largestString = "";
        HashMap<Character, Integer> map = new HashMap<>();
        while(end < s.length()){
            char curChar = s.charAt(end);
            if(!map.containsKey(curChar)){
                int curLength = end - start + 1;
                map.put(curChar, map.getOrDefault(curChar, 0)+1);
                if(curLength > largestLength){
                    largestLength = curLength;
                    largestString = s.substring(start, end + 1);
                }
                end++;
            }
            else{
                while(s.charAt(start) != curChar){
                    map.remove(s.charAt(start++));
                }
                map.remove(s.charAt(start++));
            }
        }
        
        
        return largestLength;
    }
}