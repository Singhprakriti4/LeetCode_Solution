class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int currsum=0;
        int ans=0;

        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
            if(currsum==goal){
                ans+=1;
                if(map.containsKey(0)){
                    ans+=map.get(0);
                }
            }

            if(currsum>goal && map.containsKey(currsum-goal)){
               ans+=map.get(currsum-goal);
            }

            map.put(currsum, map.getOrDefault(currsum,0)+1);
        }
        return ans;
    }
}