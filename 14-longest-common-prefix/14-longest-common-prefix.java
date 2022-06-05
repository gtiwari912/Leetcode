class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        StringBuilder sb = new StringBuilder();
        boolean breakIt = false;
        for(int i = 0; i<201 && !breakIt; i++){
            for(int j = 1; j<strs.length; j++){
                String cur = strs[j];
                if(cur.length() - 1 < i ||
                  strs[j-1].length()-1 < i){
                    breakIt = true;
                    break;
                }
                if(cur.charAt(i) != strs[j-1].charAt(i)){
                    breakIt = true;
                    break;
                }
            }
            if(breakIt)
                continue;
            sb.append(strs[0].charAt(i));
        }
        
        
        return sb.toString();
    }
}