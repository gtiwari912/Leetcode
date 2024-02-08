class Solution {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                for(int k = j+1; k<n; k++){
                    for(int l = k+1; l<n; l++){
                        int ll = nums[l];
                        int ii = nums[i];
                        int jj = nums[j];
                        int kk = nums[k];
                        if(ii+jj+kk == ll) count++;
                    }
                }
            }
        }
        return count;
    }
}