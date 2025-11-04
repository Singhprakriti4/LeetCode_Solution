class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        if(k==1)
        return helper(nums,k);

        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int[] nums, int k){

        int ans=0;
        int left=0;
        int right=0;

        Map<Integer, Integer> map=new HashMap<>();// nums[i], frequency ( in the curr window)

        while(right<nums.length){
            //add the curr new value in the map
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);

            if(map.size()<=k){
                //condition met
                ans+=right-left+1;// no of subararys in the current window ending at right that have distinck elements <=k
                right++;
            }
            else{
                //shrink the window to meet the condition
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }

                left++;
                // if(map.containsKey(nums[right]))
                map.put(nums[right], map.get(nums[right])-1);//since right value will be added by default in the next iteration
            }
        }
        return ans;
    }
}