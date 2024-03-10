class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int current=Integer.MIN_VALUE;
        if(nums[0]<0){
         current=nums[0]*nums[1]*nums[nums.length-1];
        }
        int current2=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        if(current>current2){
            return current;
        }
        return current2;
    }
}