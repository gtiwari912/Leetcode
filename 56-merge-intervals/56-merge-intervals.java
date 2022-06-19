class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        int ll = intervals[0][0];
        int ul = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            int[] cur = intervals[i];
            if(cur[0]>=ll && cur[0]<=ul){
                ul = Math.max(cur[1], ul);
            }
            else{
                int[] now = new int[2];
                now[0] = ll;
                now[1] = ul;
                list.add(now);
                
                ll = cur[0];
                ul = cur[1];
            }
        }
        int[] now = new int[2];
        now[0] = ll;
        now[1] = ul;
        list.add(now);
        int[][] ans = new int[list.size()][2];
        int iter=0;
        for(int[] cur: list){
            ans[iter++] = cur;
        }
        
        return ans;
    }
}