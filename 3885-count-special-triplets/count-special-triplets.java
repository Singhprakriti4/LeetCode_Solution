class Solution {
    public int specialTriplets(int[] nums) {

       HashMap<Integer, Integer> fwd=new HashMap<>();
       HashMap<Integer, Integer> prev=new HashMap<>();
       long ans=0;
       int mod=1000000007;

       for(int i=1;i<nums.length;i++){
        fwd.put(nums[i], fwd.getOrDefault(nums[i], 0)+1);
       }

       prev.put(nums[0], 1);

       for(int i=1;i<nums.length-1;i++){
        //remove current value from fwd one
        fwd.put(nums[i], fwd.get(nums[i])-1);
        if(fwd.get(nums[i])==0){
            fwd.remove(nums[i]);
        }

        int val=nums[i]*2;

        if(fwd.containsKey(val) && prev.containsKey(val)){
            long t=(1L*fwd.get(val)*prev.get(val))%mod;
            ans=(ans+t)%mod;
        }

        //add current key in the prev one
        prev.put(nums[i], prev.getOrDefault(nums[i],0)+1);
       }

       return (int)ans;
    }
}