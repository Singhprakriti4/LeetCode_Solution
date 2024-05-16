class Solution {
    public int maxArea(int[] height) {
        int max=0,i=0,j=height.length-1,current=0;
        while(i<j){
            current=(j-i)*(Math.min(height[i],height[j]));
            if(max<current){
                max=current;
            }
           if(height[i]<height[j]){
            i++;
           }
           else{
            j--;
           }
        }
        return max;
    }
}