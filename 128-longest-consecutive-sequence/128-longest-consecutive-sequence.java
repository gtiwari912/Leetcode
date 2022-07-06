class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums)
            set.add(i);
        int longestStreak = 0;
        int curStreak = 0;
        for(int i: nums){
            if(!set.contains(i-1)){
                int cur = i+1;
                curStreak++;
                while(set.contains(cur)){
                    cur++;
                    curStreak++;
                }
                longestStreak = Math.max(curStreak, longestStreak);
                curStreak = 0;
            }
        }
        
        return longestStreak;
    }
}