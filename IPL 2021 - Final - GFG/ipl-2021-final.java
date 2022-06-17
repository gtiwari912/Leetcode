// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
        Stack<Integer> ss=new Stack<Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        int ans=0;  //store answer
        
        for(int i=0;i<S.length();i++){
            if(!ss.isEmpty() && S.charAt(ss.peek())=='(' && S.charAt(i)==')'){
               al.add(ss.peek());
               al.add(i);
               ss.pop();
               continue;
            }
            ss.push(i);
        }
        
        Collections.sort(al);
        
        int it=1; //Iterator
        for(int i=1;i<al.size();i++){
            if(al.get(i)==al.get(i-1)+1){
                it++;
                ans=Math.max(ans,it);
                continue;
            }
            it=1;
        }
        
        return ans;
    }
}