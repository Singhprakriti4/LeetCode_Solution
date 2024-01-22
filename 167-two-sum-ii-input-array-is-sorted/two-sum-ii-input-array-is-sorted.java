class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int start=0;
     int end=numbers.length-1;
     int[] ans=new int[2];
     while(start<end){
         int val=numbers[start]+numbers[end];
         if(val==target){
             ans[0]=start+1;
             ans[1]=end+1;
             return ans;
         }
         else if(val>target){
             end--;
         }
         else
         {
             start++;
         }
     }
     return new int[]{-1,-1};
    }
}