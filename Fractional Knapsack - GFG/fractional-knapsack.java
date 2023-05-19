//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends




/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    class AdvItem extends Item implements Comparable<AdvItem>{
        float profitRatio = 0f;
        AdvItem(int value, int weight){
            super(value, weight);
            profitRatio = (float)value/weight;
        }
        
        @Override
        public int compareTo(AdvItem other){
            if(this.profitRatio>other.profitRatio){
                return -1;
            }
            if(this.profitRatio<other.profitRatio){
                return 1;
            }
            return 0;
        }
        
        @Override
        public String toString(){
            return "V:"+this.value + " W:"+this.weight;
        }
    }
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        AdvItem[] items = new AdvItem[n];
        for(int i = 0; i<n; i++){
            items[i] = new AdvItem(arr[i].value, arr[i].weight);
        }
        
        Arrays.sort(items);
        // Arrays.toString(items);
        double profit = 0;
        for(int i = 0; i<n; i++){
            AdvItem curItem = items[i];
            if(W>=curItem.weight){
                W = W - curItem.weight;
                profit += curItem.value;
            }
            else if(W>0){
                profit = profit + ((double)W/curItem.weight)*curItem.value;
                W = W - W;
            }
            else{
                break;
            }
        }
        
        return profit;
    }
}