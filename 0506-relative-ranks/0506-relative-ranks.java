class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(score[i], i);
        }
        int[] tem = new int[n];
        for(int i = 0; i<n; i++) tem[i] = score[i];
        Arrays.sort(tem);
        int left = 0;
        int right = n-1;
        while(left<right){
            int temp = tem[left];
            tem[left] = tem[right];
            tem[right]= temp;
            left++;
            right--;
        }
        int iter = 1;
        String[] ans = new String[n];
        for(int i: tem){
            String str = (iter==1)? "Gold Medal" : (iter==2)? "Silver Medal" : (iter==3)? "Bronze Medal":""+iter;
            iter++;
            ans[map.get(i)] = str;
        }
        
        return ans;
    }
}