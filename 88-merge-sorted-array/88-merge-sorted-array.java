class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int len = arr1.length;
        int tail = m-1;
        int tail2 = len -1;
        while(tail>=0){
            arr1[tail2--] = arr1[tail--];
        }
        tail2++;
        int start1 = tail2;
        int start2 = 0;
        int iter = 0;
        while(start1<len && start2<n){
            int a = arr1[start1];
            int b = arr2[start2];
            if(a<b){
                arr1[iter++] = a;
                start1++;
            }
            else{
                arr1[iter++] = b;
                start2++;
            }
        }
        
        while(start2<n){
            arr1[iter++] = arr2[start2++]; 
        }
    }
}