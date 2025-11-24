class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {

        List<Boolean> ans=new ArrayList<>();
        int prevnum=0;
        for(int i=0;i<nums.length;i++){
            int curr=prevnum*2;
            if(nums[i]==1){
                curr+=1;
            }
            if(curr%5==0){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
            // System.out.println(curr);
            prevnum=curr%5;
        }
        return ans;
    }
}