class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        char cur = 'a';
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Character> map = new HashMap<>();
        for(char c: pattern.toCharArray()){
            if(map.containsKey(c)){
                sb.append(map.get(c));
            }
            else{
                map.put(c, cur);
                sb.append(map.get(c));
                cur++;
            }
        }
        pattern = sb.toString();
        for(String curword: words){
            sb = new StringBuilder();
            cur = 'a';
            map = new HashMap<>();
            for(char c: curword.toCharArray()){
                if(!map.containsKey(c)){
                    map.put(c, cur);
                    cur++;
                }
                sb.append(map.get(c));
            }
            String curPattern = sb.toString();
            if(curPattern.equals(pattern)){
                ans.add(curword);
            }
        }
        
        return ans;
    }
}