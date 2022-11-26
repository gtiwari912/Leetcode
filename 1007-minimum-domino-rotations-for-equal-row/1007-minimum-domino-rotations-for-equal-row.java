class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        List<Integer> candidates = new ArrayList<>();
        
        //getting all candidates;
        for(int i = 1; i<=6; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if(tops[j]==i || bottoms[j]==i) count++;
            }
            if(count==n) candidates.add(i);
        }
        int ans = Integer.MAX_VALUE;
        
        for(int candidate: candidates){
            int x1 = 0;
            int x2 = 0;
            for(int i = 0; i<n; i++){
                if(tops[i]!=candidate) x1++;
                if(bottoms[i]!=candidate)x2++;
            }
            ans = Math.min(ans, Math.min(x1, x2));
        }
        
        return ans==Integer.MAX_VALUE? -1: ans;
        
    }
}


// 1 2 1 2 1 1 1
// 1 2 3 1 1 2 1
//     l   r

    
//     Take.......... Not take.
//     1              2
//     2               1
//     2               2
//     2               1
//     1               1
//     1 
    
//     first... Get the right candidate...?
//     check for everyone form 1->6 