class Solution {
    //at any given point they will be in the same row no matter what
    public int cherryPickup(int[][] grid) {
        int[][][] dp=new int[grid.length][grid[0].length+2][grid[0].length+2];
        //initialisation
        for(int r=0;r<dp.length;r++){
            for(int c1=0;c1<dp[0].length;c1++){
                for(int c2=0;c2<dp[0][0].length;c2++){
                    if(c1==0 || c2==0 || c1==grid[0].length+1 || c2==grid[0].length+1){
                        dp[r][c1][c2]=Integer.MIN_VALUE;
                        continue;
                    }
                    if(r==grid.length-1){
                        dp[r][c1][c2]=grid[r][c1-1];
                        if(c1!=c2){
                            dp[r][c1][c2]+=grid[r][c2-1];
                        }
                    }
                }
            }
        }
        for(int r=grid.length-2;r>=0;r--){
            for(int c1=1;c1<=grid[0].length;c1++){
                for(int c2=1;c2<=grid[0].length;c2++){

                    int tobeadded=grid[r][c1-1];
                    if(c2!=c1){
                        tobeadded+=grid[r][c2-1];
                    }
                    int option=Integer.MIN_VALUE;
                    option=Math.max(option, dp[r+1][c1-1][c2-1]);
                    option=Math.max(option, dp[r+1][c1-1][c2+1]);
                    option=Math.max(option, dp[r+1][c1+1][c2-1]);
                    option=Math.max(option, dp[r+1][c1+1][c2+1]);
                    option=Math.max(option, dp[r+1][c1][c2]);
                    option=Math.max(option, dp[r+1][c1][c2-1]);
                    option=Math.max(option, dp[r+1][c1-1][c2]);
                    option=Math.max(option, dp[r+1][c1][c2+1]);
                    option=Math.max(option, dp[r+1][c1+1][c2]);
                    
                    if(option>=0){
                        dp[r][c1][c2]=option+tobeadded;
                        continue;
                    }
                    dp[r][c1][c2]=Integer.MIN_VALUE;
                }
            }
        }

        if(dp[0][1][grid[0].length]<0){
            return 0;
        }
        return dp[0][1][grid[0].length];

        // int [][][] dp=new int[grid.length][grid[0].length][grid[0].length];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         Arrays.fill(dp[i][j],-1);
        //     }
        // }
        // int res=picks(grid, 0, 0, grid[0].length-1, grid[0].length,dp);
        // if(res<0){
        //     return 0;
        // }
        // return res;
    }
    // public int picks(int[][] grid, int r, int c1, int c2, int n, int [][][] dp){

    //     if(c1<0 || c1>=n || c2<0 || c2>=n ){
    //         return Integer.MIN_VALUE;
    //     }
    //     if(r==grid.length-1){
    //         //we reached the last row
    //         if(c1==c2){
    //             return grid[r][c1];
    //         }
    //         if(c1!=c2){
    //             return grid[r][c1]+grid[r][c2];
    //         }
    //     }
    //     if(dp[r][c1][c2]!=-1){
    //         return dp[r][c1][c2];
    //     }
    //     int tobeadded=grid[r][c1];
    //     if(c1!=c2){
    //         tobeadded+=grid[r][c2];
    //     }
    //     int option =Integer.MIN_VALUE;
    //     //left left
    //     //right right
    //     //left right
    //     //right left
    //     //down down
    //     //down left
    //     //down right
    //     //left down
    //     //right down
    //     option=Math.max(option, picks(grid,r+1,c1-1,c2-1,n,dp));
    //     option=Math.max(option, picks(grid,r+1,c1+1,c2+1,n,dp));
    //     option=Math.max(option, picks(grid,r+1,c1-1,c2+1,n,dp));
    //     option=Math.max(option, picks(grid,r+1,c1+1,c2-1,n,dp));
    //     option=Math.max(option, picks(grid,r+1,c1,c2,n,dp));
    //     option=Math.max(option, picks(grid,r+1,c1,c2-1,n,dp));
    //     option=Math.max(option, picks(grid,r+1,c1,c2+1,n,dp));
    //     option=Math.max(option, picks(grid,r+1,c1-1,c2,n,dp));
    //     option=Math.max(option, picks(grid,r+1,c1+1,c2,n,dp));

    //     if(option>=0){
    //         return dp[r][c1][c2] =tobeadded+option;
    //     }

    //     return dp[r][c1][c2] =Integer.MIN_VALUE;
    // }
}