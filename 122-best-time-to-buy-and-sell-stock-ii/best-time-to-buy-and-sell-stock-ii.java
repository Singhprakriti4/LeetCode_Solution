class Solution {

    public int maxProfit(int[] prices) {

        int profit=0;
        int buy=prices[0];
        
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[i-1]){
                //time to sell the previous stock and buy the new stock
                profit+=(prices[i-1]-buy);
                buy=prices[i];
            }
        }

        if(buy!=prices[prices.length-1]){
            //increasing array
            profit+=prices[prices.length-1]-buy;
        }
        return profit;
    }

}