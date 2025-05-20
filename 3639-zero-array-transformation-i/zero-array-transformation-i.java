class Solution {
    public boolean isZeroArray(int[] nums1, int[][] queries) {
        int[] nums=new int[nums1.length];
        for(int i=0;i<queries.length;i++){
            nums[queries[i][0]]-=1;
            if(queries[i][1]+1<nums.length){
                nums[queries[i][1]+1]+=1;
            }
        }
        
        // System.out.println(nums[0]);
        for(int i=1;i<nums1.length;i++){
            nums[i]+=nums[i-1];
           
        }
         
        
        for(int i=0;i<nums.length;i++){
            nums1[i]+=nums[i];
            //  System.out.print(nums1[i]+" ");
            if(nums1[i]>0) return false;
        }

        return true;

    }
}