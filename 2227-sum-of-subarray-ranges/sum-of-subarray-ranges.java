class Solution {
    //aim is to get: for each index the no of times it is max of the subarray and no of times it is min
    public long subArrayRanges(int[] nums) {

        long ans=0;
        //for it being minimum
        int[] rightmin=new int[nums.length];//next smaller
        int[] leftmin=new int[nums.length];//previous smaller

        Arrays.fill(rightmin,-1);
        Arrays.fill(leftmin, -1);

        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!stk.isEmpty() && nums[i]<nums[stk.peek()]){
                rightmin[stk.pop()]=i;
            }
            stk.push(i);
        }
       
        stk=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!stk.isEmpty() && nums[i]<= nums[stk.peek()]){
                leftmin[stk.pop()]=i;
            }
            stk.push(i);
        }
       
        int[] rightmax=new int[nums.length];
        int[] leftmax=new int[nums.length];
        stk=new Stack<>();
        Arrays.fill(rightmax,-1);
        Arrays.fill(leftmax,-1);

        for(int i=0;i<nums.length;i++){
            while(!stk.isEmpty() && nums[i]>nums[stk.peek()]){
                rightmax[stk.pop()]=i;
            }
            stk.push(i);
        }
       
        stk=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!stk.isEmpty() && nums[i]>=nums[stk.peek()]){
                leftmax[stk.pop()]=i;
            }
            stk.push(i);
        }
       

        //calculate total maximums and minimums
        
        for(int i=0;i<nums.length;i++){

            //minimum
            long left=0;
            long right=0;
            if(rightmin[i]==-1){
                right=nums.length-i-1;
            }
            else{
                right=rightmin[i]-i-1;
            }
            if(leftmin[i]==-1){
                left=i;
            }
            else{
                left=i-leftmin[i]-1;
            }
            //no of subarrays it is minimum* arr[idx] : subtract from ans
            long total=(left+right+(left*right)+1)*nums[i];
            ans-=total;

            //maximum
            if(rightmax[i]==-1){
                right=nums.length-i-1;
            }
            else{
                right=rightmax[i]-i-1;
            }

            if(leftmax[i]==-1){
                left=i;
            }
            else{
                left=i-leftmax[i]-1;
            }
            //no of subarrays it is maxmum * arr[i] : add in answer
            ans+= (left+right+(left*right)+1)*nums[i];
        }

        return ans;

    }
}