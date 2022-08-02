class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] A = new int[n];
        int[] B = new int[n];
        Arrays.fill(A, Integer.MAX_VALUE);
        Arrays.fill(B, Integer.MAX_VALUE);
        bfs(node1, edges, A);
        bfs(node2, edges, B);
        // System.out.println(Arrays.toString(A));
        // System.out.println(Arrays.toString(B));
        int max = Integer.MAX_VALUE;
        int node = -1;
        for(int i = 0; i<n; i++){
            if(A[i]==Integer.MAX_VALUE || B[i]==Integer.MAX_VALUE)
                continue;
            if(max > Math.max(A[i], B[i])){
                max = Math.min(Math.max(A[i], B[i]), max);
                node = i;
            }
        }
        
        return node;
    }
    
    private void bfs(int src, int[] edges, int[] A){
        int n = edges.length;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        A[src] = 0;
        while(!queue.isEmpty()){
            int cur = queue.remove();
            if(edges[cur] != -1 && A[edges[cur]]==Integer.MAX_VALUE){
                A[edges[cur]] = Math.min(A[cur]+1, A[edges[cur]]);
                queue.add(edges[cur]);
            }
        }
    }
}