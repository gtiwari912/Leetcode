class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums) map.put(i, map.getOrDefault(i,0)+1);
        for(int i: map.values()) max =Math.max(max, i);
        int ans = 0;
        for(int i: map.values()){
            if(i==max) ans+=i;
        }
        return ans;
    }
}