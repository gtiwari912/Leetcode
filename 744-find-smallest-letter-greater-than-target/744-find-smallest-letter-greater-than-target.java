class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        HashSet<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        for(char cur: letters){
            if(!set.contains(cur)){
                list.add(cur);
                set.add(cur);
            }
        }
        char[] arr = new char[set.size()];
        for(int i = 0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        return bin(arr, 0, arr.length -1, target);
    }
    
    private char bin(char[] arr, int low, int high, char target){
        if(low>high){
            if(low>=arr.length)
                return arr[0];
            else
                return arr[low];
        }
        
        int mid = (low+high)/2;
        char cur = arr[mid];
        if(cur==target){
            if(mid>=arr.length-1)
                return arr[0];
            else
                return arr[mid+1];
        }
        if(cur<target)
            return bin(arr, mid+1, high, target);
        else
            return bin(arr, low, mid-1, target);
        
    }
}