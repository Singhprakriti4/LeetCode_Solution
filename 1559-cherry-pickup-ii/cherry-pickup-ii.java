class Solution {
    //at any given point they will be in the same row no matter what
    public int cherryPickup(int[][] grid) {
        int [][][] dp=new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int res=picks(grid, 0, 0, grid[0].length-1, grid[0].length,dp);
        if(res<0){
            return 0;
        }
        return res;
    }
    public int picks(int[][] grid, int r, int c1, int c2, int n, int [][][] dp){

        if(c1<0 || c1>=n || c2<0 || c2>=n ){
            return Integer.MIN_VALUE;
        }
        if(r==grid.length-1){
            //we reached the last row
            if(c1==c2){
                return grid[r][c1];
            }
            if(c1!=c2){
                return grid[r][c1]+grid[r][c2];
            }
        }
        if(dp[r][c1][c2]!=-1){
            return dp[r][c1][c2];
        }
        int tobeadded=grid[r][c1];
        if(c1!=c2){
            tobeadded+=grid[r][c2];
        }
        int option =Integer.MIN_VALUE;
        //left left
        //right right
        //left right
        //right left
        //down down
        //down left
        //down right
        //left down
        //right down
        option=Math.max(option, picks(grid,r+1,c1-1,c2-1,n,dp));
        option=Math.max(option, picks(grid,r+1,c1+1,c2+1,n,dp));
        option=Math.max(option, picks(grid,r+1,c1-1,c2+1,n,dp));
        option=Math.max(option, picks(grid,r+1,c1+1,c2-1,n,dp));
        option=Math.max(option, picks(grid,r+1,c1,c2,n,dp));
        option=Math.max(option, picks(grid,r+1,c1,c2-1,n,dp));
        option=Math.max(option, picks(grid,r+1,c1,c2+1,n,dp));
        option=Math.max(option, picks(grid,r+1,c1-1,c2,n,dp));
        option=Math.max(option, picks(grid,r+1,c1+1,c2,n,dp));

        if(option>=0){
            return dp[r][c1][c2] =tobeadded+option;
        }

        return dp[r][c1][c2] =Integer.MIN_VALUE;
    }
}