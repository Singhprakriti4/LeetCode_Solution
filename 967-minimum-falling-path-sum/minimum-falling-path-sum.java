class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] dp=new int[m][n+2];
        for(int i=0;i<m;i++){
            dp[i][0]=Integer.MAX_VALUE;
            dp[i][n+1]=Integer.MAX_VALUE;
        }

        //column same;
        //row is reduced by 1

        for(int i=1;i<=n;i++){
            dp[m-1][i]=matrix[m-1][i-1];
        }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n+2;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        for(int row=m-2;row>=0;row--){
            for(int col=1;col<=n;col++){
                dp[row][col]=Math.min(dp[row+1][col],Math.min(dp[row+1][col+1],dp[row+1][col-1]))+matrix[row][col-1];
            }
        }

        int result=Integer.MAX_VALUE;

        for(int i=1;i<=n;i++){
            result=Math.min(result, dp[0][i]);
        }

        return result;
    }
}