// NEXT SMALLER ELEMENT;
class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i<n; i++){
            int ele = prices[i];
            while(!stack.isEmpty() && stack.peek()[0]>=ele){
                map.put(stack.pop()[1], ele );
            }
            int[] arr = {ele, i};
            stack.add(arr);
        }
        
        for(int i= 0; i<n; i++)
        {
            prices[i] = map.containsKey(i)? prices[i]-map.get(i) : prices[i];
        }
        
        return prices;
    }
}