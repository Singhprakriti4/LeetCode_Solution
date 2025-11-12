class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        //dp: starting from the index i,j what is the maximum length increasing subsequence
        int[][] dp=new int[matrix.length][matrix[0].length];//0 (initialised already as minimum value is 1)
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];
        
        int m=matrix.length;
        int n=matrix[0].length;
        int count=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count=Math.max(count, dfs(matrix,i,j,m,n,visited,dp));
            }
        }

        return count;

    }
    public int dfs(int[][] matrix, int r, int c,int m , int n, 
    boolean[][] visited, int[][] dp){
        //starting from matrix[r][c] explore in such a way that
        //the next elemnt is greater than curr and take the maxinum of all 4 directions
        if(r<0 || r>=m || c<0 || c>=n){
            return 0;
        }

        if(dp[r][c]!=0){
            return dp[r][c];
        }

        int count=1;

        int[] row={1,0,-1,0};
        int[] col={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nextr=r+row[i];
            int nextc=c+col[i];

            if(nextr>=0 && nextr<m && nextc>=0 && nextc<n){
                //valid path
                if(matrix[nextr][nextc]>matrix[r][c] && !visited[nextr][nextc]){
                    visited[nextr][nextc]=true;
                    count=Math.max(count,1+dfs(matrix,nextr,nextc,m,n,visited,dp));
                    visited[nextr][nextc]=false;
                }
            }
        }

        return dp[r][c]=count;
        
    }

}