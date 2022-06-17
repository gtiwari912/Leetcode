// { Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}


// } Driver Code Ends


class GfG {
   int minEle = -1;
   Stack<Integer> s = new Stack<>();
   Stack<Integer> sMin = new Stack<>();

 

   /*returns min element from stack*/
   int getMin() {
       if (s.size()==0) return -1;
       return minEle;
   }
   
   /*returns popped element from stack*/
   int pop() {
       if (s.size()==0) return -1;
       int temp = s.pop();
       if (temp==minEle && sMin.size() > 0) minEle = sMin.pop();
       return temp;
   }

   /*push element x into the stack*/
   void push(int x) {
       if (s.size() == 0) minEle = x;
       else if (minEle>x) {
           sMin.push(minEle);
           minEle = x;
       }
       s.push(x);
   } 
}
