class Solution {
    // min(h2,h1)*i2-i1
    public int maxArea(int[] height) {
        int i=0; 
        int j=height.length-1;
        int ans=0;

        while(i<j){
            int curr=Math.min(height[i],height[j])*(j-i);
            ans=Math.max(ans, curr);
            if(height[i]<height[j]){
                i++;
                //we try to remove the one with lesser height
            }
            else{
                j--;
            }
        }

        return ans;
    }
}