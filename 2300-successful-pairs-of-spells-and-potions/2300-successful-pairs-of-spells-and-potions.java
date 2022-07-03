class Solution {
    public int[] successfulPairs(int[] spell, int[] potions, long suc) {
        Arrays.sort(potions);
        int n = spell.length;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            if(suc%spell[i] != 0){
                ans[i] = binSearch(potions, (suc/(long)spell[i] + 1));
            }
            else{
                ans[i] = binSearch(potions, (suc/(long)spell[i]));
            }
        }
        
        return ans;
    }
    
    private static int binSearch(int[] nums, long target){
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            int mid = (left+right)/2;
            // System.out.println("L:"+left+" R:"+right+" M:"+mid);
            if(nums[mid]==target){
                right = mid;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        // System.out.println("Left is "+left);
        return nums[left]>=target?n-(left):0;
    }
}