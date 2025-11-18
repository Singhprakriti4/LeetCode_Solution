class Solution {
    //a grid[r][c] can be visuted in r+c steps only
    // int maxcherries=0;
    public int cherryPickup(int[][] grid) {

        int[][][] dp=new int[grid.length+1][grid.length+1][grid.length+1];
        int n=grid.length;

        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                for(int k=0;k<n+1;k++){
                    if(i==n || j==n || k==n){
                        //initialisation
                        dp[i][j][k]=Integer.MIN_VALUE;
                    }
                }
            }
        }

        for(int r1=n-1;r1>=0;r1--){
            for(int c1=n-1;c1>=0;c1--){
                for(int c2=n-1;c2>=0;c2--){
                    //if thsi is teh last column
                    int r2=r1+c1-c2;

                    if (r2 < 0 || r2 >= n){
                         dp[r1][c1][c2]=Integer.MIN_VALUE;
                         continue;
                    }

                    if(r1==n-1 && r2==n-1 && c1==n-1 && c2==n-1){
                        if(grid[r1][c1]==1){
                            dp[r1][c1][c2]=1;
                        }
                        else{
                            dp[r1][c1][c2]=0;
                        }
                        continue;
                    }

                    if(grid[r1][c1]==-1 || grid[r2][c2]==-1){
                        dp[r1][c1][c2]=Integer.MIN_VALUE;
                        continue;
                    }

                    int opt1=Integer.MIN_VALUE;
                    opt1=Math.max(opt1, dp[r1+1][c1][c2]);
                    opt1=Math.max(opt1, dp[r1+1][c1][c2+1]);
                    opt1=Math.max(opt1, dp[r1][c1+1][c2+1]);
                    opt1=Math.max(opt1, dp[r1][c1+1][c2]);

                    int tobeadded=0;

                    if(r1==r2 && c1==c2 && grid[r1][c1]==1){
                        tobeadded=1;
                    }
                    else{
                        if(grid[r1][c1]==1){
                            tobeadded+=1;
                        }
                        if(grid[r2][c2]==1){
                            tobeadded+=1;
                        }
                    }
                    if(opt1<0){
                        dp[r1][c1][c2]=Integer.MIN_VALUE;
                        continue;
                    }
                    dp[r1][c1][c2]=opt1+tobeadded;
                    
                }
            }
        }
        if(dp[0][0][0]<0) {
            return 0;
        }

        return dp[0][0][0];

        // int[][][] dp=new int[grid.length][grid.length][grid.length];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp.length;j++){
        //             Arrays.fill(dp[i][j],Integer.MAX_VALUE);
        //     }
        // }
        // int res=cherry(grid,grid.length,0,0,0,dp);
        // if(res<0){
        //     return 0;
        // }
        // return res;

    }
    // public int cherry(int[][] grid,int n, int r1, int c1, int c2,
    // int[][][] dp){
    //     int r2=r1+c1-c2;
    //     //base case
    //     if(r1==n-1 && c1==n-1 && r2==n-1 && c2==n-1){
    //         if(grid[r1][c1]==1){
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     if(r1<0 || r1>=n || r2<0 || r2>=n || c1<0 || c1>=n
    //     || c2<0 || c2>=n){
    //         return Integer.MIN_VALUE;
    //     }

    //     if(grid[r1][c1]==-1 || grid[r2][c2]==-1){
    //         return Integer.MIN_VALUE;
    //     }
    //     //calls
    //     if(dp[r1][c1][c2]!=Integer.MAX_VALUE){
    //         return dp[r1][c1][c2];
    //     }
    //     int add =0;
    //     if(r1==r2 && c1==c2){
    //         if(grid[r1][c1]==1){
    //             //pick up the cherry
    //             add=1;
    //         }
    //     }
    //     else{
    //         if(grid[r1][c1]==1){
    //             add+=1;
    //         }
    //         if(grid[r2][c2]==1){
    //             add+=1;
    //         }
    //     }
    //     int opt1=Integer.MIN_VALUE;
    //     //down down
    //     //down right
    //     //right down
    //     //right right

       
    //         opt1=Math.max(opt1,cherry(grid, n, r1+1, c1, c2, dp));
        
       
    //         opt1=Math.max(opt1, cherry(grid, n, r1+1, c1, c2+1, dp));
        
       
    //         opt1=Math.max(opt1, cherry(grid, n, r1, c1+1, c2, dp));
        
       
    //         opt1=Math.max(opt1, cherry(grid, n, r1, c1+1,c2+1, dp));
        
    //     return dp[r1][c1][c2]=add+opt1;
        
    // }
}