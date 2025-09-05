class Solution {
    public int numEnclaves(int[][] grid) {
        int row=0;
        for(int i=0;i<grid[0].length;i++){
            if(grid[row][i]==1){
                dfs(grid,row,i);
            }
        }

        if(grid.length>1){
            row=grid.length-1;
            for(int i=0;i<grid[0].length;i++){
            if(grid[row][i]==1){
                dfs(grid,row,i);
            }
        }
        }

        int col=0;
        for(int i=0;i<grid.length;i++ ){
            if(grid[i][col]==1){
                dfs(grid,i,col);
            }
        }

        if(grid[0].length>1){
            col=grid[0].length-1;
             for(int i=0;i<grid.length;i++ ){
            if(grid[i][col]==1){
                dfs(grid,i,col);
            }
        }
        }

        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans+=1;
                }
            }
        }


         return ans;
    }
    public void dfs(int[][] grid, int r, int c){
        grid[r][c]=0;

        int[] val1={0,0,1,-1};
        int[] val2={1,-1,0,0};

        for(int i=0;i<4;i++){
            int row=r+val1[i];
            int col=c+val2[i];

            if(row>=0 && col>=0 && row<grid.length && col<grid[0].length
            && grid[row][col]==1){
                dfs(grid,row,col);
            }
        }
    }
}