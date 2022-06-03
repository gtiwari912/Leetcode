class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxArea = 0;
        while(left<right){
            int area = (right-left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if(height[left]>height[right]){
                right--;
            }
            else
                left++;
        }
        
        return maxArea;
    }
}