class Solution {
    public int removeDuplicates(int[] nums) {
        int back = 0;
        int front = 0;
        int n = nums.length;
        while(front < n){
            int cur = nums[front];
            nums[back++] = nums[front];
            int frontElement = nums[front];
            while(front<n && nums[front] == frontElement) 
                front++;
        }
        return back;
    }
}