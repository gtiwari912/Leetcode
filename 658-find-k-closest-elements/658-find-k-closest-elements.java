class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int idx = bin(arr, x);
        int one= 0, two = 0;
        if(idx<0){
            one = Math.abs(idx+1);
            two = Math.abs(idx);
        }
        else{
            one = idx;
            two = idx;
        }
        System.out.println("IDX:"+idx+" one:"+one+" two:"+two);
        while(one>=0 && two<arr.length && k>0){
            int a = arr[one];
            int b = arr[two];
            if(one==two){
                ans.add(arr[one]);
                two++;
                one--;
                k--;
            }
            else if (Math.abs(x-a) <= Math.abs(x-b)){
                ans.add(a);
                one--;
                k--;
            }
            else{
                ans.add(b);
                two++;
                k--;
            }
        }
        if(k>0){
            if(one>0){
                while(k-->0){
                    ans.add(arr[one--]);
                }
            }
            else{
                while(k-->0){
                    ans.add(arr[two++]);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
    
    private int bin(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        
        return -left;
    }
}