class Solution {
    public int search(int[] nums, int target) {
        int ans = binSearch(nums, 0, nums.length-1, target);
        return ans;
    }
    
    private int binSearch(int[] num, int l, int h, int key){
        if(l>h)
            return -1;
        
        int mid = (l+h)/2;
        if(num[mid]==key)
            return mid;
        if(num[mid]<num[h]){
            if(key>num[mid] && key<=num[h])
                return binSearch(num, mid+1, h, key);
            else{
                return binSearch(num, l, mid-1, key);
            }
        }
        if(key>=num[l] && key<num[mid])
            return binSearch(num, l, mid-1, key);
        else
            return binSearch(num, mid+1, h, key);
    }
}