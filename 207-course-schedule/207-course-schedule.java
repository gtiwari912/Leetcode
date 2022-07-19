class Solution {
    HashMap<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisite) {
        map = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] arr: prerequisite){
            int course = arr[0];
            int prereq = arr[1];
            map.get(prereq).add(course);
        }
        for(int i = 0; i<numCourses; i++)
            if(hasCycle(i, new HashSet<Integer>(), new HashSet<Integer>()))
                return false;
        return true;
    }
    
    private boolean hasCycle(int node, Set<Integer> visiting, Set<Integer> visited){
        visiting.add(node);
        for(int neigh: map.get(node)){
            if(visited.contains(neigh))
                continue;
            if(visiting.contains(neigh))
                return true;
            visited.add(neigh);
            if(hasCycle(neigh, visiting, visited))
                return true;
        }
        return false;
    }
}