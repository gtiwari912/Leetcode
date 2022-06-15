class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    HashMap<String, Integer> dp = new HashMap<>();
    public int longestStrChain(String[] words) {
        // sort(words);
        int count = 0;
        HashMap<Integer, List<String>> map = new HashMap<>();
        int smallestSize = Integer.MAX_VALUE;
        for(String cur: words){
            int size = cur.length();
            smallestSize = Math.min(smallestSize, size);
            if(map.containsKey(size)){
                map.get(size).add(cur);
            }
            else{
                map.put(size, new ArrayList<String>());
                map.get(size).add(cur);
            }
        }
        int ans = 0;
        for(int size: map.keySet()){
            for(String cur: map.get(size)){
                ans = Math.max(
                    ans,
                    recurse(cur, 1, map)
                );
            }
        }
        
        return ans;
    }
    
    private int recurse(String word, int cur,  HashMap<Integer, List<String>> map){
        int size = word.length();
        if(dp.containsKey(word))
            return cur+dp.get(word);
        if(!map.containsKey(size+1))
            return cur;
        int ans = 0;
        for(String now : map.get(size+1)){
            if(isPredecessor(now, word)){
                ans = Math.max(
                    ans,
                    recurse(now, cur+1, map)
                );
            }
        }
        
        int result = ans==0? cur:ans;
        dp.put(word, result - cur);
        return result;
    }
    
    private boolean isPredecessor(String s1, String s2){
        String str = s1+","+s2;
        if(memo.containsKey(str))
            return memo.get(str);
        // System.out.println("s1:"+s1+" s2:"+s2);
        if(s1.length() - s2.length() != 1){
            // System.out.println(false);
            memo.put(str, false);
            return false;
        }
        int samePrefix = 0;
        int i = 0;
        while(i<s2.length()){
            if(s1.charAt(i) == s2.charAt(i)){
                samePrefix++;
                i++;
            }
            else{
                break;
            }
        }
        
        int sameSuffix = 0;
        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        while(i1>=0 && i2>=0){
            if(s1.charAt(i1) == s2.charAt(i2)){
                i1--;
                i2--;
                sameSuffix++;
            }
            else{
                break;
            }
        }
        
        
        boolean result = samePrefix + sameSuffix >= s2.length();
        // System.out.println(result);
        memo.put(str, result);
        return result;
    }
        
        

    private void sort(String[] arr){
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(final String s1, final String s2){
                return s1.length() - s2.length();
            }
        });
    }
}