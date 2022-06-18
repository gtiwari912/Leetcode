// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
 static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
   {
       // add your code here
       HashSet <Integer> hs = new HashSet<>(A);
       ArrayList <Integer> new_A = new ArrayList<>(hs);
       Collections.sort(new_A);
       ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
       combination(ans,new_A,B,new ArrayList<>(),0);
       return ans;
   }
   
   public static void combination(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> A, int B, List<Integer> AL, int index){
   if(index == A.size()){
       if(B==0){
           ans.add(new ArrayList(AL));
       }
       return;
   }
   
   if(A.get(index)<=B){
       AL.add(A.get(index));
       combination(ans,A,B-A.get(index),AL,index);
       AL.remove(AL.size()-1);
   }
   combination(ans,A,B,AL,index+1);
   }
}