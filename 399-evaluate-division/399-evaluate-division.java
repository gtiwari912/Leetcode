class Solution {
    HashMap<String, HashMap<String, Double>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        graph = new HashMap<>();
        for(int i =0 ; i<n; i++){
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            if(!graph.containsKey(from))
                graph.put(from, new HashMap<>());
            if(!graph.containsKey(to))
                graph.put(to, new HashMap<>());
            double val = values[i];
            graph.get(from).put(to, val);
            graph.get(to).put(from, (double)1/val);
        }
        System.out.println(graph);
        
        double[] ans = new double[queries.size()];
        for(int i = 0; i<ans.length; i++){
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if(!graph.containsKey(from) || !graph.containsKey(to)){
                // System.out.println("Doing from here");
                ans[i] = (double)-1;
                continue;
            }
            ans[i] = dfs(from, to, (double)1, new HashSet<String>());
        }
        
        return ans;
    }
    
    private double dfs(String from, String to, double val, HashSet<String> visited){
        visited.add(from);
        if(from.equals(to))
            return val;
        for(String cur : graph.get(from).keySet()){
            if(!visited.contains(cur)){
                double ans = dfs(cur, to, val * graph.get(from).get(cur), visited);
                if(ans != -1)
                    return ans;
            }
        }
        visited.remove(from);
        return -1;
    }
}