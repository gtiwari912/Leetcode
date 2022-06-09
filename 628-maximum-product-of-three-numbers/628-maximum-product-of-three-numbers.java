class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MAX_VALUE;
        int max3 = Integer.MAX_VALUE;
        for(int cur: nums){
            if(cur<=min1){
                min2 = min1;
                min1 = cur;
            }
            else if(cur<=min2){
                min2 = cur;
            }
            
            if(cur>=max1){
                max3 = max2;
                max2 = max1;
                max1 = cur;
            }
            else if(cur>=max2){
                max3 = max2;
                max2 = cur;
            }
            else if(cur>=max3){
                max3 = cur;
            }
        }
        
        return Math.max(
        (min1* min2*max1), (max1*max2*max3)
        );
    }
}