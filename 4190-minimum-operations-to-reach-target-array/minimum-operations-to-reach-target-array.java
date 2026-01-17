class Solution {
    public int minOperations(int[] nums, int[] target) {
        HashSet<Integer> set=new HashSet<>();
        //jitne alg numbers mismatched utna jyada ans
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=target[i]){
                set.add(nums[i]);
            }
        }

        return set.size();
        
      // int[] presum=new int[nums.length];
      //   int ans=0;
      //   int i=0;

      //   while(i<nums.length){
      //       if(nums[i]==target[i]){
      //           i++;
      //           continue;
      //       }
      //       int curr=nums[i];
      //       int inc=target[i]-nums[i];
      //       int j=i+1;
      //       while(j<nums.length){
      //           if(nums[j]!=curr){
      //               break;
      //           }
                
      //           target[j]+=inc;
      //           ans+=1;
      //           j++;
      //       }
      //       i=j;
      //   }
      //   return ans;
        
    }
}