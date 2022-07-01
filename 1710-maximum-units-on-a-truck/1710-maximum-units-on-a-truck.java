class Solution {
    public int maximumUnits(int[][] boxType, int truckSize) {
        Arrays.sort(boxType, (a,b)->b[1]-a[1]);
        int count = 0;
        int cur = 0;
        while(truckSize>0 && cur<boxType.length){
            int[] now = boxType[cur];
            if(boxType[cur][0]<= truckSize){
                count += boxType[cur][0] * boxType[cur][1];
                truckSize -= boxType[cur][0];
                cur++;
            }
            else{
                count += truckSize * boxType[cur][1];
                truckSize = 0;
            }
        }
        
        return count;
    }
}