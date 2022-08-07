class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int ele = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[0]<ele){
                map.put(stack.pop()[1], i);
            }
            int[] arr = {ele, i};
            stack.add(arr);
        }
        
        for(int i = 0; i<n; i++){
            temperatures[i] = map.containsKey(i)?map.get(i) - i: 0;
        }
        
        return temperatures;
    }
}