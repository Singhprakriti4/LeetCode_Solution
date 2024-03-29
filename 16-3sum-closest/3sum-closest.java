class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //sorting the array
      Arrays.sort(nums);
      int current;
        int close=nums[0]+nums[1]+nums[2];

        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
               int left=i+1;
               int right=nums.length-1;
               
               while(left<right){
                   current=nums[left]+nums[right]+nums[i];
                   if(nums[left]+nums[right]+nums[i]==target){
                       return current;
                   }
                  else if(Math.abs(close-target)>Math.abs(current-target)){
                      close=current;
                  }
                  else if(current<target){
                          left++;
                  }
                  else{
                      right--;
                  }
                   
               }
            }
        }
         return close;

    }
   
}