// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.rremove(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    String rremove(String s) {
        int count=1;
        StringBuffer str=new StringBuffer(s);
        return recursive(str,count);
    }
    String recursive(StringBuffer s,int count)
    { 
        
        if(s.length()==0)
        {
            return "";
        }
        if(count>0)
        { 
          count=0;
          char ch=' ';
          for(int i=0;i<s.length()-1;)
          {
              if(s.charAt(i)==s.charAt(i+1)||ch==s.charAt(i))
              {
                  count++;
                  ch=s.charAt(i);
                  s.delete(i,i+1);
              }
              else{
                  i++;
                  ch=' ';
              }
             
          }
          if(s.charAt(s.length()-1)==ch)
          {
              s.delete(s.length()-1,s.length());
          }
          return recursive(s,count);
        }
        else
        {
           String p=String.valueOf(s);
           return p;
        }
    }
}