class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        maxheap.addAll(map.keySet());

        int[] ans=new int[k];
        int i=0;

        while(k!=0){
            ans[i++]=maxheap.poll();
            k--;
        }

        return ans;
    }
}