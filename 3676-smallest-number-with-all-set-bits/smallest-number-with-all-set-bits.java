class Solution {
    //1, 3, 7, 15, 31, .......(x=x*2+1)
    public int smallestNumber(int n) {
        int x=1;
        while(x<n){
            x=x*2+1;
        }
        return x;
    }
}