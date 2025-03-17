class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int num=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
           if(nums[i]==num){
            count++;
           }
           else{
            if(count%2!=0){
                return false;
            }
            num=nums[i];
            count=1;
           }
        }
        return true;
    }
}