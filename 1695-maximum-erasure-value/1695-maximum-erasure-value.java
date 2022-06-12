class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        int maxSum = 0;
        HashSet<Integer> set = new HashSet<>();
        while(end <n){
            int curEle = nums[end];
            if(set.contains(curEle)){
                while(start<n && nums[start] != curEle){
                    sum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                sum -= nums[start];
                start++;
            }
            set.add(curEle);
            sum += curEle;
            maxSum = Math.max(sum, maxSum);     
            end++;
        }
        
        return maxSum;
    }
}