// { Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public static int[] leftSide(int arr[],int n){
        Stack<Integer> st = new Stack<>();
        int left[] = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = -1;
            }
            else{
                left[i] = st.peek();
            }
            st.push(i);
        }
        return left;
    }
    public static int[] rightSide(int arr[],int n){
        Stack<Integer> st = new Stack<>();
        int right[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = n;
            }
            else{
                right[i] = st.peek();
            }
            st.push(i);
        }
        return right;
    }
    public static int maxHistogram(int arr[],int n){
        int left[] = leftSide(arr,n);
        int right[] = rightSide(arr,n);
        int max = 0;
        for(int i=0;i<n;i++){
            int temp = arr[i]*(right[i]-left[i]-1);
            max = Math.max(max,temp);
        }
        return max;
    }
    public int maxArea(int arr[][], int n, int m) {
        // add code here.
        int currrow[] = arr[0];
        int maxans = maxHistogram(currrow,m);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    currrow[j] = currrow[j]+1;
                }
                else{
                    currrow[j] = 0;
                }
            }
            int currans = maxHistogram(currrow,m);
            maxans = Math.max(maxans,currans);
        }
        return maxans;
    }
}