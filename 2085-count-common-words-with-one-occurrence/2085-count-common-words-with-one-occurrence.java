class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for(String word: words1){
            map1.put(word, map1.getOrDefault(word, 0)+1);
        }
        for(String word: words2){
            map2.put(word, map2.getOrDefault(word, 0)+1);
        }
        HashSet<String> set = new HashSet<>();
        for(String key: map1.keySet()){
            if(map1.get(key) == 1) set.add(key);
        }

        int count = 0;
        for(String key: map2.keySet()){
            if(map2.get(key) == 1){
                if(set.contains(key)) count++;
            }
        } 
        return count;
  
    }
    
    // [leetcode, is , amazing, as]
    
    // {
    //     Leetcode: 1
    //         is: 2
    //         amazing: 1
    //             as: 1
    // }
    

    // {
    //     amazing : 1
    //         leetcode : 1
    //             is: 1
    // }
    
//     {
//         leetcode,
//         amazing,
//         as
//     }
    
    
//     count 1 1 
    
    
    
    
}