class Solution {
    public int largestPerimeter(int[] nums) {
        int largest=0;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>1;i--){
            for(int j=i-1;j>0;j--){
                if(nums[j]<nums[i]/2){
                    break;
                }
                else{
                for(int k=i-2;k>=0;k--){
                    if(nums[k]+nums[j]>nums[i]){
                        int current=nums[i]+nums[j]+nums[k];
                        if(current>largest){
                            largest=current;
                        }
                    } 
                    else{
                        break;
                    }
                }
                }
            }
            if(largest !=0){
                return largest;
            }
        }
        return largest;
    }
}