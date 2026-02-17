class Solution {
    // int ans;
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int result=nums.length-1;
        //argest dub ararys satisfynig this condition
        for(int i=0;i<nums.length;i++){
            int len=binary(nums,i, k);
            // System.out.println(len);
            if(len!=-1){
                result=Math.min(result, nums.length-len);
            }
        }
        return result;
    }
    public int binary(int[] nums, int i, int k){
        int len=-1;//max possiblity
        int s=i;
        int e=nums.length-1;
        while(s<=e && s<nums.length){
            // System.out.println(s+" "+e);
            int mid=s+(e-s)/2;
            // System.out.println(nums[mid]);
            // System.out.println(1L*k*nums[i]);

            if(nums[mid]<=1L*k*nums[i]){
                len=mid-i+1;
                // System.out.println(len+" :"+s+" "+e);
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return len;
    }
}