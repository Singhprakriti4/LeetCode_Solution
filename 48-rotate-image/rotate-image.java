class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int outer=(n/2)-1;
        
        for(int i=0;i<=outer;i++){
            // set the limits
            int start=i;
            int end=n-1-i;
            //start from sr and sc and then rotate for 3 times (leving corners)

            //swap 01
            int fixedrow=i;
            int fixedcol=i;
            int col=end-1;

            for(int j=start+1;j<end;j++){
                int temp=matrix[j][fixedcol];
                matrix[j][fixedcol]=matrix[fixedrow][col];
                matrix[fixedrow][col]=temp;
                col-=1;
            }

            fixedrow=end;
            col=start+1;

            for(int j=start+1;j<end;j++){
                int temp=matrix[j][fixedcol];
                matrix[j][fixedcol]=matrix[fixedrow][col];
                matrix[fixedrow][col]=temp;
                col+=1;
            }

            fixedcol=end;
            col=end-1;
            for(int j=start+1;j<end;j++){
                int temp=matrix[j][fixedcol];
                matrix[j][fixedcol]=matrix[fixedrow][col];
                matrix[fixedrow][col]=temp;
                col-=1;
            }

            //swapping the corners
            int temp=matrix[start][end];
            matrix[start][end]=matrix[start][start];
            matrix[start][start]=temp;

            temp=matrix[start][start];
            matrix[start][start]=matrix[end][start];
            matrix[end][start]=temp;

            temp=matrix[end][start];
            matrix[end][start]=matrix[end][end];
            matrix[end][end]=temp;
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }

    }
}