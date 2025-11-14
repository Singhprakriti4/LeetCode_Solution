class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat=new int[n][n];
        for(int i=0;i<queries.length;i++){
            int r1=queries[i][0];
            int c1=queries[i][1];
            int r2=queries[i][2];
            int c2=queries[i][3];

            for(int r=r1;r<=r2;r++){
                mat[r][c1]+=1;
                if(c2+1<n){
                mat[r][c2+1]-=1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                mat[i][j]=mat[i][j-1]+mat[i][j];
            }
        }

        return mat;
    }
}