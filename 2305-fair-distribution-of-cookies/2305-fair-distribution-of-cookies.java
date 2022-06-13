class Solution {
    int min = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        recurse(cookies, 0, children);
        return min;
    }
    
    private void recurse(int[] cookies, int cur, int[] children){
        if(cur==cookies.length){
            int max = 0;
            for(int i: children)
                max = Math.max(max, i);
            min = Math.min(max, min);
            return;
        }
        for(int i = 0; i<children.length; i++){
            children[i] += cookies[cur];
            recurse(cookies, cur+1, children);
            children[i] -= cookies[cur];
        }
    }
}