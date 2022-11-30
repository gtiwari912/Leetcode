class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int key: map.keySet()){
            int val = map.get(key);
            if(set.contains(val)){
                return false;
            }
            else set.add(val);
        }
        
        return true;
    }
}