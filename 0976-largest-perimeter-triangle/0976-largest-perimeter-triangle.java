class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;
        Arrays.sort(nums);
        while(n>=3){
            int first = nums[n-1];
            int second = nums[n-2];
            int third = nums[n-3];
            if(second+third > first) return first+second+third;
            n--;
        }
        
        return 0;
    }
}