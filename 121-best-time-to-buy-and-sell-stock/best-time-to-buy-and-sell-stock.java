class Solution {
    public int maxProfit(int[] prices) {
        int minbuy=prices[0];//minimum buying price till date
        int profit=0;//profit till date

        for(int i=0;i<prices.length;i++){
            //if the curr value is the smallest buying till now
            minbuy=Math.min(minbuy,prices[i]);
            if(prices[i]>minbuy){
                profit=Math.max(profit, prices[i]-minbuy);
            }
        }

        return profit;
    }
}