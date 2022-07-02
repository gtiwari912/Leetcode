class Solution {
    List<Integer> ans;
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        int indx = -1;
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            // System.out.println("L:"+left+" R:"+right+" M:"+mid);
            if(nums[mid] == target){
                indx = mid;
                break;
            }
            if(nums[mid]< target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        if(indx == -1)
            return ans;
        ans.add(indx);
        helper(nums, target, indx+1, true);
        helper(nums, target, indx-1, false);
        Collections.sort(ans);
        return ans;
    }
    
    private void helper(int[] nums, int target, int i, boolean forwardDir){
        if(i<0 || i>=nums.length)
            return;
        if(forwardDir){
            while(i<nums.length && nums[i]==target){
                ans.add(i++);
            }
        }
        else{
            while(i>=0 && nums[i]==target){
                ans.add(i--);
            }
        }
    }
}