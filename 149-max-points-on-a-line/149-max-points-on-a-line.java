class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 1)
            return 1;
        int max = 0;
        for(int i = 0; i<points.length; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            HashMap<Double, HashSet<String>> map = new HashMap<>();
            for(int j = 0; j<points.length; j++){
                if(i==j)
                    continue;
                int x2 = points[j][0];
                int y2 = points[j][1];
                double slope = (double)(y2 - y1)/(double)(x2-x1);
                if(map.containsKey(slope)){
                    map.get(slope).add(x1+","+y1);
                    map.get(slope).add(x2+","+y2);
                }
                else{
                    map.put(slope, new HashSet<String>());
                    map.get(slope).add(x1+","+y1);
                    map.get(slope).add(x2+","+y2);
                }
            }
            for(HashSet<String> cur: map.values())
                max = Math.max(cur.size() , max);
        }
        
        
        return max;
    }
}