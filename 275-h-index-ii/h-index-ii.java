class Solution {
    public int hIndex(int[] citations) {
        int start=0;
        int end=citations.length-1;
        int ans=0;
        //max index jiske us index se zyada citations ho
        while(start<=end){
            int mid=start+(end-start)/2;
            int curr=citations.length-mid;
            if(citations[mid]>=curr){
                ans=curr;
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return ans;
    }
}