class Solution {
    public boolean checkDistances(String s, int[] distanceArr) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i= 0; i<s.length(); i++){
            char curChar = s.charAt(i);
            if(map.containsKey(curChar)){
                int prevIndex = map.get(curChar);
                int curIndex = i;
                int distance = curIndex - prevIndex - 1;
                int idealDistance = distanceArr[curChar - 'a'];
                if(distance != idealDistance) return false;
            }
            else{
                map.put(curChar, i);
            }
        }
        
        return true;
    }
}


// [1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]

     // |
// abaccb
// 012345
//    {
//        a:0,
//        b:1
//    }

// prevIndex = 0;
// curIndex = 2;
// int dis = curIndex - prevIndex - 1;
// int index = curChar - 'a';
// a=65; b=66; c=67....z=xx;
// index = b - 'a'
// int idealDis = 
