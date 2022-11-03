class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for(String word: words){
            String req = word.charAt(1)+""+word.charAt(0);
            if(map.containsKey(req)){
                map.put(req, map.get(req)-1);
                if(map.get(req)<=0) map.remove(req);
                ans += 4;
            }
            else{
                map.put(word, map.getOrDefault(word,0)+1);
            }
        }
        List<String> toberemoved = new ArrayList<>();
        for(String key: map.keySet()) if(key.charAt(0) != key.charAt(1)) toberemoved.add(key);
        for(String key: toberemoved) map.remove(key);
        for(String key: map.keySet()){
            if(map.get(key) % 2 ==0){
                map.remove(key);
                ans += map.get(key) * 2;
            }
            else{
                ans += (map.get(key) - 1) * 2;
            }
        }
        if(!map.keySet().isEmpty()) ans += 2;
        return ans;
    }
}