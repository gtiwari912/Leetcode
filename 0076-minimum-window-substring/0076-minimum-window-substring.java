class Solution {
        public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }

        int ptrOne = 0;
        int ptrTwo = 0;
        int minLength = Integer.MAX_VALUE;
        String minString = "";
        Map<Character, Integer> sMap = new HashMap<>();
        while(ptrTwo<=m && ptrOne<m){
            if(!checkEquality(sMap, tMap) && ptrTwo!=m){
                // System.out.println("One: "+ptrOne + " "+ptrTwo);
                char curChar = s.charAt(ptrTwo);
                ptrTwo++;
                sMap.put(curChar, sMap.getOrDefault(curChar, 0)+1);
                continue;
            }
            else if(checkEquality(sMap, tMap)){
                // System.out.println("Two: "+ptrOne + " "+ptrTwo);
                String subStr = s.substring(ptrOne, ptrTwo);
                int subStrLength = subStr.length();
                if(subStrLength<minLength){
                    minLength = subStrLength;
                    minString = subStr;
                }
                char curChar = s.charAt(ptrOne++);
                if(sMap.getOrDefault(curChar, 0)<=1)
                    sMap.remove(curChar);
                else
                    sMap.put(curChar, sMap.get(curChar) - 1);
            }
            else{
                ptrOne++;
            }
        }

        return minString;
    }

    private static boolean checkEquality(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        for(char key: tMap.keySet()){
            if(sMap.getOrDefault(key, 0) < tMap.get(key))
                return false;
        }

        return true;
    }
}