class Solution {
    public int maxProfit(int[] prices) {

        HashMap<String,Integer> map=new HashMap<>(); 

        return profit(prices, 0, 2, false, map);

    }
    public int profit(int[] prices, int idx, int chances, boolean bought
    , HashMap<String,Integer> map){

        if(chances==0){
            return 0;
        }
        if(idx==prices.length){
            return 0;
        }

        String key=idx+":"+chances+":"+bought;
        if(map.containsKey(key)){
            return map.get(key);
        }

        
        if(bought==false){
            //not yet bought anything
            //options: buy curr stock / donot buy curr stock
            int opt1=-prices[idx]+profit(prices, idx+1, chances, true, map);
            int opt2=profit(prices, idx+1, chances, bought, map);

            map.put(key,Math.max(opt1,opt2));
            return map.get(key);
        }
        
        //already bought
        int opt1=prices[idx]+ profit(prices, idx+1, chances-1, false, map);
        int opt2=profit(prices, idx+1, chances, bought, map);//did not sell

        map.put(key,Math.max(opt1, opt2));
        return map.get(key);
        
    }
}