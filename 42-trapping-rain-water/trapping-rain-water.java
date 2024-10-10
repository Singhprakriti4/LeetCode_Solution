class Solution {
    public int trap(int[] height) {
        int trapped_rain=0;
        int[] leftmax=new int[height.length];
        int[] rightmax= new int[height.length];

        int start=0;
        for (int i=0;i<height.length;i++){
            if(height[i]>height[start]){
                start=i;
            }
            leftmax[i]=height[start];
        }
        int end=height.length-1;
        for(int j=height.length-1;j>=0;j--){
            if(height[j]>height[end]){
              end=j;
            }
            rightmax[j]=height[end];
        }
    for(int i=0;i<height.length;i++){
      trapped_rain+=Math.min(leftmax[i],rightmax[i])-height[i];
    }
    return trapped_rain;

    }
    // public int maxindex_left(int index,int[] height){
    //    if(index==0){
    //     return height[0];
    //    }
    //    int ans=0;
    //    int max_val=0;
    //    while (ans<=index){
    //     if(height[ans]>max_val){
    //         max_val=height[ans];
    //     }
    //     ans++;
    //    }
    //    return max_val;
    // }
    // public int maxindex_right(int index,int[] height){
    //     if(index==height.length-1){
    //         return height[index];
    //     }
    //     int ans=height.length-1;
    //     int max_val=0;
    //     while(ans>=index){
    //         if(height[ans]>max_val){
    //             max_val=height[ans];
    //         }
    //         ans--;
    //     }
    //     return max_val;
    // }
}