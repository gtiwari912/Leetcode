class Solution {
    public void merge(int[] num1, int m, int[] num2, int n) {
        int tail1 = m-1;
        int tail2 = n-1;
        int finished = m+n-1;
        while(tail1>=0 && tail2>=0){
            num1[finished--] = (num1[tail1]>num2[tail2])? num1[tail1--]:num2[tail2--];
        }
        while(tail2 >= 0)
            num1[finished--] = num2[tail2--]; 
    }
}