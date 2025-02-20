class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]=='1'){
                ans+=1;
                dfs(grid,i,j);
               }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid,int row, int col){
        
       grid[row][col]='0';

       int[] r={1,-1,0,0};
       int[] c={0,0,1,-1};

       for(int i=0;i<4;i++){
        int newr=row+r[i];
        int newc=col+c[i];
        if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length && grid[newr][newc]=='1'){
           dfs(grid,newr,newc);
        }

       }
    }
}