class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        HashMap<Integer, ArrayList<Character>> freqMap = new HashMap<>();
        for(char key: map.keySet()){
            int val = map.get(key);
            if(!freqMap.containsKey(val)){
                freqMap.put(val, new ArrayList<Character>());
            }
            freqMap.get(val).add(key);
        }
        System.out.println("map: "+map);
        System.out.println("freqMap: "+freqMap);
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int key: freqMap.keySet()){
            arr.add(key);
            set.add(key);
        }
        Collections.sort(arr);
        int count = 0;
        for(int curFreq : freqMap.keySet()){
            int noOfEle = freqMap.get(curFreq).size();
            while(noOfEle-->1){
                int curFreqCopy = curFreq;
                while(set.contains(curFreqCopy)){
                    curFreqCopy--;
                    count++;
                }
                if(curFreqCopy != 0){
                    set.add(curFreqCopy);
                }
            }
        }
        
        return count;
        
        
    }
    
}