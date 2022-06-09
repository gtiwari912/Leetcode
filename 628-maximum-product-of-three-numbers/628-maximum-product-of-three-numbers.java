class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last = nums.length -1;
        return Math.max(
            (nums[0]*nums[1]*nums[last]), (nums[last]*nums[last-1]*nums[last-2])
        );
    }
}