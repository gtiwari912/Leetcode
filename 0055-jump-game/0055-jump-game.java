class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        if(nums[0]==0) return false;
        int n = nums.length;
        boolean[] canReach = new boolean[n];
        canReach[0] = true;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                int target = i;
                int curIndex = j;
                int jumps = nums[curIndex];
                int reach = curIndex + jumps;
                if(reach>=target){
                    canReach[target] = true;
                    break;
                }
//                 else{
//                     System.out.println("returning on Index "+target);
//                     return 
                    
//                 }
            }
            if(canReach[i]==false) return false;
        }
        // System.out.println(Arrays.toString(canReach));
        return canReach[n-1];
    }
}