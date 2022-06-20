class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int cur: nums)
            set.add(cur);
        
        
        int longestStreak = 0;
        for(int cur: set){
            if(!set.contains(cur-1)){
                int curStreak = 1;
                cur++;
                while(set.contains(cur)){
                    curStreak++;
                    cur++;
                }
                longestStreak = Math.max(longestStreak, curStreak);
            }
        }
        
        return longestStreak;
        
    }
}