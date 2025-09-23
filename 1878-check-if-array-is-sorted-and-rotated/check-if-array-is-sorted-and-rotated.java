class Solution {
    public boolean check(int[] nums) {
        int flux=0;
        int ref=nums[nums.length-1];
        for(int i=nums.length-1;i>=0;i--){
            if(i==0){
                if(flux>1) return false;
                if(nums[i]<ref && flux>0) return false;
            }
            else{
             if(flux>1){
                System.out.println("1");
                return false;
            }
            if(nums[i]<nums[i-1]){

                flux+=1;
            }
            else if(nums[i]>=nums[i-1]){
                if(flux>0){
                    if(nums[i]<ref){ 
                    System.out.println("2");

                        return false;
                    }
                }
            }
            }
        }

        return true;
    }
}