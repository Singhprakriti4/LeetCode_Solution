class Solution {
    public int maxProfit(int k, int[] prices) {
        HashMap<String,Integer> map=new HashMap<>();

        return profit(prices, 0, k, false, map);
    }
    public int profit(int[] prices, int idx, int chances,boolean bought,
    HashMap<String,Integer> map){

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
        if(!bought){
            int buy=-prices[idx]+profit(prices, idx+1, chances, true, map);
            int notbuy=profit(prices, idx+1, chances, false, map);

            map.put(key, Math.max(buy,notbuy));
            return map.get(key);
        }

        int sell=prices[idx]+profit(prices, idx+1, chances-1, false, map);
        int notsell=profit(prices, idx+1, chances, true, map);

        map.put(key, Math.max(sell, notsell));
        return map.get(key);
    }
}