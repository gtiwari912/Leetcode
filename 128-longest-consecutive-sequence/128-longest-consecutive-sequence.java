// class Solution {
//     public int longestConsecutive(int[] nums) {
//         HashSet<Integer> set = new HashSet<Integer>();
//         for(int i : nums)
//             set.add(i);
//         int longestStreak = 0;
//         int curStreak = 0;
//         for(int i: nums){
//             if(!set.contains(i-1)){
//                 int cur = i+1;
//                 curStreak = 1;
//                 while(set.contains(cur)){
//                     cur++;
//                     curStreak++;
//                 }
//                 longestStreak = Math.max(curStreak, longestStreak);
//             }
//         }
        
//         return longestStreak;
//     }
// }
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