class Solution {
    public int search(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;

        while(s<=e){

            int m=s+(e-s)/2;
            System.out.println(m);
            if(nums[m]==target){
                return m;
            }
            if(nums[m]>nums[e]){
                //left wala side sorted hai(ascending order)
                if(target>=nums[s] && target<nums[m]){
                    //ans hmara sorted wale part me hi hai
                    e=m-1;
                }
                else{
                    //sorted wale part me ans nahi hai to eliminate it
                    s=m+1;
                    // System.out.o
                }
            }
            else{
                //right wala part sorted hai
                if(nums[m]<target && target<=nums[e]){
                    s=m+1;
                }
                else{
                    e=m-1;
                    System.out.println("hey");
                }
            }
        }
        return -1;
    }
}