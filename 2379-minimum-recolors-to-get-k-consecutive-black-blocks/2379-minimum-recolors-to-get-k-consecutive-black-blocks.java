class Solution {
    public int minimumRecolors(String blocks, int k) {
        int start = 0;
        int end = k-1;
        int max = Integer.MAX_VALUE;
        while(end<blocks.length()){
            int count = 0;
            for(int i = start; i<=end; i++)
                if(blocks.charAt(i) == 'W')
                    count++;
            max = Math.min(count, max);
            start++;
            end++;
        }
        return max;
    }
}