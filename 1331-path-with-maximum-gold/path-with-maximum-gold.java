class Solution {
    public int getMaximumGold(int[][] grid) {
      int result=0;
        for(int i=0;i<grid.length;i++ ){
            for(int j=0;j<grid[0].length;j++){
                int cell_result=gold(grid,i,j);
               
                if(cell_result>result){
                    result=cell_result;
                }
            }
        }
        return result;


    }
    public int gold(int[][] grid,int row,int col){
        
     
     if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0){
        return 0;
     }
     int ans=0;
    
        ans=grid[row][col];
     
     int value= grid[row][col];
     grid[row][col]=0;

     int above_ans= ans+gold(grid,row-1,col);
     int left_ans=ans+gold(grid,row,col-1);
     int right_ans=ans+gold(grid,row,col+1);
     int below_ans=ans+gold(grid,row+1,col);

     grid[row][col]=value;

     int call_ans=  Math.max(Math.max( Math.max(above_ans,left_ans),right_ans),below_ans);
     

     return call_ans;

     

    }
}