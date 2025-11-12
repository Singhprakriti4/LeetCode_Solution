class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] lis=new int[nums.length];
        
        int res=0;
        for(int i=0;i<nums.length;i++){
            lis[i]=1;
            res=Math.max(res, lis[i]);

            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    //possible length
                    lis[i]=Math.max(lis[i],lis[j]+1);
                    res=Math.max(res, lis[i]);
                }
            }
        }

        int prev=-1;
        List<Integer> ans=new ArrayList<>();
        for(int i=lis.length-1;i>=0;i--){
            if(lis[i]==res && (prev==-1 || prev%nums[i]==0)){
                prev=nums[i];
                res--;
                ans.add(0,nums[i]);
            }
        }
        return ans;
    }
}