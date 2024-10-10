class Solution {
    public int trap(int[] height) {
        int ans=0;
        int start=0;
        int end=height.length-1;
        int leftmax=0;
        int rightmax=0;
        while(start<end){
            if(height[start]<height[end]){
                if(height[start]>leftmax){
                   leftmax=height[start]; 
                }
                else{
                   ans+=leftmax-height[start];
                }
                start++;
            }
            else{
                if(height[end]>rightmax){
                    rightmax=height[end];
                }
                else{
                   ans+=rightmax-height[end];
                }
                end--;
            }
        }
        return ans;
    }
}