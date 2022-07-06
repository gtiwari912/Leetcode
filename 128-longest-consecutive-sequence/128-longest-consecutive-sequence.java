class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            if(map.containsKey(nums[i]))
                continue;
            if(map.containsKey(nums[i]+1)){
                uf.union(i, map.get(nums[i] + 1));
            }
            if(map.containsKey(nums[i] - 1 ))
                uf.union(i, map.get(nums[i] - 1 ));
            map.put(nums[i], i);
        }
        
        return uf.getLargestComponentSize();
    }
}

class UnionFind{
    int[] parent;
    int[] size;
    UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i<n; i++){
            parent[i]= i;
            size[i] = 1;
        }
    }
    
    public void union(int v1, int v2){
        int root1 = find(v1);
        int root2 = find(v2);
        if(root1 != root2){
            parent[root1] = root2;
            size[root2] += size[root1];
        }
    }
    
    public int find(int v){
        if(parent[v] == v)
            return v;
        int ans = find(parent[v]);
        parent[v] = ans;
        return ans;
    }
    
    public int getLargestComponentSize(){
        int maxSize = 0;
        for(int i = 0; i<parent.length; i++){
            if(parent[i] == i){
                maxSize = Math.max(maxSize, size[i]);
            }
        }
        
        return maxSize;
    }
}