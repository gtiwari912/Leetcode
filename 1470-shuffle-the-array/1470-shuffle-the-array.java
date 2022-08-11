class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[n*2];
        int ptr1 = 0;
        int ptr2 = n;
        for(int i = 0; i<2*n;  i++){
            if(i%2==0){
                res[i] = nums[ptr1];
                ptr1++;
            }
            else{
                res[i] = nums[ptr2];
                ptr2++;
            }
        }
        
        return res;
    }
}