class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000000+7;
        long maxw = 0;
        long maxh = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for(int i =0; i<=horizontalCuts.length; i++){
            if(i==0){
                maxh = Math.max(maxh, horizontalCuts[0]);
                continue;
            }
            if(i==horizontalCuts.length){
                maxh = Math.max(maxh, h-horizontalCuts[i-1]);
                continue;
            }
            maxh = Math.max(maxh, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        for(int i = 0; i<=verticalCuts.length; i++){
            if(i==0){
                maxw = Math.max(maxw, verticalCuts[0]);
                continue;
            }
            if(i==verticalCuts.length){
                maxw = Math.max(maxw, w-verticalCuts[i-1]);
                continue;
            }
            maxw = Math.max(maxw, verticalCuts[i] - verticalCuts[i-1]);
        }
        
        long ans = maxh*maxw;
        int result = (int)(ans%mod);
        return result;
    }
}