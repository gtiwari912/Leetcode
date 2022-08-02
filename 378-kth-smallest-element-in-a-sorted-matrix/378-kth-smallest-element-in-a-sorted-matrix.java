class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        for(int[] curArr: matrix)
            for(int cur: curArr)
                list.add(cur);
        
        Collections.sort(list);
        return list.get(k-1);
    }
}