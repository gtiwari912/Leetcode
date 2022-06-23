class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1]==b[1]? a[0]-b[0] : a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;
        for(int[] course : courses){
            
            if(course[1]>= course[0]){
                
                if(time+course[0] <= course[1]){
                    pq.offer(course[0]);
                    time += course[0];
                }
                else{
                    if(pq.peek() > course[0]){
                        int removed = pq.poll();
                        time -= removed;
                        pq.offer(course[0]);
                        time += course[0];
                    }
                }
                
            }
            
        }
        
        return pq.size();
        
        
    }
}