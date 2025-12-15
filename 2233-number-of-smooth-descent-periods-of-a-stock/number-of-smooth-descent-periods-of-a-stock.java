class Solution {
    public long getDescentPeriods(int[] prices) {
        int prev=0;
        int curr=1;
        long result=1;
        while(curr<prices.length){
            if(prices[curr]==prices[curr-1]-1){
                //prev stays at its place
                // result+=curr-prev+1;
            }
            else{
                prev=curr;
            }
            result+=curr-prev+1;
            curr++;
        }
        return result;
    }
}