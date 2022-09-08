class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String curStr : arr){
            if( map.containsKey(curStr) ){
                map.put(curStr, map.get(curStr)+1);
            }
            else{
                map.put(curStr, 1);
            }
        }
        
        
        for(String curStr : arr){
            if(map.get(curStr) == 1){
                k--;
                if(k==0) return curStr;
            }
        }
        
        if(k != 0) return "";
        return "";
        
    }
}

// ["d","b","c","b","c","a"]
                         // ^
//      k = 0;
// 1
     
// {
//      d : 1, 
//      b : 2,
//      c : 2,
//      a : 1
//      }



