class Solution {
    public int findNumberOfLIS(int[] nums) {

        int[] len=new int[nums.length];
        int res=0;
        int[] count=new int[nums.length];
        
        for(int i=0;i<len.length;i++){

            len[i]=1;
            count[i]=1;
            res=Math.max(res,len[i]);
            //iterate on prev ones

            for(int j=i-1;j>=0;j--){
                // if(nums[i]>nums[j]){
                //     //if already existing
                //     int curr=1+list[j];
                //     if(list[i]==curr){
                //         //increasing the count
                //         numofmax[i]=numofmax[i]+numofmax[j];
                //     }
                //     else if(list[i]<curr ){
                //         numofmax[i]=numofmax[j];
                //         list[i]=Math.max(list[i],curr);
                //     }
                if (nums[i] > nums[j]) {
                    int currLen = len[j] + 1;

                    if (currLen > len[i]) {
                        len[i] = currLen;
                        count[i] = count[j]; // reset count
                    } else if (currLen == len[i]) {
                        count[i] += count[j]; // add count
                    }
                }
                
                res=Math.max(res,len[i]);
            }

            
        }
        // System.out.println(res);
        int countans=0;

        for(int i=0;i<len.length;i++){
            // System.out.println(list[i]);
            if(len[i]==res) countans+=count[i];
        }
        return countans;
    }
}