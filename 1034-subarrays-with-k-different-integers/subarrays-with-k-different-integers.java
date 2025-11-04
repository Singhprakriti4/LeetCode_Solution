class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        if(k==1)
        return helper(nums,k);

        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int[] nums, int k){

        int ans=0;
        int left=0;

        Map<Integer, Integer> map=new HashMap<>();// nums[i], frequency ( in the curr window)

        for(int right=0; right< nums.length; right++){

            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);

            //if the no of distinct nums are >k
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);

                left++;
            }

            ans+=right-left+1;
        }
        return ans;
    }
}