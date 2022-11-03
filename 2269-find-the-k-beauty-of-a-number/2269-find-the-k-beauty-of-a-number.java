class Solution {
    public int divisorSubstrings(int a, int k) {
        String num = a+"";
        int  ans = 0;
        int n = num.length();
        for(int i = 0; i<=n-k; i++){
            String window = num.substring(i, i + k);
            // System.out.println("Cur Window is: "+window);
            int noOnWindow =  Integer.parseInt(window);  //"333" -> 333
            if(noOnWindow != 0 && a % noOnWindow == 0) ans++;
        }
        
        return ans;
        
    }
}




// 240 ........... 24









// str = "L I O N";
//        0 1 2 3
// str = str.substring(0,3);