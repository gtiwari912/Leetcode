//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair{
        int node;
        int prev;
        Pair(){
            
        }
        Pair(int node, int prev){
            this.node = node;
            this.prev = prev;
        }
    }
    // Function to detect cycle in an undirected graph.
    int[] visited;
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        visited = new int[V];
        for(int i = 0; i<V; i++){
            if(visited[i]!=1) if(isCyclee(i, adj)) return true;
        }
        return false;
    }
    
    private boolean isCyclee(int node, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new ArrayDeque<>();
        visited[node] = 1;
        q.add(new Pair(node, -1));
        while(!q.isEmpty()){
            Pair now = q.remove();
            int cur = now.node;
            int prev = now.prev;
            for(int neigh: adj.get(cur)){
                if(neigh==prev) continue;
                if(visited[neigh]==1) return true;
                visited[neigh] =1;
                Pair p = new Pair(neigh, cur);
                q.add(p);
            }
        }
        return false;
    }
 }