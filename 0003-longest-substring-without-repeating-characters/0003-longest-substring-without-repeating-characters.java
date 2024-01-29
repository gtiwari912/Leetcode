class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j<s.length()){
            char curChar = s.charAt(j);
            if(!st.contains(curChar)){
                st.add(curChar);
                j++;
                max = Math.max(max, st.size());
            }
            else{
                while(s.charAt(i) != curChar){
                    st.remove(s.charAt(i));
                    i++;
                }
                st.remove(s.charAt(i));
                i++;
                st.add(curChar);
                j++;
                max = Math.max(max, st.size());
            }
        }

        return max;
    }
}

// max = 3




//  {,k,e,w} 