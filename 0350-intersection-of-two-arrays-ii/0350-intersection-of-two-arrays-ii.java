class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i: nums1) map1.put(i, map1.getOrDefault(i,0)+1);
        for(int i: nums2) map2.put(i, map2.getOrDefault(i,0)+1);
        ArrayList<Integer> list= new ArrayList<>();
        for(int key: map1.keySet()){
            if(!map2.containsKey(key))
                continue;
            int map1Freq = map1.get(key);
            int map2Freq = map2.get(key);
            int appendCount = Math.min(map1Freq, map2Freq);
            for(int i = 0; i<appendCount; i++) 
                list.add(key);
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i<list.size(); i++) 
            result[i] = list.get(i);
        return result;
    }
 }


// [1,2,2,1]            [2,2]

// {

// }
