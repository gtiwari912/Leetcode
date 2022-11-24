class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String curWord: strs){
            char[] cArr = curWord.toCharArray();
            Arrays.sort(cArr);
            String newWord = new String(cArr);
            if(map.containsKey(newWord)){
                map.get(newWord).add(curWord);
            }
            else{
                map.put(newWord, new ArrayList<String>());
                map.get(newWord).add(curWord);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        
        
        return ans;
        
    }
}



// // sort -> newWord           eat - aet;   S : {}
//                              tea - aet;   key: -> 
                                 
//                              {
//                                  "aet" -> {eat, tea }
//                                  "ant" -> {tan, }
//                              }

// {   {eat, tea },    {tan, } }