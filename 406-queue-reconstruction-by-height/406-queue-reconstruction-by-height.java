class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] ans =new int[n][2];
        for(int i = 0; i<n; i++){
            ans[i][0] = -1;
        }
        Arrays.sort(people, (a,b)-> (a[0] - b[0]) );
        for(int[] now: people)
            System.out.print(Arrays.toString(now)+" ");
        int cur = 0;
        while(cur <n){
            int[] curEle = people[cur];
            int k = curEle[1];
            int i = 0;
            while(k >= 0){
                
                if(ans[i][0] != -1 && ans[i][0] != curEle[0]){
                    i++;
                    continue;
                }
                if(k==0){
                    ans[i][0] = curEle[0];
                    ans[i][1] = curEle[1];
                    break;
                }
                k--;
                i++;
            }
            cur++;
        }
        
        
        return ans;
    }
}