class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] mat=new int[n][n];

        for(int i=0;i<queries.length;i++){
            int r1=queries[i][0];
            int c1=queries[i][1];
            int r2=queries[i][2];
            int c2=queries[i][3];

           mat[r1][c1]+=1;

           if(r2+1<n){
            mat[r2+1][c1]-=1;
           }
           if(c2+1<n){
            mat[r1][c2+1]-=1;
            if(r2+1<n){
                mat[r2+1][c2+1]+=1;
            }
           }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(mat[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        //vertical sumup
        for(int col=0;col<n;col++){
            for(int row=1;row<n;row++){
                mat[row][col]=mat[row-1][col]+mat[row][col];
            }
        }

        //horizontal sumup
        for(int row=0;row<n;row++){
            for(int col=1;col<n;col++){
                mat[row][col]=mat[row][col-1]+mat[row][col];
            }
        }

        return mat;
    }
}