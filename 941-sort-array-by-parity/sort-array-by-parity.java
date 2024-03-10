class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
           if(nums[left]%2!=0 && nums[right]%2==0){
               swap(left,right,nums);
               left++;
               right--;
           }
           else if(nums[left]%2==0 && nums[right]%2==0){
               left++;
           }
           else if(nums[left]%2!=0  && nums[right]%2!=0){
               right--;
           }
           else{
               left++;
               right--;
           }
           
        }
        return nums;
    }
    public void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}