class Solution {
    public int countNegatives(int[][] grid) {
    int ans=-1;
     int c=0;
     for(int r=0;r<grid.length;r++){
         ans=-1;
    
    int s=0;
    int e=grid[0].length-1;
    while(s<=e){
        int mid=s+(e-s)/2;
        if(grid[r][mid]>=0){
            s=mid+1;
        }
        else {
           ans=mid;
           e=mid-1; 
           
        }
    }
    if(ans!=-1){
    c+=grid[0].length-ans;}
    
     
     }
     return c;
    }
}