class Solution {
    public int searchInsert(int[] arr, int target) {
        if(target<arr[0]){
            return 0;
        }
        if(target>arr[arr.length-1]){
            return arr.length;
        }
        int ceil=0;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end - start)/2;

            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                ceil=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ceil;
    }
}