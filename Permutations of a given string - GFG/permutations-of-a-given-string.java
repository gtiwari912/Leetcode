// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        Set<String> set = new TreeSet<String>();
        
        permute(S, set, 0);
        
        return new ArrayList<String>(set);
    }
    
    
    static void permute(String S, Set<String> set, int i) {
        if (i == S.length() - 1) 
        {
            set.add(S);
        }
        else 
        {
            char charArray[] = S.toCharArray();
            for (int j = i; j < S.length(); j++) 
            {
                charArray = swap(charArray, i, j);
                permute(new String(charArray), set, i + 1);
                charArray = swap(charArray, i, j);
            }    
        }
    }
    
    static char[] swap(char[] charArray, int i, int j)
    {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        
        return charArray;
    }
}