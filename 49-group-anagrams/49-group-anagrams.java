class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word: strs){
            int[] arr = new int[26];
            for(char c: word.toCharArray()){
                arr[c-'a'] = arr[c-'a']+1;
            }
            String str = Arrays.toString(arr);
            if(map.containsKey(str))
                map.get(str).add(word);
            else
                map.put(str, new ArrayList<String>(){{
                    add(word);
                }});
        }
        for(List<String> cur: map.values())
            ans.add(cur);
        
        
        return ans;
    }
}